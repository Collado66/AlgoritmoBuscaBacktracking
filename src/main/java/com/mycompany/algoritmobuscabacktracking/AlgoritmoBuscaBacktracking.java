/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmobuscabacktracking;

/**
 *
 * @author marce
 */



import java.util.*;

class Grafo {
    private int numVertices; // Número de vértices
    private LinkedList<Integer> adjList[]; // Lista de adjacência

    // Construtor
    Grafo(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Adiciona uma aresta ao grafo
    void adicionarAresta(int origem, int destino) {
        adjList[origem].add(destino);
        adjList[destino].add(origem); // Para grafos não direcionados
    }

    // Encontra todos os caminhos do vértice origem ao vértice destino usando backtracking
    void encontrarTodosOsCaminhos(int origem, int destino) {
        boolean[] visitado = new boolean[numVertices];
        List<Integer> caminho = new ArrayList<>();
        caminho.add(origem);
        encontrarTodosOsCaminhosUtil(origem, destino, visitado, caminho);
    }

    // Função auxiliar de backtracking
    private void encontrarTodosOsCaminhosUtil(int atual, int destino, boolean[] visitado, List<Integer> caminho) {
        // Marca o vértice atual como visitado
        visitado[atual] = true;

        // Se o vértice atual é o destino, imprime o caminho
        if (atual == destino) {
            System.out.println(caminho);
            visitado[atual] = false; // Desmarca o vértice antes de retornar
            return;
        }

        // Explora todos os vizinhos do vértice atual
        for (int vizinho : adjList[atual]) {
            if (!visitado[vizinho]) {
                caminho.add(vizinho);
                encontrarTodosOsCaminhosUtil(vizinho, destino, visitado, caminho);
                caminho.remove(caminho.size() - 1); // Remove o vértice do caminho
            }
        }

        // Desmarca o vértice atual antes de retornar
        visitado[atual] = false;
    }
}

public class AlgoritmoBuscaBacktracking {
    public static void main(String[] args) {
        Grafo g = new Grafo(5);

        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 4);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(1, 4);
        g.adicionarAresta(2, 3);
        g.adicionarAresta(3, 4);
        g.adicionarAresta(4, 2);

        System.out.println("Todos os caminhos do vértice 0 ao vértice 3:");

        g.encontrarTodosOsCaminhos(0, 3);
    }
}
