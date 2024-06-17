package com.api.sx.model.produtos;

import java.util.List;

import com.api.sx.model.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nome-produto",nullable = true,length = 15)
    private String nomeProduto;

    @Column(name = "descricao",nullable = true,columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "path-icon",nullable = true,columnDefinition = "TEXT")
    private String pathIcon;

    private double preco;

    private int estoque;

    private int demanda;


}
