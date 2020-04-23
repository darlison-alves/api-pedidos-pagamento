package com.darlisonalves.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    @JsonBackReference
    @ManyToMany
    @JoinTable( name = "PRODUTO_CATEGORIA",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> itemPedidos = new HashSet<ItemPedido>();

    public Produto() {};

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Set<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(Set<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    @JsonIgnore
    public List<Pedido> getPedidos() {
        List<Pedido> list = new ArrayList<Pedido>();
        for ( ItemPedido x : this.itemPedidos ) {
            list.add(x.getPedido());
        }
        return list;
    }
}
