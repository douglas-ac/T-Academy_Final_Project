package br.com.projeto_final.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "carros")
public class CarroModelo extends ProdutoModelo {
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
