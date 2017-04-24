package com.webapp.negocio;

import com.webapp.entidade.Estado;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstadoBean implements IEstado {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean criar(String nome) throws EntidadeJaExiste {

        if (this.consultar().stream().anyMatch(e -> e.getNome().equalsIgnoreCase(nome))) {
            throw new EntidadeJaExiste();
            
        } else {
            Estado estado = new Estado(nome);
            em.persist(estado);
            return true;
        }
    }

    @Override
    public boolean alterar(Long id, String novoNome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public List<Estado> consultar() {
        return em.createQuery("SELECT e FROM Estado e", Estado.class).getResultList();
    }

}
