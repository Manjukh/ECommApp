import com.ecommerce.ECommApplication;
import com.ecommerce.controller.EcommController;
import com.ecommerce.model.Product;
import com.ecommerce.service.CartService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;




import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@ContextConfiguration(classes = ECommApplication.class )
@WebMvcTest(EcommController.class)
class EcommControllerTest {
    @MockBean
    private ProductService productService;
    @MockBean
    CartService cartService;
    @MockBean
    UserAccountService userAccountService;

    @Autowired
    private MockMvc mockMvc;


    private Product buildTestingProduct() {
        Product product = new Product();
        product.setProductId(1);
        product.setProductName("PRODUCT_NAME");
        product.setProductDescription("PRODUCT_DESCRIPTION");
        product.setProductPrice(10);
        return product;
    }
    @Test
    void should_return_product_list() throws Exception {
        Product product = this.buildTestingProduct();
        when(productService.getAllProducts()).thenReturn(List.of(product));

        mockMvc.perform( get("/getAllProducts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].productId", is(1)))
                .andExpect(jsonPath("$[0].productName", is("PRODUCT_NAME")))
                .andExpect(jsonPath("$[0].productDescription", is("PRODUCT_DESCRIPTION")))
                .andExpect(jsonPath("$[0].productPrice", is(10)));
    }



}


