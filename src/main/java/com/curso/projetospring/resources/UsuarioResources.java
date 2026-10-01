package com.curso.projetospring.resources;

import com.curso.projetospring.entities.Usuario;
import com.curso.projetospring.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/user")
public class UsuarioResources {

    //Injeção de dependencia com outra classe
    @Autowired //injeção de dependencia do spring
    private UsuarioServices  usuarioServices;



    @GetMapping
    public ResponseEntity<List <Usuario>> findAll(){
        //Dados mokado
        //Usuario usuario = new Usuario(1L, "Telmo", "theo.cardeal@gmail.com", "11-973982593", "123456");

        List<Usuario> listaUsuarioAll = usuarioServices.findAll();

        return ResponseEntity.ok(listaUsuarioAll);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario usuario = usuarioServices.findById(id);
        return ResponseEntity.ok(usuario);
    }
}
