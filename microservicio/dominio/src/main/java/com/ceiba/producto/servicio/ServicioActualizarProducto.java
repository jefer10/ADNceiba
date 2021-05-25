package com.ceiba.producto.servicio;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarProducto {

    private RepositorioProducto repositorioProducto;

    @Autowired
    public ServicioActualizarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Producto actualizar(Producto producto){
        return repositorioProducto.actualizar(producto);
    }
}
