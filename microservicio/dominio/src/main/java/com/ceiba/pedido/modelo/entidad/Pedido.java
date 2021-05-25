package com.ceiba.pedido.modelo.entidad;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.producto.modelo.entidad.Producto;

import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @ManyToMany(mappedBy = "pedido")
    private List<Producto> producto;

    @Column(name = "iva")
    private Double iva;

    @Column(name="shippingValue")
    private Double valorEnvio;

    @Column(name = "total")
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Double valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
