package com.curso.projetospring.resources;

import com.curso.projetospring.entities.Pedido;
import com.curso.projetospring.entities.Produto;
import com.curso.projetospring.services.ProdutoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/produto")
public class ProdutoResources {

    //Injeção de dependencia com outra classe
    @Autowired //injeção de dependencia do spring
    private ProdutoServices produtoServices;



    @GetMapping
    public ResponseEntity<List <Produto>> findAll(){

        List<Produto> listarProdutosAll = produtoServices.findAll();

        return ResponseEntity.ok(listarProdutosAll);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto = produtoServices.findById(id);
        return ResponseEntity.ok(produto);
    }
}
