package com.example.demo.web.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

	private long id;
	private long usuarioId;
	private String descripcion;
	private List<ProductoDTO> productos;
}
