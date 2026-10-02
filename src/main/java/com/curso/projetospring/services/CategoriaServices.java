package com.curso.projetospring.services;

import com.curso.projetospring.entities.Categoria;
import com.curso.projetospring.entities.Pedido;
import com.curso.projetospring.repositories.CategoriaRepository;
import com.curso.projetospring.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registra a classe como sendo um componente do Spring
public class CategoriaServices {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();

    }

    public Categoria findById(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.get();
    }

}
