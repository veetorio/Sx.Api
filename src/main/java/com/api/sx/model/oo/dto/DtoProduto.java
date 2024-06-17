package com.api.sx.model.oo.dto;


import com.api.sx.model.produtos.Produto;

public record DtoProduto(Long id,String name,String icon,double preco,int demanda,int estoque) {
    public DtoProduto(Produto p) {
        this(
            p.getId(),
            p.getNomeProduto(),
            p.getPathIcon(),
            p.getPreco(),
            p.getDemanda(),
            p.getEstoque()
        );
    }
    
}
