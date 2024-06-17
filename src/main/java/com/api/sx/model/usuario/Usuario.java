package com.api.sx.model.usuario;

import java.util.List;

import com.api.sx.model.oo.cto.CtoUser;
import com.api.sx.model.produtos.Produto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    public Usuario(CtoUser user){
        this.nickname = user.name();
        this.pathIcon = user.path();
        this.senha = user.senha();
        this.saldo = 1000.00;
        this.gastos = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nickname",length = 25,unique = true)
    private String nickname;

    @Column(name = "senha",length = 25,unique = true)
    private String senha;

    @Column(name = "path-icon",unique = true,columnDefinition = "TEXT")
    private String pathIcon;

    private double saldo;

    private double gastos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "produtos_usuarios",
        joinColumns = {
            @JoinColumn(name = "produto_id" , referencedColumnName = "id"),
        } ,
        inverseJoinColumns ={
            @JoinColumn(name = "usuario_id" , referencedColumnName = "id")
        }
    )
    private List<Produto> produtos;
    
}