package com.api.sx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sx.model.produtos.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
}
