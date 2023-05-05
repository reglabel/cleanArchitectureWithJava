package br.com.rbcl.aplication.indication;

import br.com.rbcl.domain.aluno.Student;

public interface SendEmailIndication {
    void sendTo(Student indicated);
}
