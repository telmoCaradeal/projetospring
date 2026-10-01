package com.curso.projetospring.resources;

import com.curso.projetospring.entities.Pedido;
import com.curso.projetospring.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value ="/pedido")
public class PedidoResources {

    //Injeção de dependencia com outra classe
    @Autowired //injeção de dependencia do spring
    private PedidoServices pedidoServices;



    @GetMapping
    public ResponseEntity<List <Pedido>> findAll(){

        List<Pedido> listarPedidoAll = pedidoServices.findAll();

        return ResponseEntity.ok(listarPedidoAll);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido pedido = pedidoServices.findById(id);
        return ResponseEntity.ok(pedido);
    }
}
