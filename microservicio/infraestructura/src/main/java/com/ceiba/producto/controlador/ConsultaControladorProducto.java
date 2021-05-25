package com.ceiba.producto.controlador;

import com.ceiba.producto.consulta.ManejadorProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ConsultaControladorProducto {

    @Autowired
    private ManejadorProducto manejadorProducto;

    @GetMapping(value = "/")
    public List<Producto>findAll(){
        return manejadorProducto.listaProductos();
    }

    @GetMapping(value = "/{id}")
    public Producto findById(@PathVariable long id){
        return manejadorProducto.findById(id);
    }


}
