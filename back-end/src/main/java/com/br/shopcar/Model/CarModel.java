package com.br.shopcar.Model;

import com.br.shopcar.Dto.GET.CarDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class CarModel extends ProductModel {
    private double quilometragem;
    private String color;


    public CarDto convertToDto(){
        CarDto carDto = super.convertToDto(new CarDto());

        carDto.setQuilometragem(this.getQuilometragem());
        carDto.setColor(this.getColor());

        return carDto;
    }
}
