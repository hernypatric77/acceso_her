package com.market.her.persistence;

import com.market.her.domain.dto.User;
import com.market.her.domain.repository.UserRepository;
import com.market.her.persistence.crud.UsuarioCrudRepository;
import com.market.her.persistence.entity.Usuario;
import com.market.her.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;



    /*@Override
    public List<User> getAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();

        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> getUser(int userId) {
        return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
    }*/

    @Override
    public Optional<User> loginUser(String userName, String password ) throws NoSuchElementException {
        Optional<Usuario> usuario = usuarioCrudRepository.findByNomUsuarioAndContrasenia(userName, password);
        Usuario u = usuario.get();
        User user = new User(u.getIdUsuario(), u.getNomUsuario(), u.getEstado(), u.getNombre());
        return Optional.of(user);
    }


}
