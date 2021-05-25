package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.pedido.adaptador.dao.PedidoRegistroRepositorioJPA;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoRepositorioH2 implements DaoPedido {

    private PedidoRegistroRepositorioJPA pedidoRegistroRepositorioJPA;

    @Autowired
    public PedidoRepositorioH2(PedidoRegistroRepositorioJPA pedidoRegistroRepositorioJPA) {
        this.pedidoRegistroRepositorioJPA = pedidoRegistroRepositorioJPA;
    }

    @Override
    public Pedido FindById(long id) {
        return pedidoRegistroRepositorioJPA.findById(id).get() ;
    }
}
