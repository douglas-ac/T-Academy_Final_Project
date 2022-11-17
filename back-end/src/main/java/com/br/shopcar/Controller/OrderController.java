package com.br.shopcar.Controller;

import com.br.shopcar.Repository.OrderRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository acao;
}
