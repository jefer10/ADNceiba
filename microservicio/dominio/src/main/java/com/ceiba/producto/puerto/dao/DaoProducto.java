package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoProducto  {
    /**
     * permite devolver todos los productos
     * @return la lista de todos los productos
     */
    List<Producto> productos();

    /**
     * permitw devolver el producto
     * @param id el identificador del producto
     * @return el producto
     */
    Producto findById(long id);
}
