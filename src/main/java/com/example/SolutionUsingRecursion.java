package com.example;

import java.util.*;

/**
 * Implementação de solução para o problema do dicionário alienígena usando abordagem recursiva.
 * Esta classe determina a ordem do alfabeto alienígena analisando a ordem das palavras em um dicionário.
 * 
 * O problema consiste em:
 * 1. Receber uma lista de palavras ordenadas segundo um alfabeto desconhecido
 * 2. Determinar a ordem das letras neste alfabeto
 * 3. Retornar uma string representando a ordem das letras
 *
 * @author Exemplo
 * @version 1.0
 */
public class SolutionUsingRecursion {
    
    /** Lista de palavras do dicionário alienígena */
    private String[] words;
    /** Grafo que representa as relações de ordem entre caracteres */
    private Map<Character, Set<Character>> graph;
    /** Conjunto de todos os caracteres únicos encontrados */
    private Set<Character> allChars;

    /**
     * Método principal para demonstração da solução.
     * 
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        SolutionUsingRecursion solution = new SolutionUsingRecursion(words);
        String order = solution.alienOrder();
        System.out.println(order);
    }

    /**
     * Construtor que inicializa a solução com uma lista de palavras.
     * 
     * @param words array de strings representando as palavras do dicionário alienígena
     */
    public SolutionUsingRecursion(String[] words) {
        this.words = words;
        this.graph = new HashMap<>();
        this.allChars = new HashSet<>();
    }

    /**
     * Determina a ordem do alfabeto alienígena baseado na lista de palavras fornecida.
     * 
     * @return uma string representando a ordem das letras no alfabeto alienígena,
     *         ou string vazia ("") se a ordem não puder ser determinada
     */
    public String alienOrder() {
        if (words == null || words.length == 0) return "";

        // Para uma única palavra, retorna os caracteres únicos em ordem
        if (words.length == 1) {
            LinkedHashSet<Character> uniqueChars = new LinkedHashSet<>();
            for (char c : words[0].toCharArray()) {
                uniqueChars.add(c);
            }
            StringBuilder result = new StringBuilder();
            for (char c : uniqueChars) {
                result.append(c);
            }
            return result.toString();
        }

        // Coleta todos os caracteres únicos
        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c);
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Verifica se há palavras inválidas na sequência
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            
            // Verifica se uma palavra maior vem antes de uma menor com mesmo prefixo
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            // Encontra o primeiro caractere diferente
            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }

        // Verifica se temos informações suficientes para determinar a ordenação completa
        if (!hasCompleteOrdering()) {
            return "";
        }

        return topologicalSort();
    }

    /**
     * Verifica se existe informação suficiente para determinar a ordem completa do alfabeto.
     * 
     * @return true se a ordem completa pode ser determinada, false caso contrário
     */
    private boolean hasCompleteOrdering() {
        // Para cada par de caracteres, precisamos ser capazes de determinar sua ordem relativa
        for (char c1 : allChars) {
            for (char c2 : allChars) {
                if (c1 != c2) {
                    // Se não podemos alcançar c2 a partir de c1 e não podemos alcançar c1 a partir de c2,
                    // então não sabemos sua ordem relativa
                    if (!canReach(c1, c2) && !canReach(c2, c1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Verifica se existe um caminho no grafo do caractere inicial até o caractere alvo.
     * 
     * @param start caractere inicial
     * @param target caractere alvo
     * @return true se existe um caminho de start até target, false caso contrário
     */
    private boolean canReach(char start, char target) {
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (current == target) {
                return true;
            }
            for (char next : graph.get(current)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        return false;
    }

    /**
     * Realiza a ordenação topológica do grafo para determinar a ordem do alfabeto.
     * Utiliza uma PriorityQueue para garantir a menor ordem lexicográfica possível.
     * 
     * @return string com a ordem das letras ou string vazia se houver ciclo no grafo
     */
    private String topologicalSort() {
        Map<Character, Integer> inDegree = new HashMap<>();
        
        // Inicializa graus de entrada
        for (char c : allChars) {
            inDegree.put(c, 0);
        }

        // Calcula graus de entrada
        for (char c : allChars) {
            for (char neighbor : graph.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }

        // Usa PriorityQueue para obter a ordenação válida lexicograficamente menor
        PriorityQueue<Character> queue = new PriorityQueue<>();
        for (char c : allChars) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char neighbor : graph.get(current)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Se não pudemos incluir todos os caracteres, pode haver uma ordenação inválida
        if (result.length() != allChars.size()) {
            return "";
        }

        return result.toString();
    }
} 