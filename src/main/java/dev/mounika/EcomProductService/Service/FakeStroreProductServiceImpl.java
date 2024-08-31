package dev.mounika.EcomProductService.Service;

import dev.mounika.EcomProductService.client.FakeStoreClient;
import dev.mounika.EcomProductService.dto.FakeStoreProductResponseDTO;
import dev.mounika.EcomProductService.entity.Product;
import dev.mounika.EcomProductService.exception.ProductnotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeStroreProductServiceImpl implements ProductService{

    @Autowired
    private FakeStoreClient fakeStoreClient;


    @Override
    public List<FakeStoreProductResponseDTO> getAllproducts() {
        List<FakeStoreProductResponseDTO> fakeStoreproducts = fakeStoreClient.getProducts();
        return  fakeStoreproducts;
    }

    @Override
    public FakeStoreProductResponseDTO getProductById(int id) throws ProductnotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(id);
        if (fakeStoreProductResponseDTO == null) {
            throw new ProductnotFoundException("Product not found with id : "+id);
        }
        return fakeStoreProductResponseDTO;
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product, int id) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }
}
