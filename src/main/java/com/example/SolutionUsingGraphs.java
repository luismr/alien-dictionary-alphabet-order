package com.example;

import java.util.*;

/**
 * Implementação de solução para o problema do dicionário alienígena usando teoria dos grafos.
 * Esta classe utiliza um grafo direcionado e ordenação topológica para determinar a ordem
 * do alfabeto alienígena.
 * 
 * O problema consiste em:
 * 1. Receber uma lista de palavras ordenadas segundo um alfabeto desconhecido
 * 2. Construir um grafo direcionado representando as relações de ordem entre as letras
 * 3. Realizar uma ordenação topológica para determinar a ordem completa do alfabeto
 *
 * @author Exemplo
 * @version 1.0
 */
public class SolutionUsingGraphs {
    
    /** Lista de palavras do dicionário alienígena */
    private String[] words;
    /** Grafo que representa as relações de ordem entre caracteres */
    private Map<Character, Set<Character>> graph;
    /** Mapa que armazena o grau de entrada de cada vértice */
    private Map<Character, Integer> inDegree;
    /** Conjunto de todos os caracteres únicos encontrados */
    private Set<Character> allChars;

    /**
     * Método principal para demonstração da solução.
     * 
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // Exemplo de palavras no dicionário alienígena
        String[] words = {"fe", "fa", "eea", "eaf", "zef", "daf", "dz"};
        SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
        String order = solution.alienOrder();
        System.out.println(order); 
    }

    /**
     * Construtor que inicializa a solução com uma lista de palavras.
     * 
     * @param words array de strings representando as palavras do dicionário alienígena
     */
    public SolutionUsingGraphs(String[] words) {
        this.words = words;
        this.graph = new HashMap<>();
        this.inDegree = new HashMap<>();
        this.allChars = new HashSet<>();
    }

    /**
     * Determina a ordem do alfabeto alienígena baseado na lista de palavras fornecida.
     * Utiliza uma abordagem de teoria dos grafos com ordenação topológica.
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

        // Inicializa o grafo e coleta todos os caracteres
        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c);
                graph.putIfAbsent(c, new HashSet<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Constrói o grafo
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Verifica se uma palavra maior vem antes de seu prefixo
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            // Encontra o primeiro caractere diferente
            int minLen = Math.min(word1.length(), word2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        // Verifica se temos informações suficientes para determinar a ordenação completa
        if (!hasCompleteOrdering()) {
            return "";
        }

        // Realiza a ordenação topológica
        StringBuilder result = new StringBuilder();
        PriorityQueue<Character> queue = new PriorityQueue<>();

        // Adiciona todos os nós sem arestas de entrada
        for (char c : allChars) {
            if (inDegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.append(current);

            for (char next : graph.get(current)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        // Verifica se temos uma ordenação válida
        if (result.length() != allChars.size()) {
            return "";
        }

        return result.toString();
    }

    /**
     * Verifica se existe informação suficiente para determinar a ordem completa do alfabeto.
     * 
     * @return true se a ordem completa pode ser determinada, false caso contrário
     */
    private boolean hasCompleteOrdering() {
        for (char c1 : allChars) {
            for (char c2 : allChars) {
                if (c1 != c2) {
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
     * Utiliza busca em largura (BFS) para encontrar o caminho.
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
}

