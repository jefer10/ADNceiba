package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRegistroRepositoryJPA extends JpaRepository<Cliente,Long> {
}
