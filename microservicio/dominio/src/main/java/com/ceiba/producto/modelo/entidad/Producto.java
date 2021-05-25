package com.ceiba.producto.modelo.entidad;


import com.ceiba.pedido.modelo.entidad.Pedido;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="descrition")
    private String descripcion;

    @Column(name = "price")
    private Double precio;

    @JoinTable(
            name = " PRODUCTO_PEDIDO_ENTITIES ",
            joinColumns = @JoinColumn(name = "fk_product",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "fk_order",nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Pedido> pedido;

    public void addPedidos(Pedido pedidoEntity){
        if (this.pedido==null){
            this.pedido=new ArrayList<>();
        }
        this.pedido.add(pedidoEntity);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }
}
