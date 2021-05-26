package com.ceiba.pedido.modelo.entidad;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.producto.modelo.entidad.Producto;

import java.time.LocalDateTime;
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
    private LocalDateTime fecha;

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

    public Pedido(Long id, LocalDateTime fecha, Cliente cliente, List<Producto> producto, Double iva, Double valorEnvio, Double total) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.iva = iva;
        this.valorEnvio = valorEnvio;
        this.total = total;
    }

    public boolean periodoDeActualizado(){
       if (LocalDateTime.now().isBefore( this.fecha.plusHours(12) )){
           return true;
       }
       return false;
    }

    public void descuentoEnvio(Double descuento){
        double valor=sumaDeProductos();
         if (valor > descuento){
             this.valorEnvio=0.0;
         }
    }

    public Double valorImpuesto(Double impuesto){
        double valor=sumaDeProductos();
        this.iva=valor*(impuesto/100);
        return this.iva;
    }

    private Double sumaDeProductos(){
        double valor=0;
        for (int i = 0; i < this.producto.size(); i++) {
            Producto producto1=this.producto.get(i);
            valor=producto1.getPrecio()+valor;
        }
        return valor;
    }

    public Double valorTotal(){
        this.total=this.iva+this.sumaDeProductos()+this.valorEnvio;
        return this.total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
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
