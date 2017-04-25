package com.webapp.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Consumidor extends Pessoa implements Serializable {
    
    @ElementCollection
    private List<String> telefone;
    
    @Enumerated (EnumType.STRING)
    private Status statusConsumidor;
    
    public Consumidor() {
        super();
    }
    
    
    
}
