package com.curso.projetospring.services;

import com.curso.projetospring.entities.Produto;
import com.curso.projetospring.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registra a classe como sendo um componente do Spring
public class ProdutoServices {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();

    }

    public Produto findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

}
