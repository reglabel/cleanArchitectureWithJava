package br.com.rbcl.infra.indication;

import br.com.rbcl.aplication.indication.SendEmailIndication;
import br.com.rbcl.domain.aluno.Student;

public class SendEmailIndicationWithJavaMail implements SendEmailIndication {
    @Override
    public void sendTo(Student indicated) {
        //logica de envio de emails com a lib Java Mail
    }
}
