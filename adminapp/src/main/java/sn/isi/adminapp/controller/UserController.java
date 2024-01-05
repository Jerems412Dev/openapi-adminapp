package sn.isi.adminapp.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sn.isi.adminapp.service.AppUserService;
import sn.isi.generated.api.UsersApi;
import sn.isi.generated.model.UserDTO;
import sn.isi.generated.model.UsersResultListDTO;
import javax.validation.Valid;

@RestController
public class UserController implements UsersApi {
    private final AppUserService appUserService;
    UserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }
    @Override
    public ResponseEntity<UsersResultListDTO> getAllAppUser(Integer currentPage, Integer sizePage) throws Exception {
        UsersResultListDTO list = new UsersResultListDTO();
        list.setUserList(appUserService.getAllAppUser());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDTO> createAppUser(@Valid @RequestBody(required = false) UserDTO userDTO) throws Exception {
        return new ResponseEntity<>(appUserService.createAppUser(userDTO), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDTO> getAppUser(@ApiParam(value = "",required=true) @PathVariable("idUser") Long idUser) throws Exception {
        return new ResponseEntity<>(appUserService.getAppUser(idUser.intValue()),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<UserDTO> updateAppUser(@ApiParam(value = "",required=true) @PathVariable("idUser") Long idUser,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) UserDTO userDTO) throws Exception {
        return new ResponseEntity<>(appUserService.updateAppUser(idUser.intValue(),userDTO),HttpStatus.OK);
    }
}
