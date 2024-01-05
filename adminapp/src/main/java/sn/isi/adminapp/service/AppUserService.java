package sn.isi.adminapp.service;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.adminapp.dao.IAppUserRepository;
import sn.isi.adminapp.exception.EntityNotFoundException;
import sn.isi.adminapp.exception.RequestException;
import sn.isi.adminapp.mapping.AppUserMapper;
import sn.isi.generated.model.UserDTO;

import java.util.List;
import java.util.Locale;

@Service
public class AppUserService {
    private IAppUserRepository iAppUserRepository;
    private AppUserMapper appUserMapper;
    MessageSource messageSource;

    public AppUserService(IAppUserRepository iAppUserRepository, AppUserMapper appUserMapper, MessageSource messageSource) {
        this.iAppUserRepository = iAppUserRepository;
        this.appUserMapper = appUserMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getAllAppUser() {
        return appUserMapper.usersListDTO(iAppUserRepository.findAll());
    }
    @Transactional(readOnly = true)
    public UserDTO getAppUser(int id) {
        return appUserMapper.toAppUser(iAppUserRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional
    public UserDTO createAppUser(UserDTO userDTO) {
        return appUserMapper.toAppUser(iAppUserRepository.save(appUserMapper.fromAppUser(userDTO)));
    }

    @Transactional
    public UserDTO updateAppUser(long id, UserDTO userDTO) {
        return iAppUserRepository.findById((int) id)
                .map(entity -> {
                    userDTO.setIdUser(id);
                    return appUserMapper.toAppUser(
                            iAppUserRepository.save(appUserMapper.fromAppUser(userDTO)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    public void deleteAppUser(int id) {
        try {
            iAppUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }
}
