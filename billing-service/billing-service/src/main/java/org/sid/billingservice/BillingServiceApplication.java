package org.sid.billingservice;

import org.sid.billingservice.entity.Bill;
import org.sid.billingservice.entity.ProductItem;
import org.sid.billingservice.feignClient.CustomerServiceClient;
import org.sid.billingservice.feignClient.InventoryServiceClient;
import org.sid.billingservice.model.Customer;
import org.sid.billingservice.model.Product;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
		System.out.println("Billing service !");
	}

@Bean
CommandLineRunner start(

		BillRepository billRepository,
		ProductItemRepository productItemRepository,
		CustomerServiceClient customerRestClient,
		InventoryServiceClient productiteRestClient ){
		return args -> {
			Customer customer=customerRestClient.getCustomerById(1L);
			Bill facture= new Bill(null,new Date(),null,customer.getId(),null);
			billRepository.save(facture);

			PagedModel<Product> productPageModel=productiteRestClient.findAll();
			productPageModel.forEach(p->{
				ProductItem productItem=new ProductItem();
				productItem.setPrice(p.getPrice());
				productItem.setProductID(p.getId());
				productItem.setProductID(p.getId());
				productItem.setQuantity(1+new Random().nextInt(100));
				productItem.setBill(facture);
				productItemRepository.save(productItem);
			});



		};
}
}
