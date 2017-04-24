package com.webapp.negocio;

import com.webapp.entidade.Cidade;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICidade {

    boolean criar(String nome, Long idEstado) throws EntidadeJaExiste;
    boolean alterar(Long id, String novoNome, Long idNovoEstado);
    boolean deletar(Long id);
    List<Cidade> consultar();
}
