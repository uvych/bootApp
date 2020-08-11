package com.gb.boot.project.bootApp.service;

import com.gb.boot.project.bootApp.exceptions.ResourceNotFoundException;
import com.gb.boot.project.bootApp.model.Product;
import com.gb.boot.project.bootApp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
        private final ProductRepository productRepository;

        public void save(Product product) {
            productRepository.save(product);
        }

        public Product getProductById(Long id){
            return productRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        }

        public List<Product> getAllProduct(){
            return productRepository.findAll();
        }


        public void deleteById(Long id){
            productRepository.deleteById(id);
        }

        public void saveOrUpdate(Product product){
            productRepository.save(product);
        }
}
