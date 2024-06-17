package com.api.sx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.sx.model.oo.cto.CtoUser;
import com.api.sx.model.oo.dto.DtoUsuario;
import com.api.sx.model.produtos.Produto;
import com.api.sx.model.usuario.Usuario;
import com.api.sx.repository.ProdutoRepository;
import com.api.sx.repository.UserRepository;


@Service
public class ServiceUsuario {
    @Autowired
    UserRepository repository;

    @Autowired
    ProdutoRepository repository2;

    public DtoUsuario get(Long id){
        Usuario user = repository.findById(id).orElseThrow();
        return new DtoUsuario(user);
    }

    public String addUser(CtoUser user){
        repository.save(new Usuario(user));
        return "Usuario criado com sucesso";
    }

    public String updateUser(CtoUser newUser, Long id){
        Usuario user = repository.findById(id).orElseThrow();

        user.setNickname(newUser.name());
        user.setPathIcon(newUser.path());
        user.setSenha(newUser.senha());

        repository.save(user);
        return "Atualizado com sucesso";
    }

    public String deleteUser(Long id){
        Usuario user = repository.findById(id).orElseThrow();
        repository.delete(user);
        return "conta deletada";
    }

    public String efetuarCompra(Long produtoId,Long userId){
        
        Usuario u = repository.findById(userId).orElseThrow();
        Produto p = repository2.findById(produtoId).orElseThrow();

        double decrementoSaldo = u.getSaldo() - p.getPreco();
        double incrementoGasto = u.getGastos() + p.getPreco();

        u.setSaldo(decrementoSaldo);
        u.setGastos(incrementoGasto);
        u.getProdutos().add(p);

        repository.save(u);
        return "Compra realizada";
    }


}
