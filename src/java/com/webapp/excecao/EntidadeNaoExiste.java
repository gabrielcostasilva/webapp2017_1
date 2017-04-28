package com.webapp.excecao;

public class EntidadeNaoExiste extends Exception {

    public EntidadeNaoExiste() {
        super();
    }
    
    public EntidadeNaoExiste(String mensagem) {
        super(mensagem);
    }
    
}
