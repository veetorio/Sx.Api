package com.api.sx.service.utils;

public interface Util {
    default String salt(String body){
        String codex = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz$%!";
        return "";
    }
    
}
