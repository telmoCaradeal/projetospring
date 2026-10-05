package com.curso.projetospring.services;

import com.curso.projetospring.entities.Usuario;
import com.curso.projetospring.repositories.UsuarioRepository;
import com.curso.projetospring.services.exceptions.DatabaseException;
import com.curso.projetospring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario insertUsuario(Usuario incluirUsuario) {
        return usuarioRepository.save(incluirUsuario);
    }

    public void deleteUsuario(Long id) {
        try {
            usuarioRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }

    }

    public Usuario updateUsuario(Long id, Usuario atualizarUsuario) {
        try {
            Usuario entidade = usuarioRepository.getReferenceById(id);
            updateData(entidade, atualizarUsuario);
            return usuarioRepository.save(entidade);
        }catch (RuntimeException e){
            //throw new ResourceNotFoundException(id);
            e.printStackTrace();
        }


        return atualizarUsuario;
    }


    private void updateData(Usuario entidade, Usuario atualizarUsuario) {
        entidade.setNome(atualizarUsuario.getNome());
        entidade.setEmail(atualizarUsuario.getEmail());
        entidade.setFone(atualizarUsuario.getFone());
    }
}
