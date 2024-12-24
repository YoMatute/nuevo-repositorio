package com.example.demo.web.utils;

import com.example.demo.web.dto.UsuarioDTO;
import com.example.demo.web.entities.Usuario;

public class UsuarioMapper {

	public final static UsuarioDTO map(Usuario user) {
		
		return UsuarioDTO.builder()
				.id(user.getId())
				.nombre(user.getNombre())
				.direccion(user.getDireccion()
				.getCalle())
				.build();
	}
}
