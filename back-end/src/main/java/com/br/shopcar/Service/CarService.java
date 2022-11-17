package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.CarDto;
import com.br.shopcar.Dto.POST.CarDtoPost;
import com.br.shopcar.Model.CarModel;
import com.br.shopcar.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    CarRepository CarRepository;

    public List<CarDto> findAll(){
        List<CarModel> allCar = CarRepository.findAll();
        return allCar.stream().map(CarModel::converterDto).collect(Collectors.toList());
    }

    public CarDto findById(Long id){
        Optional<CarModel> obj = CarRepository.findById(id);
        CarModel carModel = obj.orElseThrow(()-> new EntityNotFoundException("Car not found"));
        return carModel.converterDto();
    }

    @Transactional
    public CarDto save(CarDtoPost CarDtoPost){
        CarModel carModel = CarDtoPost.convertToModelPost();
        CarRepository.save(carModel);
        return carModel.converterDto();
    }

    @Transactional
    public CarDto change(Long idCar, CarDto carDto){
        Optional<CarModel> CarToChange = CarRepository.findById(idCar);
        CarModel carModel = CarToChange.orElseThrow(() -> new EntityNotFoundException("Car not found"));

        carModel.setId(carDto.getId());
        carModel.setNome(carDto.getNome());
        carModel.setDescricao(carDto.getDescricao());
        carModel.setPreco(carDto.getPreco());
        carModel.setQuilometragem(carDto.getQuilometragem());
        carModel.setModelo(carDto.getModelo());
        
        CarModel saved = CarRepository.save(carModel);
        return saved.converterDto();
    }

    @Transactional
    public void delete(Long idCar){
        try {
            Optional<CarModel> CarToDelete = CarRepository.findById(idCar);
            CarModel carModel = CarToDelete.orElseThrow(() -> new EntityNotFoundException("Car not found"));
            CarRepository.delete(carModel);
        } catch (Exception e){
            return; //exception handler
        }

    }

    public CarModel findByIdModel(long id){
        Optional<CarModel> byId = CarRepository.findById(id);
        CarModel carModel = byId.orElseThrow(() -> new EntityNotFoundException("Car not found"));
        return carModel;
    }
}

