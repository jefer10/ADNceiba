package com.ceiba.producto.servicio;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioBuscarProducto {

    private DaoProducto daoProducto;

    @Autowired
    public ServicioBuscarProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<Producto> listaProductos(){
        return daoProducto.productos();
    }

    public Producto findById(long id){
        return  daoProducto.findById(id);
    }
}
