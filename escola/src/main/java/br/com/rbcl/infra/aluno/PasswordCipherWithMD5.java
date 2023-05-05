package br.com.rbcl.infra.aluno;

import br.com.rbcl.domain.aluno.PasswordCipher;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCipherWithMD5 implements PasswordCipher {
    @Override
    public String cipherPassword(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash de senha");
        }
    }

    @Override
    public boolean validateCipherPassword(String cipherPassword, String password) {
        return cipherPassword.equals(cipherPassword(password));
    }
}
