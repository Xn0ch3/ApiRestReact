package com.example;

import com.example.models.Product;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GuiaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuiaSpringApplication.class, args);

	}

	@Bean
	public CommandLineRunner initData(UserRepository userRepository, ProductRepository productRepository){
		return args -> {

			Product product1 = new Product("Smartphone XYZ", "A high-end smartphone with great features", 699.99, 150);
			Product product2 = new Product("Laptop ABC", "Lightweight laptop with powerful performance", 999.99, 75);
			Product product3 = new Product("Tablet DEF", "High-resolution display tablet", 499.99, 200);
			Product product4 = new Product("Smartwatch GHI", "Water-resistant smartwatch with health tracking", 199.99, 300);
			Product product5 = new Product("Wireless Headphones JKL", "Noise-cancelling over-ear headphones", 149.99, 120);
			Product product6 = new Product("Bluetooth Speaker MNO", "Portable speaker with excellent sound quality", 89.99, 50);
			Product product7 = new Product("Gaming Console PQR", "Next-gen gaming console with 4K support", 499.99, 40);
			Product product8 = new Product("Smart TV STU", "65-inch 4K UHD Smart TV", 799.99, 60);
			Product product9 = new Product("Digital Camera VWX", "Compact digital camera with 20MP sensor", 299.99, 85);
			Product product10 = new Product("Fitness Tracker YZ", "Waterproof fitness tracker with GPS", 99.99, 180);

			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);
			productRepository.save(product4);
			productRepository.save(product5);
			productRepository.save(product6);
			productRepository.save(product7);
			productRepository.save(product8);
			productRepository.save(product9);
			productRepository.save(product10);
		};
	}
}
