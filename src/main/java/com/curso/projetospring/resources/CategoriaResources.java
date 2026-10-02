package com.curso.projetospring.resources;

import com.curso.projetospring.entities.Categoria;
import com.curso.projetospring.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/categoria")
public class CategoriaResources {

    //Injeção de dependencia com outra classe
    @Autowired //injeção de dependencia do spring
    private CategoriaServices categoriaServices;



    @GetMapping
    public ResponseEntity<List <Categoria>> findAll(){

        List<Categoria> listarCategoriasAll = categoriaServices.findAll();

        return ResponseEntity.ok(listarCategoriasAll);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = categoriaServices.findById(id);
        return ResponseEntity.ok(categoria);
    }
}
