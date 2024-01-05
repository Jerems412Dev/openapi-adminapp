package sn.isi.adminapp.mapping;

import org.mapstruct.Mapper;
import sn.isi.adminapp.entities.ProductEntity;
import sn.isi.generated.model.ProductDTO;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProduct(ProductEntity productEntity);
    ProductEntity fromProduct(ProductDTO productDTO);
    List<ProductDTO> productsListDTO(List<ProductEntity> productEntities);
}
