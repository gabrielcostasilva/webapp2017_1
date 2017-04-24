package com.webapp.negocio;

import com.webapp.entidade.Produto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IProduto {
    
    boolean criar (String nome, double preco);
    boolean alterar (Long id, String novoNome, double novoPreco);
    boolean deletar (Long id);
    List<Produto> consultar();
    
}
