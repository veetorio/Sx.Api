package com.api.sx.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sx.model.oo.dto.DtoProduto;
import com.api.sx.model.produtos.Produto;
import com.api.sx.repository.ProdutoRepository;

@Service
public class ServiceProduto {

    @Autowired
    ProdutoRepository repository;


    public List<DtoProduto> get(){
        List<Produto> produtos = repository.findAll();

        return  produtos.stream().map(DtoProduto::new).toList();
    }

    public DtoProduto post(Produto p){
        repository.save(p);
        return new DtoProduto(p);
    }

    

}
