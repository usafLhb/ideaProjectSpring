package org.sid.billingservice.controller;

import lombok.AllArgsConstructor;
import org.sid.billingservice.entity.Bill;
import org.sid.billingservice.feignClient.CustomerServiceClient;
import org.sid.billingservice.feignClient.InventoryServiceClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.sid.billingservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/client")
@CrossOrigin
public class ClientController {
    @Autowired
    private CustomerService customerService;

    @Autowired private CustomerServiceClient customerServiceClient;



    @GetMapping("/{id}")
    Customer getClientById(@PathVariable(name="id") Long id){
        Customer customer=customerServiceClient.findCustomerById(id);

        return customer; }
}

