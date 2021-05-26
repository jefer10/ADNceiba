package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExceptionTiempo;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Service
public class ServicioCrearPedido {

    private static final String DIAS_NO_HABIL = "No se puede tomar el pedido intentelo el lunes";
    private final double IVA= 19;
    private final double DESCUENTO_DE_ENVIO= 200000;
    private final double VALOR_DE_ENVIO=50000;

    private RepositorioPedido repositorioPedido;

    @Autowired
    public ServicioCrearPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }
    public Pedido crear(Pedido pedido){
        pedido.setValorEnvio(VALOR_DE_ENVIO);
        pedido.descuentoEnvio(DESCUENTO_DE_ENVIO);
        pedido.valorImpuesto(IVA);
        pedido.valorTotal();
        LocalDateTime tiempo=LocalDateTime.now();

        if ( (tiempo.getDayOfWeek().equals(DayOfWeek.SATURDAY)) &&(tiempo.getDayOfWeek().equals(DayOfWeek.SUNDAY)) ) {
            throw new ExceptionTiempo(DIAS_NO_HABIL);
        }else{
            return repositorioPedido.crear(pedido);
        }
    }
}
