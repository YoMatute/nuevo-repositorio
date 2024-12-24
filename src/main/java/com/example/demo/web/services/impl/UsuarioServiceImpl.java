package com.example.demo.web.services.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.web.dto.UsuarioDTO;
import com.example.demo.web.entities.Direccion;
import com.example.demo.web.entities.Usuario;
import com.example.demo.web.repositories.UsuarioRepository;
import com.example.demo.web.services.UsuarioService;
import com.example.demo.web.utils.UsuarioMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository usuarioRepo;
	
	private static Function<Usuario, UsuarioDTO> mapper = UsuarioMapper::map;

	@Override
	public Usuario createUsuario(String nombre, String direccion) {

		Direccion dir = Direccion.builder().calle(direccion).build();

		Usuario usr = Usuario.builder().nombre(nombre).direccion(dir).build();

		dir.setUsuario(usr);

		usr = usuarioRepo.save(usr);

		return usr;
	}

	@Override
	public List<UsuarioDTO> consultaUsuarios() {
		
		return usuarioRepo.findAll()
				.stream()
				.map(u -> UsuarioMapper.map(u))
				.collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO consultaUsuario(long id) {
		
		return mapper.apply(usuarioRepo.findById(id).get());
	}

}
