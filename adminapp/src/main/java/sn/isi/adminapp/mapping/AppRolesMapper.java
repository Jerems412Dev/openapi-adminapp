package sn.isi.adminapp.mapping;

import org.mapstruct.Mapper;
import sn.isi.adminapp.entities.AppRolesEntity;
import sn.isi.generated.model.RoleDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppRolesMapper {
    RoleDTO toAppRoles(AppRolesEntity appRolesEntity);
    AppRolesEntity fromAppRoles(RoleDTO roleDTO);
    List<RoleDTO> rolesListDTO(List<AppRolesEntity> roleEntities);
}
