package org.sid.inventoryservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.inventoryservice.entity.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class inventoryService {
    private final ProductRepository postRepository;
    public void save(Product postRequest) {
        postRepository.save(postRequest);
    }

    public List<Product> afficher() {
        return  postRepository.findAll();
    }

}
