package com.br.shopcar.Dto.POST;

import com.br.shopcar.Model.CarModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarDtoPost {
    @NotBlank
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private double preco;
    @NotBlank
    private double quilometragem;
    @NotBlank
    private String modelo;
    
    public CarModel convertToModelPost(){
        CarModel carModel = new CarModel();

        carModel.setId(this.getId());
        carModel.setNome(this.getNome());
        carModel.setDescricao(this.getDescricao());
        carModel.setPreco(this.getPreco());
        carModel.setModelo(this.getModelo());
        carModel.setQuilometragem(this.getQuilometragem());
        carModel.setModelo(this.getModelo());

        return carModel;
    }
}



