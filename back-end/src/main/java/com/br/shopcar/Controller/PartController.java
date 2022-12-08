package com.br.shopcar.Controller;

import com.br.shopcar.Dto.GET.PartDto;
import com.br.shopcar.Service.ProductService;
import com.br.shopcar.enums.Partmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;


@RestController
@RequestMapping("api/v1/parts")
public class PartController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<PartDto> save(@RequestBody PartDto partDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(partDto));
    }

    @GetMapping("/{idPart}")
    public ResponseEntity<PartDto> findById(@PathVariable("idPart") long idPart){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findPartById(idPart));
    }

    @GetMapping
    public ResponseEntity<List<PartDto>> findAllParts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllParts());
    }

    @GetMapping("/search/{partName}")
    public ResponseEntity<List<PartDto>> findById(@PathVariable("partName") String partName){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findPartName(partName));
    }

    @DeleteMapping("/{idPart}")
    public ResponseEntity<Void> delete(@PathVariable("idPart") long idPart){
        productService.deletePartById(idPart);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/partmakers")
    public ResponseEntity<LinkedHashMap<String, String>> allMakers(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllPartMakers());
    }
}
