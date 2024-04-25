package org.sid.billingservice.controller;

import lombok.AllArgsConstructor;
import org.sid.billingservice.entity.Bill;
import org.sid.billingservice.feignClient.CustomerServiceClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
    public CustomerService customerService;

    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable(name="id") Long id){
       return customerService.getCustomerService(id);
    }
}
