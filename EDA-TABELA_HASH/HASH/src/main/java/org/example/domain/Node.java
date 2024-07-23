package org.example.domain;

import org.example.Aluno;

public class Node {
    private Node proximo;
    private Aluno aluno;

    public Node(Node proximo, Aluno aluno) {
        this.proximo = proximo;
        this.aluno = aluno;
    }

    public Node(Aluno aluno) {
        this.proximo = null;
        this.aluno = aluno;
    }

    public Node getproximo() {
        return proximo;
    }

    public void setproximo(Node proximo) {
        this.proximo = proximo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
