package com.webapp.modelo;

import com.webapp.entidade.Atividade;
import com.webapp.entidade.Cidade;
import com.webapp.entidade.Empregado;
import com.webapp.entidade.Estado;
import com.webapp.negocio.IAtividade;
import com.webapp.negocio.ICidade;
import com.webapp.negocio.IEmpregado;
import com.webapp.negocio.IEstado;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class EmpregadoMB {

    @EJB
    private IEstado estadoBean;
    private Long estadoId;

    @EJB
    private ICidade cidadeBean;
    private List<Cidade> cidades;
    private Long cidadeId;

    private String nome;
    private double salario;

    @EJB
    private IEmpregado empregadoBean;

    @EJB
    private IAtividade atividadeBean;
    private Set<Long> atividadesID;
    private Long atividadeId;

    public EmpregadoMB() {
        super();
        atividadesID = new HashSet<>();
    }

    public void onMudaEstado() {

        if (estadoId != null && estadoId != 0) {
            cidades = this.cidadeBean.consultar(estadoId);
        } else {
            cidades = new ArrayList<>();
        }
    }

    public List<Atividade> getAtividades() {
        return atividadeBean.consultar();
    }

    public Long getAtividadeId() {
        return atividadeId;
    }

    public void setAtividadeId(Long atividadeId) {
        this.atividadeId = atividadeId;
    }

    public List<Estado> getEstados() {
        return estadoBean.consultar();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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

    public Set<Long> getAtividadesID() {
        return atividadesID;
    }

    public void setAtividadesID(Set<Long> atividadesID) {
        this.atividadesID = atividadesID;
    }

    public String criar() {

        try {
            empregadoBean.criar(this.getNome(), this.getSalario(), this.getCidadeId(), new ArrayList<>(this.getAtividadesID()));
            return "criado";

        } catch (Exception e) {
            System.out.println(e);
            return "erro";
        }

    }

    public List<Empregado> consultar() {
        return empregadoBean.consultar();
    }

    public void adicionarAtividade() {

        atividadesID.add(atividadeId);
    }
}
