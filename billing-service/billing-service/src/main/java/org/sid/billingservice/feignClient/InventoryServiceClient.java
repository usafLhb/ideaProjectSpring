package org.sid.billingservice.feignClient;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="INVENTORY-SERVICE")
public interface InventoryServiceClient {
    @GetMapping("/products/{id}?projection=fullProduct")
    Product findProductById(@PathVariable("id") Long id);
    @GetMapping("/products")
    PagedModel<Product> findAll();
    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
    @PostMapping
    ResponseEntity save(@RequestBody Product postRequest);
}
