package com.br.shopcar.Model;

import com.br.shopcar.Dto.GET.CarDto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("1")
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

    public CarDto convertToDto(){
        CarDto carDto = new CarDto();
        carDto.setId(this.getId());
        carDto.setNome(this.getNome());
        carDto.setDescricao(this.getDescricao());
        carDto.setPreco(this.getPreco());
        carDto.setQuilomatragem(this.getQuilomatragem());
        carDto.setModelo(this.getModelo());
        return carDto;
    }
}
