package com.webapp.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Empregado extends Pessoa implements Serializable{
    
    private double salario;
    
    @ManyToMany (fetch = FetchType.EAGER)
    private List<Atividade> atividades;
    
    public Empregado() {
        super();
    }

    public Empregado(double salario, List<Atividade> atividades) {
        this();
        this.salario = salario;
        this.atividades = atividades;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    
}
