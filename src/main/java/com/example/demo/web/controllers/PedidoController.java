package com.example.demo.web.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.web.dto.PedidoDTO;
import com.example.demo.web.services.PedidoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void creaPerdido(@RequestBody PedidoDTO pedidoDTO) {

		pedidoService.creaPedido(pedidoDTO.getUsuarioId(), pedidoDTO.getDescripcion(), pedidoDTO.getProductos());
	}

	@GetMapping
	public List<PedidoDTO> consultaPedidos() {

		return pedidoService.consultaPedidos();
	}

	@GetMapping("/{id}")
	public PedidoDTO consultaPedido(@PathVariable long id) {

		return pedidoService.consultaPedido(id);
	}
}
