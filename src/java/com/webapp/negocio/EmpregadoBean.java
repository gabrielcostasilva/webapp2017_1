package com.webapp.negocio;

import com.webapp.entidade.Atividade;
import com.webapp.entidade.Cidade;
import com.webapp.entidade.Empregado;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmpregadoBean implements IEmpregado {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private ICidade cidadeBean;

    @EJB
    private IAtividade atividadeBean;

    @Override
    public boolean criar(Empregado empregado) throws EntidadeJaExiste {

        em.persist(empregado);
        return true;
    }

    @Override
    public void criar(String nome, double salario, Long cidadeId, List<Long> atividades) {

        Empregado empregado = new Empregado();
        empregado.setNome(nome);
        empregado.setSalario(salario);

        Optional<Cidade> cidade = cidadeBean.consultar().stream().filter(e -> e.getId().equals(cidadeId)).findFirst();
        empregado.setCidade(cidade.get());
        
        List<Atividade> listaAtividades = new ArrayList<>();
        for (Long idAtividade: atividades) 
            listaAtividades.add(atividadeBean.consultar().stream().filter(e -> e.getId().equals(idAtividade)).findFirst().get());
        
        empregado.setAtividades(listaAtividades);
        
        try {
            this.criar(empregado);
            
        } catch (EntidadeJaExiste ex) {
            System.out.println("ex");
            
        }
    }

    @Override

    public boolean alterar(Long id, Empregado novoEmpregado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empregado> consultar() {
        return em.createQuery("SELECT e FROM Empregado e", Empregado.class).getResultList();
    }

}
