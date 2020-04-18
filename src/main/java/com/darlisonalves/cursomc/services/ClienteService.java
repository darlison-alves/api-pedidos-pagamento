package com.darlisonalves.cursomc.services;

import com.darlisonalves.cursomc.domain.Cliente;
import com.darlisonalves.cursomc.repositories.ClienteRepository;
import com.darlisonalves.cursomc.services.exceptions.ObjectNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = this.clienteRepository.findById(id);
        return obj.orElseThrow( () -> new ObjectNotFountException("Objeto não encontrado! Id: " + id + " Tipo: " + Cliente.class.getName()));
    }
}
