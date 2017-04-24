package com.webapp.modelo;

import com.webapp.entidade.Estado;
import com.webapp.excecao.EntidadeJaExiste;
import com.webapp.negocio.IEstado;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EstadoMB {
    
    private String nome;
    
    @EJB
    private IEstado estadoBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }
    
    public String criar() {
        
        try {
            estadoBean.criar(this.getNome());
            return "criado";
            
        } catch (EntidadeJaExiste e) {
            return "entidadeJaExiste";
            
        } catch (Exception e) {
            return "erro";
            
        }
        
    }
    
    public List<Estado> consultar() {
        return estadoBean.consultar();
    }
    
}
