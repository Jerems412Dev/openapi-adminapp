package sn.isi.adminapp.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sn.isi.adminapp.service.AppRolesService;
import sn.isi.generated.api.RolesApi;
import sn.isi.generated.model.RoleDTO;
import sn.isi.generated.model.RolesResultListDTO;
import javax.validation.Valid;

@RestController
public class RoleController implements RolesApi {
    private final AppRolesService appRolesService;
    RoleController(AppRolesService appRolesService) {
        this.appRolesService = appRolesService;
    }
    @Override
    public ResponseEntity<RolesResultListDTO> getAllAppRole(Integer currentPage, Integer sizePage) throws Exception {
        RolesResultListDTO list = new RolesResultListDTO();
        list.setRoleList(appRolesService.getAllAppRole());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<RoleDTO> createAppRole(@Valid @RequestBody(required = false) RoleDTO roleDTO) throws Exception {
        return new ResponseEntity<>(appRolesService.createAppRoles(roleDTO), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<RoleDTO> getAppRole(@ApiParam(value = "",required=true) @PathVariable("idRole") Long idRole) throws Exception {
        return new ResponseEntity<>(appRolesService.getAppRole(idRole.intValue()),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<RoleDTO> updateAppRole(@ApiParam(value = "",required=true) @PathVariable("idRole") Long idRole,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) RoleDTO roleDTO) throws Exception {
        return new ResponseEntity<>(appRolesService.updateAppRoles(idRole.intValue(),roleDTO),HttpStatus.OK);
    }
}
