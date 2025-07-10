package com.pedi.pedido.service;

import com.pedi.pedido.model.Pedido;
import com.pedi.pedido.repository.PedidoRepository; 
import com.pedi.pedido.webClient.ProductoClient;
import com.pedi.pedido.webClient.UsuarioClient;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private ProductoClient productoClient;

    public Pedido crearPedido(Pedido pedido) {
        Map<String, Object> usuario = usuarioClient.getUsuarioById(pedido.getIdUsuario());
        Map<String, Object> producto = productoClient.getProductoById(pedido.getIdProducto());

        pedido.setNombreUsuario((String) usuario.get("nombre"));
        pedido.setNombreProducto((String) producto.get("nombre"));
        pedido.setPrecioTotal((Double) producto.get("precio") * pedido.getCantidad());

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }

    public void eliminarPedido(Long id) {
        Pedido pedido = obtenerPedidoPorId(id);
        pedidoRepository.delete(pedido);
    }

    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        Pedido pedidoExistente = obtenerPedidoPorId(id);
        pedidoExistente.setIdUsuario(pedidoActualizado.getIdUsuario());
        pedidoExistente.setNombreUsuario(pedidoActualizado.getNombreUsuario());
        pedidoExistente.setIdProducto(pedidoActualizado.getIdProducto());
        pedidoExistente.setNombreProducto(pedidoActualizado.getNombreProducto());
        pedidoExistente.setCantidad(pedidoActualizado.getCantidad());
        pedidoExistente.setPrecioTotal(pedidoActualizado.getPrecioTotal());

        return pedidoRepository.save(pedidoExistente);
    }

    public List<Pedido> obtenerPedidosPorUsuario(Long idUsuario) {
        return pedidoRepository.findAll().stream()
                .filter(pedido -> pedido.getIdUsuario().equals(idUsuario))
                .toList();
    }
}
