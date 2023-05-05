package br.com.rbcl.aluno;

import java.util.ArrayList;
import java.util.List;

public class Student {
    // ENTIDADE -> tenho um atributo que é único e permite diferenciar entidades.
    private CPF cpf;
    private String name;
    private Email email;
    private List<Phone> phones = new ArrayList<Phone>();

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    public void addPhone(Phone phone){
        this.phones.add(phone);
    }

    public CPF getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
