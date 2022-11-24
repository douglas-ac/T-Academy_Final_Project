package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.ProductModel;
import com.br.shopcar.enums.Automaker;
import lombok.Data;

@Data
public class ProductDto {
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private Integer year;
    private Automaker automaker;
    private String modelo;
    private String category;

    public <T extends ProductModel> T convertToModel(T productModel){

        productModel.setId(this.getId());
        productModel.setNome(this.getNome());
        productModel.setDescricao(this.getDescricao());
        productModel.setPreco(this.getPreco());
        productModel.setYear(this.getYear());
        productModel.setAutomaker(this.getAutomaker());
        productModel.setModelo(getModelo());
        productModel.setCategory(this.getCategory());

        return productModel;
    }
}
