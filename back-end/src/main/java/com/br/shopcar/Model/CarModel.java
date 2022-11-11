package com.br.shopcar.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class CarModel extends ProductModel {
    private double km;
    private String model;

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
