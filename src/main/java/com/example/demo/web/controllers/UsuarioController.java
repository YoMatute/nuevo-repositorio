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

import com.example.demo.web.dto.UsuarioDTO;
import com.example.demo.web.services.UsuarioService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void creaUsuario(@RequestBody UsuarioDTO usuarioDTO) {

		usuarioService.createUsuario(usuarioDTO.getNombre(), usuarioDTO.getDireccion());
	}

	@GetMapping
	public List<UsuarioDTO> consultaUsuarios() {

		return usuarioService.consultaUsuarios();
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO consultaUsuario(@PathVariable long id) {

		return usuarioService.consultaUsuario(id);
	}
}
