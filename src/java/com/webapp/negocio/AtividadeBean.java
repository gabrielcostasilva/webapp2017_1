package com.webapp.negocio;

import com.webapp.entidade.Atividade;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AtividadeBean implements IAtividade {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean criar(Atividade atividade) throws EntidadeJaExiste {
        
        // Verifica se a atividade já existe - sem usar Java 8
        for (Atividade a: this.consultar())
            if (a.getDescricao().equalsIgnoreCase(atividade.getDescricao()))
                throw new EntidadeJaExiste("Atividade já existe!");
        
        em.persist(atividade);
        
        return true;
    }

    @Override
    public boolean alterar(Long id, String novaDescricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atividade> consultar() {
        return em.createQuery("SELECT a FROM Atividade a", Atividade.class).getResultList();
    }
    
}
