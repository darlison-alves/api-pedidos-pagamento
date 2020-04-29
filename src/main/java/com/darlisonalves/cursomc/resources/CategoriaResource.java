package com.darlisonalves.cursomc.resources;

import com.darlisonalves.cursomc.domain.Categoria;
import com.darlisonalves.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping( value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {
        Categoria obj = service.find(id);
        return ResponseEntity.ok(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create( @RequestBody Categoria categoria ) {
        Categoria categoria1 = this.service.create(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> update( @PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        this.service.update(categoria);
        return ResponseEntity.ok().body(categoria);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete( @PathVariable Integer id ) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
