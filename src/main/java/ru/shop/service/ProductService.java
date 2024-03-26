package ru.shop.service;

import org.springframework.stereotype.Service;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByProductType(ProductType productType) {
        return productRepository.findAll().stream().filter(p -> p.productType() == productType).toList();
    }
}
