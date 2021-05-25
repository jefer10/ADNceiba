package com.ceiba.producto.controlador;

import com.ceiba.producto.comando.fabrica.FabricaProducto;
import com.ceiba.producto.comando.manejador.ManejadorActualizarProducto;
import com.ceiba.producto.comando.manejador.ManejadorEliminarProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/producto")
public class ComandoControladorProducto {

    private final FabricaProducto fabricaProducto;
    private final ManejadorActualizarProducto manejadorActualizarProducto;
    private final ManejadorEliminarProducto manejadorEliminarProducto;

    @Autowired
    public ComandoControladorProducto(FabricaProducto fabricaProducto,
                                      ManejadorActualizarProducto manejadorActualizarProducto,
                                      ManejadorEliminarProducto manejadorEliminarProducto) {
        this.fabricaProducto = fabricaProducto;
        this.manejadorActualizarProducto = manejadorActualizarProducto;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
    }

    @PostMapping
    public Producto crear(@RequestBody Producto producto){
        return  fabricaProducto.ejecutar(producto);
    }

    @PutMapping
    public Producto actualizar(@RequestBody Producto producto){
        return manejadorActualizarProducto.update(producto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        manejadorEliminarProducto.delete(id);
    }
}
