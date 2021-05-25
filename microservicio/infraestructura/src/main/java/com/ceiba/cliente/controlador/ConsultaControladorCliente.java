package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ConsultaControladorCliente {

    @Autowired
    private ManejadorCliente manejadorCliente;

    @GetMapping(value = "/{id}")
    public Cliente findByid(@PathVariable("id")long id){
        return manejadorCliente.findByid(id);
    }
}
