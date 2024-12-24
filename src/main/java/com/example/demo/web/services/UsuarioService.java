package com.example.demo.web.services;

import java.util.List;

import com.example.demo.web.dto.UsuarioDTO;
import com.example.demo.web.entities.Usuario;

public interface UsuarioService {

	public Usuario createUsuario(String nombre, String direccion);

	public List<UsuarioDTO> consultaUsuarios();

	public UsuarioDTO consultaUsuario(long id);
}
