package org.example.exception;

public class AlunoNotFoundException extends RuntimeException{
    public AlunoNotFoundException(String matricula) {
        super("Não foi possivel encontrar um aluno com a matricula: " + matricula);
    }
}
