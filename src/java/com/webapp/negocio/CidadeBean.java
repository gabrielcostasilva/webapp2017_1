package com.webapp.negocio;

import com.webapp.excecao.EntidadeNaoExiste;
import com.webapp.entidade.Cidade;
import com.webapp.entidade.Estado;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CidadeBean implements ICidade {

    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private IEstado estadoBean;
   

    @Override
    public boolean criar(String nome, Long idEstado) throws EntidadeJaExiste, EntidadeNaoExiste {
        
        // Descobre o estado que tem esse ID
        Estado estado = null;
        
        for (Estado e: estadoBean.consultar())
            if (e.getId() == idEstado)
                estado = e;
        
        // Finalmente, persiste
        Cidade cidade = new Cidade();
        cidade.setNome(nome);
        cidade.setEstado(estado);
        
        em.persist(cidade);
        
        return true;
        
    }

    @Override
    public boolean alterar(Long id, String novoNome, Long idNovoEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cidade> consultar() {
        return em.createQuery("SELECT c FROM Cidade c", Cidade.class).getResultList();
    }

    @Override
    public List<Cidade> consultar(Long estadoId) {
        return em.createQuery("SELECT c FROM Cidade c WHERE c.estado.id = " + estadoId, Cidade.class).getResultList();
    }
}
