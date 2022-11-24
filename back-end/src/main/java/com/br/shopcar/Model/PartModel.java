package com.br.shopcar.Model;

import com.br.shopcar.Dto.GET.PartDto;
import com.br.shopcar.enums.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("2")
public class PartModel extends ProductModel {
    private Condition part_condition;
    private String brand;
    private String vehicle_type;

    public PartDto convertToDto(){
        PartDto partDto = super.convertToDto(new PartDto());

        partDto.setPart_condition(this.getPart_condition());
        partDto.setBrand(this.getBrand());
        partDto.setVehicle_type(this.getVehicle_type());

        return partDto;
    }
}
