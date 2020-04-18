package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.Pagamento;
import com.darlisonalves.cursomc.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
