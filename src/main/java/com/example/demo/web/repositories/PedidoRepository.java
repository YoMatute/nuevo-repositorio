package com.example.demo.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.web.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Query("SELECT p FROM Pedido p JOIN FETCH p.productos prods WHERE p.id = :id")
	Pedido findPedidoByIdWithProducto(long id);

}
