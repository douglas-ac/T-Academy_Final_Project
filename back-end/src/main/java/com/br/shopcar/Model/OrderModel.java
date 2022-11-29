package com.br.shopcar.Model;

import com.br.shopcar.Dto.GET.OrderDto;
import com.br.shopcar.Model.User.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class OrderModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    private double subTotal;
    private double discount;

    @ManyToMany
    @JoinTable(
        name = "order_to_product",
        joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
    )
    private List<ProductModel> produtos = new ArrayList<>();

    public OrderDto convertToDto(){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(this.getId());
        orderDto.setUser(this.user.converterDtoSlim());
        orderDto.setSubTotal(this.getSubTotal());
        orderDto.setDiscount(this.getDiscount());
        orderDto.setProdutos(this.getProdutos());
        return orderDto;
    }

    /* public Double calculateSubtotal(){
        Double subtotal = 0.0;
       for (ProductModel p : produtos){
           subtotal += p.getPreco();
       }
        System.out.println(subtotal);
       this.setSubTotal(subtotal);
       return subtotal;
    } */

    /* public Double calculateTotal(){
        return calculateSubtotal() - getDiscount();
    } */

}
