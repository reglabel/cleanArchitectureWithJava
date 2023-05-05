package br.com.rbcl.aplication.aluno.register;

import br.com.rbcl.domain.aluno.RepositoryOfStudents;
import br.com.rbcl.domain.aluno.Student;

public class RegisterStudent {
    private final RepositoryOfStudents repository;

    public RegisterStudent(RepositoryOfStudents repository) {
        this.repository = repository;
    }

    public void execute(RegisterStudentDTO register){
        Student newStudent = register.getStudent();
        repository.register(newStudent);
    }
}
