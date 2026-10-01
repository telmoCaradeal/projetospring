package com.curso.projetospring.services;

import com.curso.projetospring.entities.Pedido;
import com.curso.projetospring.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registra a classe como sendo um componente do Spring
public class PedidoServices {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();

    }

    public Pedido findById(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.get();
    }

}
