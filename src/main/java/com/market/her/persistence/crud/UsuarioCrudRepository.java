package com.market.her.persistence.crud;


import com.market.her.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    Optional<Usuario> findByNomUsuarioAndContrasenia(String username, String password);
    // List<Usuario> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    //Optional<List<Usuario>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
