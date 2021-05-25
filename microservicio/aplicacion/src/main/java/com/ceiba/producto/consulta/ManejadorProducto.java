package com.ceiba.producto.consulta;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioBuscarProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorProducto {

    private final ServicioBuscarProducto servicioBuscarProducto;

    @Autowired
    public ManejadorProducto(ServicioBuscarProducto servicioBuscarProducto) {
        this.servicioBuscarProducto = servicioBuscarProducto;
    }

    public List<Producto> listaProductos(){
        return servicioBuscarProducto.listaProductos();
    }

    public Producto findById(long id){
        return servicioBuscarProducto.findById(id);
    }
}
