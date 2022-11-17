package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.OrderDto;
import com.br.shopcar.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> findAllOrderByUserId(@PathVariable("userId") long userId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findByUserId(userId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> findByOrderId(@PathVariable("orderId") long orderId){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(orderId));
    }

    @PostMapping
    public ResponseEntity<OrderDto> save(@RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.save(orderDto));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> change(@PathVariable("orderId") long orderId,
                                          @RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.change(orderId, orderDto));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> delete(@PathVariable("orderId") long orderId){
        orderService.delete(orderId);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
