package org.example.domain;

import org.example.Aluno;
import org.example.exception.AlunoNotFoundException;

public class TabelaHash {
    private LinkedListAluno[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tabela = new LinkedListAluno[tamanho];
        this.tamanho = tamanho;
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedListAluno();
        }
    }

    private int calcularHash(String matricula) {
        return Integer.parseInt(matricula) % tamanho;
    }

    public void inserirValor(Aluno aluno) {
        int index = calcularHash(aluno.getMatricula());
        tabela[index].adicionar(aluno);
    }

    public String pegarValor(String matricula) {
        int index = calcularHash(matricula);
        try {
            return tabela[index].pegar(matricula).getNome();
        } catch (RuntimeException e) {
            throw new AlunoNotFoundException(matricula);
        }
    }

    public void removerValor(String matricula) {
        int index = calcularHash(matricula);
        try {
            tabela[index].remover(matricula);
        } catch (RuntimeException e) {
            throw new AlunoNotFoundException(matricula);
        }
    }

    public String listar() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(i).append(": ").append(tabela[i].listar());
            if (i < tamanho - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}