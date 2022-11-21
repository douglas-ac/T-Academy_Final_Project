package com.br.shopcar.tests;

import com.br.shopcar.Dto.GET.CarDto;
import com.br.shopcar.Model.CarModel;

public class FactoryCar {
    public static CarModel createCarModel() {
        CarModel carModel = new CarModel();

        carModel.setId(1L);
        carModel.setNome("Meu carro");
        carModel.setDescricao("Muito bonito.");
        carModel.setPreco(50000);
        carModel.setQuilometragem(75000);
        carModel.setModelo("Uno");

        return carModel;
    }

    public static CarModel createCarModelNullId() {
        CarModel carModel = new CarModel();

        carModel.setNome("Outro carro");
        carModel.setDescricao("Nem tão bonito.");
        carModel.setPreco(75000);
        carModel.setQuilometragem(50000);
        carModel.setModelo("Pálio");

        return carModel;
    }

    public static CarDto createCarDto() {
        CarModel carModel = createCarModel();
        return carModel.converterDto();
    }
}
