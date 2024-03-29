package sn.isi.adminapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.adminapp.dao.IAppRolesRepository;
import sn.isi.adminapp.exception.EntityNotFoundException;
import sn.isi.adminapp.exception.RequestException;
import sn.isi.adminapp.mapping.AppRolesMapper;
import sn.isi.generated.model.RoleDTO;

import java.util.List;
import java.util.Locale;

@Service
public class AppRolesService {
    private final IAppRolesRepository iAppRolesRepository;
    private final AppRolesMapper appRolesMapper;
    MessageSource messageSource;
    @Autowired
    public AppRolesService(IAppRolesRepository iAppRolesRepository, AppRolesMapper appRolesMapper, MessageSource messageSource) {
        this.iAppRolesRepository = iAppRolesRepository;
        this.appRolesMapper = appRolesMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<RoleDTO> getAllAppRole() {
        return appRolesMapper.rolesListDTO(iAppRolesRepository.findAll());
    }

    @Transactional(readOnly = true)
    public RoleDTO getAppRole(int id) {
        return appRolesMapper.toAppRoles(iAppRolesRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public RoleDTO createAppRoles(RoleDTO roleDTO) {
        return appRolesMapper.toAppRoles(iAppRolesRepository.save(appRolesMapper.fromAppRoles(roleDTO)));
    }

    @Transactional
    public RoleDTO updateAppRoles(long id, RoleDTO roleDTO) {
        return iAppRolesRepository.findById((int) id)
                .map(entity -> {
                    roleDTO.setIdRole(id);
                    return appRolesMapper.toAppRoles(
                            iAppRolesRepository.save(appRolesMapper.fromAppRoles(roleDTO)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppRolesRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
