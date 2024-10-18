package com.example.services;

import com.example.dtos.CreateProductDTO;
import com.example.dtos.ProductDTO;
import com.example.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    Product findById(Long id);
    boolean existByProduct(Long id);
    void saveProduct(Product product);
    List<Product> getAllProducts();
    List<ProductDTO> getAllProductsDTO();
    ProductDTO getProductDTO(Long id);
    ResponseEntity<String> createProduct(CreateProductDTO createProductDTO);
    void deleteProduct(Long id);
}
