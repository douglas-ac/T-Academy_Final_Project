package com.br.shopcar.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.shopcar.Repository.PartRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parts")
public class PartController {
    private PartRepository action;
}
