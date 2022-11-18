package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.PartModel;
import com.br.shopcar.enums.Automaker;
import com.br.shopcar.enums.Condition;
import lombok.Data;

@Data
public class PartDto {

    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private Condition part_condition;
    private String category;
    private Automaker automaker;

    public PartModel convertToModel(){
        PartModel partModel = new PartModel();
        partModel.setId(this.getId());
        partModel.setNome(this.getNome());
        partModel.setDescricao(this.getDescricao());
        partModel.setPreco(this.getPreco());
        partModel.setPart_condition(this.getPart_condition());
        partModel.setCategory(this.getCategory());
        partModel.setAutomaker(this.getAutomaker());
        return partModel;
    }
}
