package com.webapp.negocio;

import com.webapp.entidade.Estado;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IEstado {
    
    boolean criar (String nome) throws EntidadeJaExiste;
    boolean alterar (Long id, String novoNome);
    boolean deletar (Long id);
    List<Estado> consultar();
}
