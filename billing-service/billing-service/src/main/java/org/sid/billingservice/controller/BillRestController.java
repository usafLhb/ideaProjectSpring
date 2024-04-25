package org.sid.billingservice.controller;

import lombok.AllArgsConstructor;
import org.sid.billingservice.entity.Bill;
import org.sid.billingservice.feignClient.CustomerServiceClient;
import org.sid.billingservice.feignClient.InventoryServiceClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/bills")
@CrossOrigin
public class BillRestController {

    @Autowired
    private BillRepository billRepository;
    @Autowired private ProductItemRepository productItemRepository;
    @Autowired private CustomerServiceClient customerServiceClient;
    @Autowired private InventoryServiceClient inventoryServiceClient;
    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
      //  bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });
        return bill; }

    @GetMapping("/{id}")
    Bill getBillById(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        //  bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });
        return bill; }

    @GetMapping("/fullBill/{id}")
    Bill getBillById2(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        Customer customer=customerServiceClient.findCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });
        return bill; }
}

