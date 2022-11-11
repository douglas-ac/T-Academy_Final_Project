package com.br.shopcar.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.shopcar.Repository.OrderRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderController {
    private OrderController action;
}
