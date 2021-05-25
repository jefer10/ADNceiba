package com.ceiba.producto.adaptador.dao;

import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRegistroJPA extends JpaRepository<Producto,Long> {
}
