package com.ceiba.pedido.servicio;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.entidad.Producto;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PedidoTestDataBuilder {

    private Long id;
    private LocalDateTime fecha;
    private Cliente cliente;
    private List<Producto> producto;
    private Double iva;
    private Double valorEnvio;
    private Double total;

    public PedidoTestDataBuilder() {
        this.id = 12L;
        this.fecha = LocalDateTime.now();
        this.cliente = new Cliente();
        this.producto = new ArrayList<>();
        this.iva = 14528.0;
        this.valorEnvio = 10000.0;
        this.total = 250000.0;
    }

    public PedidoTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PedidoTestDataBuilder withFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
        this.fecha = dateTime;
        return this;
    }

    public PedidoTestDataBuilder setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public PedidoTestDataBuilder withCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoTestDataBuilder withProducto(List<Producto> producto) {
        this.producto = producto;
        return this;
    }

    public PedidoTestDataBuilder withIva(Double iva) {
        this.iva = iva;
        return this;
    }

    public PedidoTestDataBuilder withValorEnvio(Double valorEnvio) {
        this.valorEnvio = valorEnvio;
        return this;
    }

    public PedidoTestDataBuilder withTotal(Double total) {
        this.total = total;
        return this;
    }

    public Pedido build(){
        return new Pedido(id,fecha,cliente,producto,iva,valorEnvio,total);
    }
}
