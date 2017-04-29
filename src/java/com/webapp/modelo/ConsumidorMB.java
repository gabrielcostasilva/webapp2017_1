package com.webapp.modelo;

import com.webapp.negocio.IConsumidor;
import com.webapp.entidade.Cidade;
import com.webapp.entidade.Consumidor;
import com.webapp.entidade.Estado;
import com.webapp.negocio.ICidade;
import com.webapp.negocio.IEstado;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConsumidorMB {

    @EJB
    private IEstado estadoBean;
    private Long estadoId;

    @EJB
    private ICidade cidadeBean;
    private List<Cidade> cidades;
    private Long cidadeId;

    @EJB
    private IConsumidor consumidorBean;

    private String nome;

    public List<Estado> getEstados() {
        return estadoBean.consultar();
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void onMudaEstado() {

        if (estadoId != null && estadoId != 0) {
            cidades = this.cidadeBean.consultar(estadoId);
        } else {
            cidades = new ArrayList<>();
        }
    }

    public String criar() {

        try {
            consumidorBean.criar(this.getNome(), this.getCidadeId());
            return "criado";
            
        } catch (Exception e) {
            System.out.println(e);
            return "erro";
        }

    }

    public List<Consumidor> consultar() {
        return consumidorBean.consultar();
    }
}
