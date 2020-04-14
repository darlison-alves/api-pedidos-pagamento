package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.Categoria;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {}
