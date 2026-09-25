package com.curso.projetospring.resources;

import com.curso.projetospring.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/user")
public class UsuarioResources {

    @GetMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario usuario = new Usuario(1L, "Telmo", "theo.cardeal@gmail.com", "11-973982593", "123456");
        return ResponseEntity.ok(usuario);
    }
}
