package org.sid.billingservice.feignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}")
     public   Customer getCustomerById(@PathVariable("id") Long id);


    @GetMapping("/customers/{id}?projection=fullCustomer")
    @CircuitBreaker(name="customerService",fallbackMethod="getDefaultCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name="customerServiceAll",fallbackMethod="getDefaultAllCustomer")
    PagedModel<Customer> findAll();
    default   List<Customer> getDefaultAllCustomer(Exception exception){return List.of();}

    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setName("Not  available");
        customer.setEmail("Not  available");
        return customer;
    }
}
