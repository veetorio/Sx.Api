package com.api.sx.model.oo.cto;

import com.api.sx.model.usuario.Usuario;

public record CtoUser(String name,String path,String senha) {
    public CtoUser(Usuario usuario){
        this(
            usuario.getNickname(),
            usuario.getPathIcon(),
            usuario.getSenha()
        );
    }
}
