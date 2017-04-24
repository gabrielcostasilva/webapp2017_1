package com.webapp.modelo;

import com.webapp.negocio.IProduto;
import com.webapp.entidade.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class ProdutoMB {
    
    private String nome;
    private double preco;
    
    @EJB
    private IProduto produtoBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String criar() {
        
        if (produtoBean.criar(this.getNome(), this.getPreco()))
            return "criado";
        
        else
            return "erro";
    }
    
    public List<Produto> consultar() {
        return produtoBean.consultar();
    }
    
    
    
}
