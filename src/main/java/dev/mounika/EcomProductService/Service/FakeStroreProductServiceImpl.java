package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.client.FakeStoreClient;
import dev.mounika.EcomProductService.dto.FakeStoreDTO.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.NoProductPresentException;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("FakeStoreService")
public class FakeStroreProductServiceImpl{

    @Autowired
    private FakeStoreClient fakeStoreClient;


    public List<FakeStoreProductResponseDTO> getAllproducts() {
        List<FakeStoreProductResponseDTO> fakeStoreproducts = fakeStoreClient.getProducts();
        if(fakeStoreproducts == null){
            throw new NoProductPresentException("No products are found");
        }
        return  fakeStoreproducts;
    }

    public FakeStoreProductResponseDTO getProductById(int id) throws ProductnotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(id);
        if (fakeStoreProductResponseDTO == null) {
            throw new ProductnotFoundException("Product not found with id : "+id);
        }
        return fakeStoreProductResponseDTO;
    }

    public Product createProduct(Product product) {
        return null;
    }

    public Product updateProduct(Product product, int id) {
        return null;
    }

    public boolean deleteProduct(int id) {
        return false;
    }
}
