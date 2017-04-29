package com.webapp.negocio;

import com.webapp.entidade.Consumidor;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IConsumidor {
    
    boolean criar (Consumidor consumidor) throws EntidadeJaExiste;
    boolean alterar (Long id, Consumidor novoConsumidor);
    boolean deletar (Long id);
    List<Consumidor> consultar();

    public void criar(String nome, Long cidadeId);
    
}
