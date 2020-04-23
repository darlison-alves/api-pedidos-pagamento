package com.darlisonalves.cursomc.services;

import com.darlisonalves.cursomc.domain.Pedido;
import com.darlisonalves.cursomc.repositories.PedidoRepository;
import com.darlisonalves.cursomc.services.exceptions.ObjectNotFountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido find(Integer id) {
        Optional<Pedido> obj = this.pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFountException("Objeto não encontrado! ID " + id + " Tipo: " + Pedido.class.getName()));
    }
}
