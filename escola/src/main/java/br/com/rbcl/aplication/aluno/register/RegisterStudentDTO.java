package br.com.rbcl.aplication.aluno.register;

import br.com.rbcl.domain.aluno.CPF;
import br.com.rbcl.domain.aluno.Email;
import br.com.rbcl.domain.aluno.Student;

public class RegisterStudentDTO {
    private String nameStudent;
    private String cpfStudent;
    private String emailStudent;

    public RegisterStudentDTO(String nameStudent, String cpfStudent, String emailStudent) {
        this.nameStudent = nameStudent;
        this.cpfStudent = cpfStudent;
        this.emailStudent = emailStudent;
    }

    public Student getStudent() {
        return new Student(new CPF(cpfStudent), nameStudent, new Email(emailStudent));
    }
}
