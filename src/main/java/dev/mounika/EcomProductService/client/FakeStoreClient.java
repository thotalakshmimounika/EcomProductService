package dev.mounika.EcomProductService.client;

import dev.mounika.EcomProductService.dto.FakeStoreCartResponseDTO;
import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.base.url}")
    private String fakeStoreAPIBaseURL;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreAPIProductpath;
    @Value("${fakestore.api.cart.for.user.path}")
    private String fakeStoreAPICartForUser;


    public List<FakeStoreProductResponseDTO> getProducts() {
        String fakeStoreGetAllProductURL = fakeStoreAPIBaseURL.concat(fakeStoreAPIProductpath);
        RestTemplate restTemplat = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> productresponseList = restTemplat.
                getForEntity(fakeStoreGetAllProductURL, FakeStoreProductResponseDTO[].class);
        return List.of(productresponseList.getBody());
    }

    public FakeStoreProductResponseDTO getProductById(int id) {
        String fakeStoreGetProductURL = fakeStoreAPIBaseURL.concat(fakeStoreAPICartForUser).concat("/"+id);
        RestTemplate restTemplat = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> productreponse = restTemplat.getForEntity
                (fakeStoreGetProductURL, FakeStoreProductResponseDTO.class);
        return productreponse.getBody();
    }
    public List<FakeStoreCartResponseDTO> getCartByUserId(int userid) {
        //url - https://fakestoreapi.com/carts?userId=1
        String fakeStoreGetCartforUserURL = fakeStoreAPIBaseURL.concat(fakeStoreAPICartForUser).concat(String.valueOf(userid));
        RestTemplate restTemplat = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDTO[]> cartreponsedto = restTemplat.getForEntity
                (fakeStoreGetCartforUserURL, FakeStoreCartResponseDTO[].class);
        return List.of(cartreponsedto.getBody());
    }
}
//https://fakestoreapi.com/carts?userId=1