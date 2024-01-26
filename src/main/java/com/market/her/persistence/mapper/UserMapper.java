package com.market.her.persistence.mapper;


import com.market.her.domain.dto.User;
import com.market.her.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//@Mapper(componentModel = "spring")
public interface UserMapper {
   /* @Mappings({
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nomUsuario", target = "userName"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "estado", target = "status"),
            @Mapping(source = "contrasenia", target = "password")

    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);*/
}
