package com.ceiba.producto.puerto.repositorio;

import com.ceiba.producto.modelo.entidad.Producto;

public interface RepositorioProducto {

    /**
     * permite la creacion de productos
     * @param producto el producto a crear
     * @return el producto crado
     */
    Producto crear(Producto producto);

    /**
     * la actualizacion del producto
     * @param producto
     * @return
     */
    Producto actualizar(Producto producto);

    /**
     * permite eliminar el producto
     * @param id identificador del producto
     */
    void eliminar(long id);
}
