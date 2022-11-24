package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.CarModel;
import lombok.Data;

@Data
public class CarDto extends ProductDto {
    private double quilometragem;
    private String color;

    public CarModel convertToModel(){
        CarModel carModel = super.convertToModel(new CarModel());

        carModel.setQuilometragem(this.getQuilometragem());
        carModel.setColor(this.getColor());

        return carModel;
    }
}
