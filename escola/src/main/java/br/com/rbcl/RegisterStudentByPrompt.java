package br.com.rbcl;

import br.com.rbcl.aplication.aluno.register.RegisterStudent;
import br.com.rbcl.aplication.aluno.register.RegisterStudentDTO;
import br.com.rbcl.domain.aluno.RepositoryOfStudents;
import br.com.rbcl.infra.aluno.RepositoryOsStudentsInMemory;

public class RegisterStudentByPrompt {
    public static void main(String[] args){
        String name = "Fulano Silva";
        String cpf = "123.456.789-00";
        String email = "fulano@email.com";

        RepositoryOfStudents repository = new RepositoryOsStudentsInMemory();

        RegisterStudent register = new RegisterStudent(repository);
        register.execute(new RegisterStudentDTO(name, cpf, email));

    }
}
