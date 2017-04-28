package com.webapp.negocio;

import com.webapp.entidade.Cidade;
import com.webapp.excecao.EntidadeJaExiste;
import com.webapp.excecao.EntidadeNaoExiste;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICidade {

    boolean criar(String nome, Long idEstado) throws EntidadeJaExiste, EntidadeNaoExiste;
    boolean alterar(Long id, String novoNome, Long idNovoEstado);
    boolean deletar(Long id);
    List<Cidade> consultar();
}
