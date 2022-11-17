package com.br.shopcar.Controller;

import com.br.shopcar.Repository.PartRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/parts")
public class PartController {
    private PartRepository acao;
}
