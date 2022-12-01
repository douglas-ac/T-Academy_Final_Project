package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.CarDto;
import com.br.shopcar.Dto.GET.PartDto;
import com.br.shopcar.Model.CarModel;
import com.br.shopcar.Model.PartModel;
import com.br.shopcar.Repository.CarRepository;
import com.br.shopcar.Repository.PartRepository;
import com.br.shopcar.enums.Automaker;
import com.br.shopcar.enums.Partmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    PartRepository partRepository;

    @Transactional
    public PartDto save(PartDto partDto){
        PartModel partModel = partDto.convertToModel();
        partRepository.save(partModel);
        return partModel.convertToDto();
    }

    @Transactional
    public CarDto save(CarDto carDto){
        CarModel carModel = carDto.convertToModel();
        carRepository.save(carModel);
        return carModel.convertToDto();
    }

    public CarDto findCarById(long id) {
        Optional<CarModel> byId = carRepository.findById(id);
        CarModel carModel = byId.orElseThrow(() -> new EntityNotFoundException("Car not found"));
        return carModel.convertToDto();
    }

    public PartDto findPartById(long id) {
        Optional<PartModel> byId = partRepository.findById(id);
        PartModel partModel = byId.orElseThrow(() -> new EntityNotFoundException("Part not found"));
        return partModel.convertToDto();
    }

    public List<CarDto> findCarName(String name) {
        List<CarModel> byName = carRepository.findByNameContains(name);
        return byName.stream().map(CarModel::convertToDto).collect(Collectors.toList());
    }

    public List<PartDto> findPartName(String name) {
        List<PartModel> byName = partRepository.findByNameContains(name);
        return byName.stream().map(PartModel::convertToDto).collect(Collectors.toList());
    }

    public List<CarDto> findAllCars() {
        List<CarModel> all = carRepository.findAll();
        return all.stream().map(CarModel::convertToDto).collect(Collectors.toList());
    }

    public List<PartDto> findAllParts() {
        List<PartModel> all = partRepository.findAll();
        return all.stream().map(PartModel::convertToDto).collect(Collectors.toList());
    }

    public void deleteCarById(long id){
        try {
            Optional<CarModel> carToDelete = carRepository.findById(id);
            CarModel carModel = carToDelete.orElseThrow(() -> new EntityNotFoundException("Car not found"));
            carRepository.delete(carModel);
        } catch (Exception e){
            return; //exception handler
        }
    }

    public void deletePartById(long id){
        try {
            Optional<PartModel> partModel = partRepository.findById(id);
            PartModel partModelToDelete = partModel.orElseThrow(() -> new EntityNotFoundException("Part not found"));
            partRepository.delete(partModelToDelete);
        } catch (Exception e){
            return; //exception handler
        }
    }

    public List<Automaker> findAllMakers() {
        return List.of(Automaker.values());
    }

    public List<Partmaker> findAllPartMakers() {
        return List.of(Partmaker.values());
    }
}
