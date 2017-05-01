package com.webapp.negocio;

import com.webapp.entidade.Cidade;
import com.webapp.entidade.Consumidor;
import com.webapp.entidade.Status;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ConsumidorBean implements IConsumidor {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private ICidade cidadeBean;

    @Override
    public boolean criar(Consumidor consumidor) throws EntidadeJaExiste {

        try {
            em.persist(consumidor);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public void criar(String nome, Long cidadeId, List<String> telefones) {
        Consumidor consumidor = new Consumidor();
        consumidor.setStatusConsumidor(Status.ATIVO);
        
        consumidor.setNome(nome);
        consumidor.setTelefone(telefones);

        Optional<Cidade> cidade = cidadeBean.consultar().stream().filter(e -> e.getId().equals(cidadeId)).findFirst();
        consumidor.setCidade(cidade.get());
        
        try {
            this.criar(consumidor);
            
        } catch (Exception e) {
            System.out.println(e);
            
        }
        
    }


    @Override
    public boolean alterar(Long id, Consumidor novoConsumidor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consumidor> consultar() {
        return em.createQuery("SELECT co FROM Consumidor co", Consumidor.class).getResultList();
    }


}
