package com.webapp.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

@Entity
public class Consumidor extends Pessoa implements Serializable {
    
    @ElementCollection (fetch = FetchType.EAGER)
    private List<String> telefone;
    
    @Enumerated (EnumType.STRING)
    private Status statusConsumidor;
    
    public Consumidor() {
        super();
    }

    public List<String> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<String> telefone) {
        this.telefone = telefone;
    }

    public Status getStatusConsumidor() {
        return statusConsumidor;
    }

    public void setStatusConsumidor(Status statusConsumidor) {
        this.statusConsumidor = statusConsumidor;
    }
    
    
    
    
    
}
