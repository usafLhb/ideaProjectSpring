package org.sid.inventoryservice.controller;


import ch.qos.logback.core.model.Model;
import lombok.AllArgsConstructor;
import org.sid.inventoryservice.entity.Product;
import org.sid.inventoryservice.service.inventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inventory")
@CrossOrigin
public class productController {
    private final inventoryService productService;
    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> createPost(@RequestBody Product postRequest){
        System.out.println("postRequest "+postRequest);
        productService.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> showAllProducts() {
        return  productService.afficher(); // returns the view name
    }
}
