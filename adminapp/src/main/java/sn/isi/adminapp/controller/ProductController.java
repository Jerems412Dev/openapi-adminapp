package sn.isi.adminapp.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sn.isi.adminapp.service.ProductService;
import sn.isi.generated.api.ProductsApi;
import sn.isi.generated.model.ProductDTO;
import sn.isi.generated.model.ProductsResultListDTO;
import javax.validation.Valid;

@RestController
public class ProductController implements ProductsApi {
    private final ProductService productService;
    ProductController(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public ResponseEntity<ProductsResultListDTO> getAllAppProduct(Integer currentPage, Integer sizePage) {
        ProductsResultListDTO list = new ProductsResultListDTO();
        list.setProductList(productService.getAllProduct());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductDTO> createAppProduct(@Valid @RequestBody(required = false) ProductDTO productDTO) throws Exception {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductDTO> getAppProduct(@ApiParam(value = "",required=true) @PathVariable("idProduct") Long idProduct) throws Exception {
        return new ResponseEntity<>(productService.getProduct(idProduct.intValue()),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<ProductDTO> updateAppProduct(@ApiParam(value = "",required=true) @PathVariable("idProduct") Long idProduct,@ApiParam(value = ""  )  @Valid @RequestBody(required = false) ProductDTO productDTO) throws Exception {
        return new ResponseEntity<>(productService.updateProduct(idProduct.intValue(),productDTO),HttpStatus.OK);
    }
}
