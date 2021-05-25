package com.ceiba.pedido.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.comando.manejador.ManejadorActualizarPedido;
import com.ceiba.pedido.comando.manejador.ManejadorEliminarPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.usuario.comando.ComandoUsuario;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class ComandoControladorPedido {

    private final FabricaPedido fabricaPedido;
    private final ManejadorActualizarPedido manejadorActualizarPedido;
    private final ManejadorEliminarPedido manejadorEliminarPedido;

    @Autowired
    public ComandoControladorPedido(FabricaPedido fabricaPedido,
                                    ManejadorActualizarPedido manejadorActualizarPedido,
                                    ManejadorEliminarPedido manejadorEliminarPedido) {
        this.fabricaPedido = fabricaPedido;
        this.manejadorActualizarPedido = manejadorActualizarPedido;
        this.manejadorEliminarPedido = manejadorEliminarPedido;
    }



    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return fabricaPedido.crear(pedido);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        manejadorEliminarPedido.delete(id);
    }

    @PutMapping
    public Pedido actualizar(@RequestBody Pedido pedido){
        return manejadorActualizarPedido.actualizar(pedido);
    }
}
