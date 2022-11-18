package com.br.shopcar.Model;

import com.br.shopcar.Dto.GET.CarDto;
import com.br.shopcar.Dto.GET.PartDto;
import com.br.shopcar.enums.Automaker;
import com.br.shopcar.enums.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("2")
public class PartModel extends ProductModel {
    private Condition part_condition;
    private String category;
    private Automaker automaker;

    public PartDto convertToDto(){
        PartDto partDto = new PartDto();
        partDto.setId(this.getId());
        partDto.setNome(this.getNome());
        partDto.setDescricao(this.getDescricao());
        partDto.setPreco(this.getPreco());
        partDto.setPart_condition(this.getPart_condition());
        partDto.setAutomaker(this.getAutomaker());
        partDto.setCategory(this.getCategory());
        return partDto;
    }
}
