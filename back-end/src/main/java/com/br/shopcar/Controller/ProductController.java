package com.br.shopcar.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.shopcar.Repository.ProductRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/products")
public class ProductController {
    private ProductController action;
}
