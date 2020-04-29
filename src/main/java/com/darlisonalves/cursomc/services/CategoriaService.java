package com.darlisonalves.cursomc.services;

import com.darlisonalves.cursomc.domain.Categoria;
import com.darlisonalves.cursomc.repositories.CategoriaRepository;
import com.darlisonalves.cursomc.services.exceptions.ObjectNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository ctaRepo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = ctaRepo.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFountException("Objeto não encontrado! ID "+ id + " Tipo: " + Categoria.class.getName()));
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(null);
        return this.ctaRepo.save(categoria);
    }
}
