package com.webapp.negocio;

import com.webapp.entidade.Cidade;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CidadeBean implements ICidade {

    @PersistenceContext
    private EntityManager em;

    @Override
    public boolean criar(String nome, Long idEstado) throws EntidadeJaExiste {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

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
        return em.createQuery("SELECT Cidade c FROM Cidade", Cidade.class).getResultList();
    }

}
