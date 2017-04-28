package com.webapp.modelo;

import com.webapp.entidade.Cidade;
import com.webapp.entidade.Estado;
import com.webapp.excecao.EntidadeJaExiste;
import com.webapp.excecao.EntidadeNaoExiste;
import com.webapp.negocio.ICidade;
import com.webapp.negocio.IEstado;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CidadeMB {
    
    private String nome;
    private Long estadoId;
    
    @EJB
    private IEstado estadoBean;
    
    @EJB
    private ICidade cidadeBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }


    
    public List<Estado> consultarEstados() {
        return estadoBean.consultar();
    }
    
    public List<Cidade> consultar() {
        return cidadeBean.consultar();
    }
    
    public String criar() {
        
        try {
            cidadeBean.criar(this.getNome(), this.getEstadoId());
            return "criado";
                        
        } catch (Exception e) {
            System.out.println(e);
            return "erro";
            
        }
        
    }
    
    
}
