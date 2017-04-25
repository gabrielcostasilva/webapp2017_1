package com.webapp.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Recibo implements Serializable {
 
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private long numeroGerado;
    private double vrTotal;
    
    @OneToOne (fetch = FetchType.EAGER)
    private Pedido pedido;
    
    public Recibo() {
        super();
    }

    public Recibo(long numeroGerado, double vrTotal, Pedido pedido) {
        this();
        this.numeroGerado = numeroGerado;
        this.vrTotal = vrTotal;
        this.setPedido(pedido);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumeroGerado() {
        return numeroGerado;
    }

    public void setNumeroGerado(long numeroGerado) {
        this.numeroGerado = numeroGerado;
    }

    public double getVrTotal() {
        return vrTotal;
    }

    public void setVrTotal(double vrTotal) {
        this.vrTotal = vrTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recibo other = (Recibo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recibo{" + "id=" + id + ", numeroGerado=" + numeroGerado + ", vrTotal=" + vrTotal + '}';
    }
    
    
    
}
