package com.webapp.negocio;

import com.webapp.entidade.Atividade;
import com.webapp.entidade.Empregado;
import com.webapp.excecao.EntidadeJaExiste;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IEmpregado {

    
    boolean criar (Empregado empregado) throws EntidadeJaExiste;
    boolean alterar (Long id, Empregado novoEmpregado);
    boolean deletar (Long id);
    List<Empregado> consultar();

    public void criar(String nome, double salario, Long cidadeId, List<Long> atividades);
    
}
