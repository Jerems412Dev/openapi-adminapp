package sn.isi.adminapp.mapping;

import org.mapstruct.Mapper;
import sn.isi.adminapp.entities.AppUserEntity;
import sn.isi.generated.model.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    UserDTO toAppUser(AppUserEntity appUserEntity);
    AppUserEntity fromAppUser(UserDTO userDTO);
    List<UserDTO> usersListDTO(List<AppUserEntity> userEntities);
}
