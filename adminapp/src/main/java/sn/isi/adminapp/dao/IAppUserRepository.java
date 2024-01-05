package sn.isi.adminapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.adminapp.entities.AppUserEntity;

public interface IAppUserRepository extends JpaRepository<AppUserEntity, Integer> {
}
