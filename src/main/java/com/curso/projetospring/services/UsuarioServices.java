package com.curso.projetospring.services;

import com.curso.projetospring.entities.Usuario;
import com.curso.projetospring.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registra a classe como sendo um componente do Spring
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();

    }

    public Usuario findById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    public Usuario insertUsuario(Usuario incluirUsuario) {
        return usuarioRepository.save(incluirUsuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario updateUsuario(Long id, Usuario atualizarUsuario) {
        Usuario entidade = usuarioRepository.getReferenceById(id);
        updateData(entidade, atualizarUsuario);
        return usuarioRepository.save(entidade);

    }


    private void updateData(Usuario entidade, Usuario atualizarUsuario) {
        entidade.setNome(atualizarUsuario.getNome());
        entidade.setEmail(atualizarUsuario.getEmail());
        entidade.setFone(atualizarUsuario.getFone());
    }
}
