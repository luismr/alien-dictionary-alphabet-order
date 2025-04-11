# Alien Dictionary Alphabet Order

[![Java](https://img.shields.io/badge/Java-8-blue.svg)](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html)
[![Maven](https://img.shields.io/badge/Maven-3.x-blue.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5.x-blue.svg)](https://junit.org/junit5/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE.md)

[English](#english) | [Português](#português)

## Index
- [English](#english)
  - [Description](#description)
  - [Motivation](#motivation)
  - [Problem Statement](#problem-statement)
  - [Quick Start](#quick-start)
    - [Clone the Repository](#clone-the-repository)
    - [Building and Testing](#building-and-testing)
    - [Contributing](#contributing)
  - [Implementations](#implementations)
    - [Graph-Based Solution](#1-graph-based-solution-solutionusinggraphs)
    - [Recursive Solution](#2-recursive-solution-solutionusingrecursion)
  - [Usage Example](#usage-example)
  - [Special Cases](#special-cases)
  - [License](#license)
  - [Author](#author)
- [Português](#português)
  - [Descrição](#descrição)
  - [Motivação](#motivação)
  - [Definição do Problema](#definição-do-problema)
  - [Início Rápido](#início-rápido)
    - [Clonar o Repositório](#clonar-o-repositório)
    - [Compilação e Testes](#compilação-e-testes)
    - [Como Contribuir](#como-contribuir)
  - [Implementações](#implementações)
  - [Exemplo de Uso](#exemplo-de-uso)
  - [Casos Especiais](#casos-especiais)
  - [Licença](#licença)
  - [Autor](#autor)

## English

### Description
This project provides two different implementations to solve the Alien Dictionary Order problem. Given a sorted list of words in an alien language that follows some unknown ordering of letters, the goal is to find the order of letters in this alien alphabet.

### Motivation
I faced this puzzle during an interview, and after experiencing a considerable amount of shame and humiliation, I decided to thoroughly understand the problem and share the solution. After truly understanding the statement, it became easier to realize different paths to solve the problem. This project is born from that experience, aiming to help others who might face similar challenges.

### Problem Statement
Given a list of words sorted lexicographically by the rules of an alien language, determine the order of the alphabet in that language.

### Quick Start

#### Clone the Repository
```bash
git clone git@github.com:luismr/alien-dictionary-alphabet-order.git
cd alien-dictionary-alphabet-order
```

#### Building and Testing
```bash
# Build the project
mvn clean install

# Run tests
mvn test
```

#### Contributing
1. Fork the repository
2. Create your feature branch
   ```bash
   git checkout -b feature/amazing-feature
   ```
3. Commit your changes
   ```bash
   git commit -m 'Add some amazing feature'
   ```
4. Push to the branch
   ```bash
   git push origin feature/amazing-feature
   ```
5. Open a Pull Request

### Implementations

#### 1. Graph-Based Solution (`SolutionUsingGraphs`)
- Uses directed graph and topological sorting
- Maintains in-degree count for each vertex
- Implements BFS for path finding
- Uses `PriorityQueue` for lexicographically smallest valid ordering

#### 2. Recursive Solution (`SolutionUsingRecursion`)
- Uses recursive approach with graph representation
- Implements character relationship analysis
- Uses topological sorting for final ordering
- Handles edge cases like single words and invalid sequences

### Usage Example
```java
// Using Graph-based solution
String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
String order = solution.alienOrder();
System.out.println(order);  // Output: "wertf"

// Using Recursive solution
SolutionUsingRecursion recursiveSolution = new SolutionUsingRecursion(words);
String recursiveOrder = recursiveSolution.alienOrder();
System.out.println(recursiveOrder);  // Output: "wertf"
```

### Special Cases
1. Single word input: Returns unique characters in order
2. Empty input: Returns empty string
3. Invalid sequence: Returns empty string
4. Prefix violation: Returns empty string

### License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

### Author
**Luis Machado Reis**
- GitHub: [@luismr](https://github.com/luismr)
- LinkedIn: [Luis Machado Reis](https://www.linkedin.com/in/luismr/)

## Português

### Descrição
Este projeto fornece duas implementações diferentes para resolver o problema da Ordem do Dicionário Alienígena. Dado uma lista ordenada de palavras em uma língua alienígena que segue uma ordenação desconhecida de letras, o objetivo é encontrar a ordem das letras neste alfabeto alienígena.

### Motivação
Enfrentei este puzzle durante uma entrevista e, após passar por considerável vergonha e humilhação, decidi entender completamente o problema e compartilhar a solução. Depois de verdadeiramente compreender o enunciado, tornou-se mais fácil perceber diferentes caminhos para resolver o problema. Este projeto nasceu dessa experiência, visando ajudar outros que possam enfrentar desafios semelhantes.

### Definição do Problema
Dada uma lista de palavras ordenadas lexicograficamente pelas regras de uma língua alienígena, determinar a ordem do alfabeto nessa língua.

### Início Rápido

#### Clonar o Repositório
```bash
git clone git@github.com:luismr/alien-dictionary-alphabet-order.git
cd alien-dictionary-alphabet-order
```

#### Compilação e Testes
```bash
# Compilar o projeto
mvn clean install

# Executar testes
mvn test
```

#### Como Contribuir
1. Faça um fork do repositório
2. Crie sua branch de feature
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Faça commit das suas alterações
   ```bash
   git commit -m 'Adiciona nova funcionalidade'
   ```
4. Envie para a branch
   ```bash
   git push origin feature/nova-funcionalidade
   ```
5. Abra um Pull Request

### Implementações

#### 1. Solução Baseada em Grafos (`SolutionUsingGraphs`)
- Utiliza grafo direcionado e ordenação topológica
- Mantém contagem de grau de entrada para cada vértice
- Implementa BFS para busca de caminhos
- Usa `PriorityQueue` para obter a menor ordenação lexicográfica válida

#### 2. Solução Recursiva (`SolutionUsingRecursion`)
- Utiliza abordagem recursiva com representação em grafo
- Implementa análise de relacionamento entre caracteres
- Usa ordenação topológica para ordenação final
- Trata casos especiais como palavras únicas e sequências inválidas

### Exemplo de Uso
```java
// Usando solução baseada em Grafos
String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
SolutionUsingGraphs solution = new SolutionUsingGraphs(words);
String order = solution.alienOrder();
System.out.println(order);  // Saída: "wertf"

// Usando solução Recursiva
SolutionUsingRecursion recursiveSolution = new SolutionUsingRecursion(words);
String recursiveOrder = recursiveSolution.alienOrder();
System.out.println(recursiveOrder);  // Saída: "wertf"
```

### Casos Especiais
1. Entrada com uma única palavra: Retorna caracteres únicos em ordem
2. Entrada vazia: Retorna string vazia
3. Sequência inválida: Retorna string vazia
4. Violação de prefixo: Retorna string vazia

### Licença
Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE.md](LICENSE.md) para obter detalhes.

### Autor
**Luis Machado Reis**
- GitHub: [@luismr](https://github.com/luismr)
- LinkedIn: [Luis Machado Reis](https://www.linkedin.com/in/luismr/)

## Development

- Java 8 JDK
- Maven 3.x

## Building the Project

To build the project, run:

```bash
mvn clean install
```

## Running Tests

To run the tests:

```bash
mvn test
```

## Project Structure

- `src/main/java`: Source files
- `src/test/java`: Test files
- `target`: Compiled files (generated) 