package com.api.sx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.sx.model.usuario.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long>{
    
}
