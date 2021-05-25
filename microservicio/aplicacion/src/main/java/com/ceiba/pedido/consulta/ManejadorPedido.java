package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioBuscarPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorPedido {

    private final ServicioBuscarPedido servicioBuscarPedido;

    @Autowired
    public ManejadorPedido(ServicioBuscarPedido servicioBuscarPedido) {
        this.servicioBuscarPedido = servicioBuscarPedido;
    }

    public Pedido findById(long id){
        return servicioBuscarPedido.findById(id);
    }
}
