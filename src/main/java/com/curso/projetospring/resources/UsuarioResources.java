package com.curso.projetospring.resources;

import com.curso.projetospring.entities.Usuario;
import com.curso.projetospring.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value ="/usuario")
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

    @PostMapping()
    public ResponseEntity<Usuario> insert(@RequestBody Usuario incluir){
        incluir = usuarioServices.insertUsuario(incluir);
        //return ResponseEntity.ok(incluir);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(incluir.getId()).toUri(); //metodo para retornar um 201OK na inclusão
        return  ResponseEntity.created(uri).body(incluir);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
            usuarioServices.deleteUsuario(id);
            return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario atualizarUsuario){
            atualizarUsuario = usuarioServices.updateUsuario(id, atualizarUsuario);
            return ResponseEntity.ok().body(atualizarUsuario);
    }


}
