package com.example.demo.web.utils;

import com.example.demo.web.dto.PedidoDTO;
import com.example.demo.web.entities.Pedido;

public class PedidoMapper {

	public final static PedidoDTO map(Pedido pedido) {
		
		return PedidoDTO.builder()
				.id(pedido.getId())
				.descripcion(pedido.getDescripcion())
				.build();
	}
}
