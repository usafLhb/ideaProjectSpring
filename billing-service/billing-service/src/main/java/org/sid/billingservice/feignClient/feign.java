package org.sid.billingservice.feignClient;

import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class feign {
    @FeignClient(name="customer-service")
    interface CustomerServiceClient{
        @GetMapping("/customers/{id}?projection=fullCustomer")
        Customer findCustomerById(@PathVariable("id") Long id);
    }
    @FeignClient(name="inventory-service")
    interface InventoryServiceClient{
        @GetMapping("/products/{id}?projection=fullProduct")
        Product findProductById(@PathVariable("id") Long id);
        @GetMapping("/products?projection=fullProduct")
        PagedModel<Product> findAll();
    }
}
