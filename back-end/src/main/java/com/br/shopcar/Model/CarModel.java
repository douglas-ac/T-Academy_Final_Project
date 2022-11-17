package com.br.shopcar.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.br.shopcar.Dto.GET.CarDto;

@Entity
@Table(name = "cars")
public class CarModel extends ProductModel {
    private double quilometragem;
    private String modelo;

    public CarDto converterDto() {
        CarDto carDto = new CarDto();

        carDto.setId(this.getId());
        carDto.setNome(this.getNome());
        carDto.setDescricao(this.getDescricao());
        carDto.setPreco(this.getPreco());
        carDto.setQuilometragem(this.getQuilometragem());
        carDto.setModelo(this.getModelo());

        return carDto;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
