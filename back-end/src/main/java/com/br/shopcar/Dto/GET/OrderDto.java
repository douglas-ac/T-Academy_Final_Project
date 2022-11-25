package com.br.shopcar.Dto.GET;

import com.br.shopcar.Dto.GET.Slim.UserDtoSlim;
import com.br.shopcar.Model.OrderModel;
import com.br.shopcar.Model.ProductModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {

    private long id;
    @NotBlank
    private UserDtoSlim user;
    private double subTotal;
    private double discount;
    private List<ProductModel> produtos = new ArrayList<>();

    public OrderModel convertToModel(){
        OrderModel orderModel = new OrderModel();
        orderModel.setId(this.getId());
        orderModel.setUser(this.user.convertToModel());
        orderModel.setSubTotal(this.getSubTotal());
        orderModel.setDiscount(this.getDiscount());
        orderModel.setProdutos(this.getProdutos());
        return orderModel;
    }
}
