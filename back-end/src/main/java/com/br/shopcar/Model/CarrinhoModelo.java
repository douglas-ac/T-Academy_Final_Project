package com.br.shopcar.Model;

import com.br.shopcar.Model.User.User;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "carrinhos")
public class CarrinhoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User usuario;
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

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
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
