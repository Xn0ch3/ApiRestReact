package com.example.controllers;

import com.example.dtos.CreateProductDTO;
import com.example.dtos.ProductDTO;
import com.example.models.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProductsDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        ProductDTO productDTO = productService.getProductDTO(id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody CreateProductDTO createProductDTO){
        return productService.createProduct(createProductDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
         productService.deleteProduct(id);
    }
}
