package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExceptionTiempo;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarPedido {

    private static final String TIEMPO_DE_ACTUALIZADO = "No se puede modificar el pedido ya fue enviado";
    private RepositorioPedido repositorioPedido;

    @Autowired
    public ServicioActualizarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Pedido actualizar(Pedido pedido){
        boolean tiempo=pedido.periodoDeActualizado();
        if (tiempo){
            return repositorioPedido.actualizar(pedido);
        }else {
            throw new ExceptionTiempo(TIEMPO_DE_ACTUALIZADO);
        }

    }
}
