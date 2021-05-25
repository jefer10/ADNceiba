package com.ceiba.pedido.adaptador.dao;

import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRegistroRepositorioJPA extends JpaRepository<Pedido,Long> {
}
