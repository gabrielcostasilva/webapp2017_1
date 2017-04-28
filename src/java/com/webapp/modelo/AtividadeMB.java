package com.webapp.modelo;

import com.webapp.negocio.IAtividade;
import com.webapp.entidade.Atividade;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AtividadeMB {
    
    private Atividade atividade;
    
    @EJB
    private IAtividade atividadeBean;
    
    public AtividadeMB() {
        super();
        atividade = new Atividade();
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
public String criar() {
        
        try {
            atividadeBean.criar (this.getAtividade());
            return "criado";
            
        } catch (EntidadeJaExiste e) {
            return "entidadeJaExiste";
            
        } catch (Exception e) {
            return "erro";
            
        }
        
    }
    
    public List<Atividade> consultar() {
        return atividadeBean.consultar();
    }    
}
