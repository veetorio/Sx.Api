package com.api.sx.model.oo.dto;

import java.util.List;

import com.api.sx.model.usuario.Usuario;

public record DtoUsuario(Long id,String nickname,String path,double saldo,double gasto,List<DtoProduto> produtos) {
    public DtoUsuario(Usuario user){
        this(
            user.getId(),
            user.getNickname(),
            user.getPathIcon(),
            user.getSaldo(),
            user.getGastos(),
            user.getProdutos().stream().map(DtoProduto::new).toList()
            );
    }
    
}
