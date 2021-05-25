package com.ceiba.producto.comando.fabrica;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    private ServicioCrearProducto servicioCrearProducto;

    @Autowired
    public FabricaProducto(ServicioCrearProducto servicioCrearProducto) {
        this.servicioCrearProducto = servicioCrearProducto;
    }

    public Producto ejecutar(Producto producto){
        return servicioCrearProducto.crear(producto);
    }
}
