package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExceptionTiempo;
import com.ceiba.pedido.modelo.entidad.Pedido;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
public class ServicioActualizarPedidoTest {


    @Autowired
    private ServicioActualizarPedido actualizarPedido;

    @Test(expected = ExceptionTiempo.class)
    public void seSuperaElPeriodoParaPoderActualizarPedido(){
        Pedido pedido=new PedidoTestDataBuilder().setFecha(LocalDateTime.now().plusHours(13)).build();
        actualizarPedido.actualizar(pedido);
    }
}