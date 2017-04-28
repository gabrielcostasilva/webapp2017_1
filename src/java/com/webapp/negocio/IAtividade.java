package com.webapp.negocio;

import com.webapp.entidade.Atividade;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IAtividade {
    
    boolean criar (Atividade atividade) throws EntidadeJaExiste;
    boolean alterar (Long id, String novaDescricao);
    boolean deletar (Long id);
    List<Atividade> consultar();
    
}
