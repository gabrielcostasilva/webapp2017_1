package com.webapp.negocio;

import com.webapp.entidade.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProdutoBean implements IProduto {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public boolean criar(String nome, double preco) {
        
        Produto p = new Produto();
        p.setNome(nome);
        p.setPreco(preco);
        
        try {
            em.persist(p);
            return true;
            
        } catch (Exception e) {
            System.out.println("Erro persistindo Produto");
            
        }
        
        return false;        
    }

    @Override
    public boolean alterar(Long id, String novoNome, double novoPreco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> consultar() {
        return 
                em.
                        createQuery(
                        "SELECT p FROM Produto p", 
                        Produto.class).getResultList();
    }
    
}
