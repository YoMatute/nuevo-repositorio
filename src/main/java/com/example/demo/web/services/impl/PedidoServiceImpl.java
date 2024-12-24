package com.example.demo.web.services.impl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.web.dto.PedidoDTO;
import com.example.demo.web.dto.ProductoDTO;
import com.example.demo.web.entities.Pedido;
import com.example.demo.web.entities.Producto;
import com.example.demo.web.entities.Usuario;
import com.example.demo.web.repositories.PedidoRepository;
import com.example.demo.web.repositories.ProductoRepository;
import com.example.demo.web.repositories.UsuarioRepository;
import com.example.demo.web.services.PedidoService;
import com.example.demo.web.utils.PedidoMapper;
import com.example.demo.web.utils.ProductoMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {

	private PedidoRepository pedidoRepo;
	private ProductoRepository productoRepo;
	private UsuarioRepository usuarioRepo;

	private static Function<Pedido, PedidoDTO> mapperPedido = PedidoMapper::map;
	private static Function<Producto, ProductoDTO> mapperProducto = ProductoMapper::map;
	
	@Override
	public void creaPedido(long usuarioId, String descripcion, List<ProductoDTO> productos) {
		
		Usuario user = Usuario.builder()
								.id(usuarioId)
								.build();
		
		Pedido pedido = Pedido.builder()
							  .descripcion(descripcion)
							  .usuario(user)
							  .build();
				
		pedidoRepo.save(pedido);
		
		pedido.setProductos(productos.stream()
								.map(p_dto -> Producto.builder()
										.cantidad(p_dto.getCantidad())
										.pedido(pedido)
										.nombre(p_dto.getNombre())
										.precio(p_dto.getPrecio())
										.build())
								.collect(Collectors.toList()));
		
		pedidoRepo.save(pedido);
		
	}
	
	@Override
	public List<PedidoDTO> consultaPedidos() {
		
		return pedidoRepo.findAll().stream()
							.map(mapperPedido)
							.map(pedidoDTO -> {
								 pedidoDTO.setProductos(productoRepo.findByPedidoId(pedidoDTO.getId()).stream()
										  .map(mapperProducto)
										  .collect(Collectors.toList()));
								 pedidoDTO.setUsuarioId(usuarioRepo.findByPedidosId(pedidoDTO.getId()).getId());
								 return pedidoDTO;
							})
							.collect(Collectors.toList());
	}
	
	@Override
	public PedidoDTO consultaPedido(long id) {
		
		Pedido pedido = pedidoRepo.findPedidoByIdWithProducto(id);
		
		
		PedidoDTO pedidoDTO = mapperPedido.apply(pedido);
		
		pedidoDTO.setProductos(productoRepo.findByPedidoId(pedido.getId()).stream()
				  .map(mapperProducto)
				  .collect(Collectors.toList()));
		
		pedidoDTO.setUsuarioId(usuarioRepo.findByPedidosId(pedidoDTO.getId()).getId());
		
		return pedidoDTO;
	}


}
