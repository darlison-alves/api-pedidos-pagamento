package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
