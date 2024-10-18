package com.example.services.implement;


import com.example.dtos.CreateProductDTO;
import com.example.dtos.ProductDTO;
import com.example.models.Product;
import com.example.models.enums.ProductState;
import com.example.repository.ProductRepository;
import com.example.services.ProductService;
import com.example.services.UserService;
import com.example.util.ProductAlreadyNotAvailableException;
import com.example.util.ProductNoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;


    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existByProduct(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDTO> getAllProductsDTO() {
        return getAllProducts().stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
    }


    @Override
    public ProductDTO getProductDTO(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        if(product == null){
            return null;
        }

        ProductDTO productDTO = new ProductDTO(product);
        product.getName();
        product.getDescription();
        product.getPrice();
        product.getStock();
        product.getProductState();

        return productDTO;
    }

    @Override
    public ResponseEntity<String> createProduct(CreateProductDTO createProductDTO) {

        Product product = new Product(createProductDTO.getName()
                ,createProductDTO.getDescription(),createProductDTO.getPrice(),createProductDTO.getStock());

        productRepository.save(product);
        return new ResponseEntity<>("Product Created", HttpStatus.CREATED);
    }

    @Override
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            // Lanzamos una excepción para manejar el error
            throw new ProductNoFoundException("Product with id " + id + " not found.");
        }

        if(product.getProductState() == ProductState.NOTAVAILABLE){
            throw new ProductAlreadyNotAvailableException("Product with id " + id + " is already marked as not available.");
        }


        product.setProductState(ProductState.NOTAVAILABLE);
        productRepository.save(product);
    }


}
