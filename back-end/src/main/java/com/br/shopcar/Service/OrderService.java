package com.br.shopcar.Service;

import com.br.shopcar.Dto.GET.OrderDto;
import com.br.shopcar.Model.OrderModel;
import com.br.shopcar.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderDto findById(long id){
        Optional<OrderModel> obj = orderRepository.findById(id);
        //verifying the optional
        OrderModel orderModel = obj.orElseThrow(()-> new EntityNotFoundException("Order not found"));
        return orderModel.convertToDto();
    }

    public List<OrderDto> findByUserId(long id){
        List<Optional<OrderModel>> obj = orderRepository.findByUserId(id);
        //verifying the optional
        List<OrderModel> orderModelList = new ArrayList<>();
        obj.forEach(order -> {
            OrderModel orderModel = order.orElseThrow(() -> new EntityNotFoundException("Order Not Found"));
            orderModelList.add(orderModel);
        });
        return orderModelList.stream().map(OrderModel::convertToDto).collect(Collectors.toList());
    }

    @Transactional
    public OrderDto save(OrderDto orderDto){
        OrderModel orderModel = orderDto.convertToModel();
        orderRepository.save(orderModel);
        return orderModel.convertToDto();
    }
    @Transactional
    public OrderDto change(long idOrder, OrderDto orderDto){
        Optional<OrderModel> annToChange = orderRepository.findById(idOrder);

        //variable to store the object from database
        OrderModel orderModel = annToChange.orElseThrow(() -> new EntityNotFoundException("Order not found"));

        //Dto received converted to model to change attributes
        OrderModel orderDtoUpdate = orderDto.convertToModel();

        //setting the changes
        orderModel.setDiscount(orderDtoUpdate.getDiscount());
        orderModel.setProdutos(orderDtoUpdate.getProdutos());
        //saving changes
        orderRepository.save(orderModel);

        //return DTO
        return orderModel.convertToDto();

    }

    @Transactional
    public void delete(long idOrder){
        //searching the object in the database
        Optional<OrderModel> orderToDelete = orderRepository.findById(idOrder);
        //if founded -> delete else-> exception
        OrderModel orderModel = orderToDelete.orElseThrow(() -> new EntityNotFoundException("Order not found"));
        orderRepository.delete(orderModel);


    }

    public OrderModel findByIdModel(long id){
        Optional<OrderModel> byId = orderRepository.findById(id);
        return byId.orElseThrow(() -> new EntityNotFoundException("Order not found"));
    }
}
