package com.api.sx.view.controller;

import org.springframework.web.bind.annotation.RestController;

import com.api.sx.model.oo.cto.CtoUser;
import com.api.sx.model.oo.dto.DtoUsuario;
import com.api.sx.service.ServiceUsuario;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@RequestMapping("/sx.api.user")
@CrossOrigin("*")
public class ControllerUsuario {

    @Autowired
    ServiceUsuario service;

    @PostMapping
    public ResponseEntity<String> post(@RequestBody CtoUser user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addUser(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody CtoUser user,@PathVariable( value = "id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateUser(user,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable( value = "id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.deleteUser(id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DtoUsuario> get(@PathVariable( value = "id") Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.get(id));
    }

    @PutMapping("/compra")
    public ResponseEntity<String> get(@RequestParam Long id_produto,@RequestParam Long id_user ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.efetuarCompra(id_produto,id_user));
    }


   

    
    
}
