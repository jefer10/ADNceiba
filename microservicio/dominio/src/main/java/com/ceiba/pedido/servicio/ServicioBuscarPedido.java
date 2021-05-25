package com.ceiba.pedido.servicio;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioBuscarPedido {

    private DaoPedido daoPedido;

    @Autowired
    public ServicioBuscarPedido(DaoPedido daoPedido) {
        this.daoPedido = daoPedido;
    }

    public Pedido findById(long id){
        return daoPedido.FindById(id);
    }
}
