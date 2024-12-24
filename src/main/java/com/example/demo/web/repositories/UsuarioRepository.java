package com.example.demo.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.web.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByPedidosId(long pedidoId);
}
