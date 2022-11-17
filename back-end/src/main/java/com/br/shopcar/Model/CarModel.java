package com.br.shopcar.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class CarModel extends ProductModel {
    private double quilomatragem;
    private String modelo;

    public double getQuilomatragem() {
        return quilomatragem;
    }

    public void setQuilomatragem(double quilomatragem) {
        this.quilomatragem = quilomatragem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
