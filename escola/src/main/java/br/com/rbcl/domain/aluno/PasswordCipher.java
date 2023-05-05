package br.com.rbcl.domain.aluno;

public interface PasswordCipher {
    String cipherPassword(String password);
    boolean validateCipherPassword(String cipherPassword, String password);
}
