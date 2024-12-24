package com.example.demo.web.services;

import java.util.List;

import com.example.demo.web.dto.PedidoDTO;
import com.example.demo.web.dto.ProductoDTO;

public interface PedidoService {

	void creaPedido(long usuarioId, String descripcion, List<ProductoDTO> productos);

	List<PedidoDTO> consultaPedidos();

	PedidoDTO consultaPedido(long id);

}
