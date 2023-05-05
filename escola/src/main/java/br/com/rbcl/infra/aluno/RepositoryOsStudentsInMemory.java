package br.com.rbcl.infra.aluno;

import br.com.rbcl.domain.aluno.CPF;
import br.com.rbcl.domain.aluno.RepositoryOfStudents;
import br.com.rbcl.domain.aluno.Student;
import br.com.rbcl.domain.aluno.StudentNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RepositoryOsStudentsInMemory implements RepositoryOfStudents {
    private List<Student> registered = new ArrayList<Student>();
    public void register(Student student) {
        this.registered.add(student);
    }

    public Student searchByCPF(CPF cpf) throws Throwable {
        return this.registered.stream().filter(new Predicate<Student>() {
                    public boolean test(Student a) {
                        return a.getCpf().equals(cpf.getNumber());
                    }
                })
                .findFirst()
                .orElseThrow(new Supplier<Throwable>() {
                    public Throwable get() {
                        return new StudentNotFound(cpf);
                    }
                });
    }

    public List<Student> listAllRegisteredStudents() {
        return this.registered;
    }
}
