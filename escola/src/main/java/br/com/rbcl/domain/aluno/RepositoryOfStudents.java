package br.com.rbcl.domain.aluno;

import java.util.List;

public interface RepositoryOfStudents {
    void register (Student student);
    Student searchByCPF(CPF cpf) throws Throwable;
    List<Student> listAllRegisteredStudents();
}
