package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepositoy extends JpaRepository<Cidade, Integer> {

}
