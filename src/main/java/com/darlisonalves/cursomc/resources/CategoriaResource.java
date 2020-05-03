package com.darlisonalves.cursomc.resources;

import com.darlisonalves.cursomc.domain.Categoria;
import com.darlisonalves.cursomc.dto.CategoriaDTO;
import com.darlisonalves.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = this.service.findAll();
        List<CategoriaDTO> dtoList = list.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @RequestMapping( value = "/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<Categoria> find(@PathVariable Integer id) {
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

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<Categoria> list = this.service.findPage( page, linesPerPage, orderBy, direction );
        Page<CategoriaDTO> listDto = list.map(categoria -> new CategoriaDTO(categoria));
        return ResponseEntity.ok().body(listDto);
    }

}
