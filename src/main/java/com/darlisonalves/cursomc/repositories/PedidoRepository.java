package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.Pedido;
import com.darlisonalves.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
