package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.pedido.adaptador.dao.PedidoRegistroRepositorioJPA;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositorioH2 implements DaoPedido, RepositorioPedido {

    private PedidoRegistroRepositorioJPA pedidoRegistroRepositorioJPA;

    @Autowired
    public PedidoRepositorioH2(PedidoRegistroRepositorioJPA pedidoRegistroRepositorioJPA) {
        this.pedidoRegistroRepositorioJPA = pedidoRegistroRepositorioJPA;
    }

    @Override
    public Pedido FindById(long id) {
        return pedidoRegistroRepositorioJPA.findById(id).get() ;
    }

    @Override
    public Pedido crear(Pedido pedido) {
        return pedidoRegistroRepositorioJPA.save(pedido);
    }

    @Override
    public Pedido actualizar(Pedido pedido) {
        return pedidoRegistroRepositorioJPA.save(pedido);
    }

    @Override
    public void eliminar(long id) {
        pedidoRegistroRepositorioJPA.deleteById(id);
    }
}
