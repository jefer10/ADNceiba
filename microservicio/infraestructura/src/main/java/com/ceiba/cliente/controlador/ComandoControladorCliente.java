package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.comando.manejador.ManejadorActualizarCliente;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import org.aspectj.util.PartialOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.MessageHandler;

@RestController
@RequestMapping("/cliente")
public class ComandoControladorCliente {

    private final FabricaCliente fabricaCliente;
    private final ManejadorActualizarCliente manejadorActualizarCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;

    @Autowired
    public ComandoControladorCliente(FabricaCliente fabricaCliente,
                                     ManejadorActualizarCliente manejadorActualizarCliente,
                                     ManejadorEliminarCliente manejadorEliminarCliente) {
        this.fabricaCliente = fabricaCliente;
        this.manejadorActualizarCliente = manejadorActualizarCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;
    }

    @PostMapping
    public Cliente crear(@RequestBody Cliente cliente) {
        return fabricaCliente.crear(cliente);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id){
        manejadorEliminarCliente.eliminar(id);
    }

    @PutMapping
    public Cliente actualizar(@RequestBody Cliente cliente){
        return manejadorActualizarCliente.actualizar(cliente);
    }
}
