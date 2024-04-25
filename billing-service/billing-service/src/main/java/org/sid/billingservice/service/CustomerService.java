package org.sid.billingservice.service;

import lombok.RequiredArgsConstructor;
import org.sid.billingservice.feignClient.CustomerServiceClient;
import org.sid.billingservice.feignClient.InventoryServiceClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    public CustomerService(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerServiceClient customerServiceClient, InventoryServiceClient inventoryServiceClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerServiceClient = customerServiceClient;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    private BillRepository billRepository;
      private ProductItemRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
     private InventoryServiceClient inventoryServiceClient;

     public Customer getCustomerService(long id){
         Customer customer=customerServiceClient.findCustomerById(id);
         return customer;
     }
}
