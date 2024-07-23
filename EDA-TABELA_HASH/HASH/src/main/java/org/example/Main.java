package org.example;

import org.example.domain.TabelaHash;
import org.example.exception.AlunoNotFoundException;

public class Main {
    public static void main(String[] args) {
  
        TabelaHash tabela = new TabelaHash(10);

        tabela.inserirValor(new Aluno("Alan", "123"));
        tabela.inserirValor(new Aluno("Vinicius", "456"));
        tabela.inserirValor(new Aluno("Hugo", "789"));
        tabela.inserirValor(new Aluno("Isaac", "101112"));
        tabela.inserirValor(new Aluno("Lucas ", "131415"));


        System.out.println("Tabela Hash:");
        System.out.println(tabela.listar());

        try {
            System.out.println("Buscar aluno com matrícula 123: " + tabela.pegarValor("123"));
            System.out.println("Buscar aluno com matrícula 456: " + tabela.pegarValor("456"));
        } catch (AlunoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        tabela.removerValor("456");
        System.out.println("Tabela Hash após remover aluno com matrícula 456:");
        System.out.println(tabela.listar());

        try {
            System.out.println("Buscar aluno com matrícula 456: " + tabela.pegarValor("456"));
        } catch (AlunoNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Buscar aluno com matrícula 999: " + tabela.pegarValor("999"));
        } catch (AlunoNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
