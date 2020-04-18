package com.darlisonalves.cursomc.repositories;

import com.darlisonalves.cursomc.domain.Cliente;
import com.darlisonalves.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
