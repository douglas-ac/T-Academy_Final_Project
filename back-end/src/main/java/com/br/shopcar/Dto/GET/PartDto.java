package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.PartModel;
import com.br.shopcar.enums.Condition;
import lombok.Data;

@Data
public class PartDto extends ProductDto {
    private Condition part_condition;
    private String brand;
    private String vehicle_type;

    public PartModel convertToModel(){
        PartModel partModel = super.convertToModel(new PartModel());

        partModel.setPart_condition(this.getPart_condition());
        partModel.setBrand(this.getBrand());
        partModel.setVehicle_type(this.getVehicle_type());

        return partModel;
    }
}
