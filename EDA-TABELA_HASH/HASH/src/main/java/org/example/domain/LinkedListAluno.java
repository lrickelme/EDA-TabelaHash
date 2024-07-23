package org.example.domain;

import org.example.Aluno;

public class LinkedListAluno {
    private NodeAluno inicio;
    private int tamanho;

    public LinkedListAluno() {
        this.inicio = null;
        this.tamanho = 0;
    }

    protected NodeAluno getInicio() {
        return inicio;
    }

    protected void setInicio(NodeAluno inicio) {
        this.inicio = inicio;
    }

    protected int getTamanho() {
        return tamanho;
    }

    protected void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(Aluno aluno) {
        NodeAluno novoNode = new NodeAluno(aluno);

        if (inicio == null) {
            inicio = novoNode;
            tamanho++;
            return;
        }

        NodeAluno currentNode = inicio;
        NodeAluno previousNode = null;

        while (currentNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        previousNode.setNext(novoNode);
        tamanho++;
    }

    public Aluno pegar(String matricula) {
        NodeAluno currentNode = inicio;

        while (currentNode != null) {
            if (currentNode.getAluno().getMatricula().equals(matricula)) {
                return currentNode.getAluno();
            }
            currentNode = currentNode.getNext();
        }
        throw new RuntimeException("Aluno não encontrado.");
    }

    public void remover(String matricula) {
        if (inicio == null) {
            return;
        }

        if (inicio.getAluno().getMatricula().equals(matricula)) {
            inicio = inicio.getNext();
            tamanho--;
            return;
        }

        NodeAluno currentNode = inicio;
        NodeAluno previousNode = null;

        while (currentNode != null && !currentNode.getAluno().getMatricula().equals(matricula)) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode == null) {
            throw new RuntimeException("Aluno não encontrado.");
        }

        if (previousNode != null) {
            previousNode.setNext(currentNode.getNext());
        }
        tamanho--;
    }

    public String listar() {
        StringBuilder stringBuilder = new StringBuilder();
        NodeAluno currentNode = getInicio();

        stringBuilder.append("[");
        while (currentNode != null) {
            stringBuilder.append(currentNode.getAluno());
            currentNode = currentNode.getNext();
            if (currentNode != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

class NodeAluno {
    private Aluno aluno;
    private NodeAluno next;

    public NodeAluno(Aluno aluno) {
        this.aluno = aluno;
        this.next = null;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public NodeAluno getNext() {
        return next;
    }

    public void setNext(NodeAluno next) {
        this.next = next;
    }
}
