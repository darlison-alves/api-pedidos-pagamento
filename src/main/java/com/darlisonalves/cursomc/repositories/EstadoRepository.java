package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.Categoria;
import com.darlisonalves.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {}
