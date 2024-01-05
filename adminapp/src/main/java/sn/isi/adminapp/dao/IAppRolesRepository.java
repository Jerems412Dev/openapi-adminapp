package sn.isi.adminapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.adminapp.entities.AppRolesEntity;

public interface IAppRolesRepository extends JpaRepository<AppRolesEntity, Integer> {
}
