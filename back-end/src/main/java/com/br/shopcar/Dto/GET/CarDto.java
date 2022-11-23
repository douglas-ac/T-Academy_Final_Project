package com.br.shopcar.Dto.GET;

import com.br.shopcar.Model.CarModel;
import lombok.Data;

@Data
public class CarDto {

    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private double quilomatragem;
    private String modelo;

    public CarModel convertToModel(){
        CarModel carModel = new CarModel();
        carModel.setId(getId());
        carModel.setNome(getNome());
        carModel.setPreco(getPreco());
        carModel.setDescricao(getDescricao());
        carModel.setModelo(getModelo());
        carModel.setQuilomatragem(getQuilomatragem());
        return carModel;
    }
}
