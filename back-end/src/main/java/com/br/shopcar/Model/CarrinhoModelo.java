package com.br.shopcar.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrinhos")
public class CarrinhoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UsuarioModelo usuario;
    private double subTotal;
    private double desconto;

    @ManyToMany
    @JoinTable(
        name = "tabela_auxiliar",
        joinColumns = {@JoinColumn(name = "id_carrinho", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "id_produto", referencedColumnName = "id")}
    )
    private List<ProdutoModelo> produtos = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsuarioModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public List<ProdutoModelo> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoModelo> produtos) {
        this.produtos = produtos;
    }

}
