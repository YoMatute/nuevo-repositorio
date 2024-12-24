package com.example.demo.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.web.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByPedidoId(long id);
	
}
