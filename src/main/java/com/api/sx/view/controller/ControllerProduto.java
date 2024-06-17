package com.api.sx.view.controller;

import org.springframework.web.bind.annotation.RestController;

import com.api.sx.model.oo.dto.DtoProduto;
import com.api.sx.model.produtos.Produto;
import com.api.sx.service.ServiceProduto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/sx.api.produto")
@CrossOrigin("*")
public class ControllerProduto {
    
    @Autowired
    ServiceProduto service;

    @GetMapping
    public ResponseEntity<java.util.List<DtoProduto>> get() {
        return ResponseEntity.status(201).body(service.get());
    }
    
    
    @PostMapping
    public ResponseEntity<DtoProduto> post(@RequestBody Produto produto) {
        return ResponseEntity.status(201).body(service.post(produto));
    }
    
    
}
