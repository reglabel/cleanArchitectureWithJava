package br.com.rbcl.domain.indication;

import br.com.rbcl.domain.aluno.Student;

import java.util.Date;

public class Indication {
    private Student indicator;
    private Student indicated;
    private Date dateIndication;

    public Indication(Student indicator, Student indicated) {
        this.indicator = indicator;
        this.indicated = indicated;
        this.dateIndication = new java.util.Date();
    }

    public Student getIndicator() {
        return indicator;
    }

    public Student getIndicated() {
        return indicated;
    }

    public Date getDateIndication() {
        return dateIndication;
    }
}
