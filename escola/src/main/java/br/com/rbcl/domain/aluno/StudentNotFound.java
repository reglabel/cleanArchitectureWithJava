package br.com.rbcl.domain.aluno;

public class StudentNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public StudentNotFound(CPF cpf) {
        super("Aluno nao encontrado com CPF: " + cpf.getNumber());
    }
}
