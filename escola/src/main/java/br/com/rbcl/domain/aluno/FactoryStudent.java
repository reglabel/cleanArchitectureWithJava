package br.com.rbcl.domain.aluno;

public class FactoryStudent {
    private Student student;

    public FactoryStudent withCPFNameAndEmail(String cpf, String name, String email){
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this; //permite encadeamento de métodos
    };

    public FactoryStudent withPhone(String phone){
        this.student.addPhone(new Phone(phone));
        return this;
    }

    public Student create(){
        return this.student;
    }
}
