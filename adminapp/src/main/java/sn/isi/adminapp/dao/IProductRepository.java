package sn.isi.adminapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.adminapp.entities.ProductEntity;
public interface IProductRepository extends JpaRepository<ProductEntity, Integer> {
}
