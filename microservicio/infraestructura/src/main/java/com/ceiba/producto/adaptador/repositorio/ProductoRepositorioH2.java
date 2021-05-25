package com.ceiba.producto.adaptador.repositorio;

import com.ceiba.producto.adaptador.dao.ProductoRegistroJPA;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoRepositorioH2 implements DaoProducto {

    private ProductoRegistroJPA productoRegistroJPA;

    @Autowired
    public ProductoRepositorioH2(ProductoRegistroJPA productoRegistroJPA) {
        this.productoRegistroJPA = productoRegistroJPA;
    }

    @Override
    public List<Producto> productos() {
        return productoRegistroJPA.findAll();
    }

    @Override
    public Producto findById(long id) {
        return productoRegistroJPA.findById(id).get();
    }
}
