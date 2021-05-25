package com.ceiba.pedido.controlador;

import com.ceiba.pedido.consulta.ManejadorPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class ConsultaControladorPedido {

    @Autowired
    private ManejadorPedido manejadorPedido;

    @GetMapping(value = "/{id}")
    public Pedido findById(@PathVariable("id") long id){
        return  manejadorPedido.findById(id);
    }
}
