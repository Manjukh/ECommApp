import com.ecommerce.Repository.ProductRepository;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

        @InjectMocks
        private ProductService productService;

    @Test
    void getAllProducts_should_return_list() {
    Product product =this.buildTestingProduct();
    when(productRepository.findAll()).thenReturn(List.of(product));
    List<Product> products=this.productService.getAllProducts();
    assertEquals(1,products.size());
    verify(this.productRepository).findAll();

    }


    private Product buildTestingProduct() {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("PRODUCT_NAME");
        product.setProductDescription("PRODUCT_DESCRIPTION");
        product.setProductPrice(10);
        return product;
    }

    @Test
    void addNewProduct_should_insert_new_product() {
        // Given
       Product product = this.buildTestingProduct();
        // When
        this.productService.addNewProduct(product);
        // Then
        verify(this.productRepository).save(product);
    }
}



