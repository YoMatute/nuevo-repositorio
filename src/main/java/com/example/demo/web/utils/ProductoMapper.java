package com.example.demo.web.utils;

import com.example.demo.web.dto.ProductoDTO;
import com.example.demo.web.entities.Producto;

public class ProductoMapper {

	public final static ProductoDTO map(Producto producto) {

		return ProductoDTO.builder()
						.id(producto.getId())
						.cantidad(producto.getCantidad())
						.nombre(producto.getNombre())
						.precio(producto.getPrecio())
					.build();
	}
}
