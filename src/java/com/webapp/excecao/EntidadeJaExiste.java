package com.webapp.excecao;

public class EntidadeJaExiste extends Exception {
    
    public EntidadeJaExiste() {
        super();
    }
    
    public EntidadeJaExiste(String mensagem) {
        super(mensagem);
    }
    
    
}
