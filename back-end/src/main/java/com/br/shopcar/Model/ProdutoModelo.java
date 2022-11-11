package com.br.shopcar.Model;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.Entity;
import javax.persistence.*;
//import javax.persistence.Table;

/*
 * @Entity
 * @Table(name = "produtos")
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class ProdutoModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private double preco;

    @ManyToMany(mappedBy = "produtos")
    private List<CarrinhoModelo> carrinhos = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
