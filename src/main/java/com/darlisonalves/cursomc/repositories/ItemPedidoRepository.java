package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.ItemPedido;
import com.darlisonalves.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
