package org.sid.bilingservice;

import org.sid.bilingservice.entities.Bill;
import org.sid.bilingservice.entities.ProductItem;
import org.sid.bilingservice.feign.CustomerRestClient;
import org.sid.bilingservice.feign.ProductItemRestClient;
import org.sid.bilingservice.model.Customer;
import org.sid.bilingservice.model.Product;
import org.sid.bilingservice.repository.BillRepository;
import org.sid.bilingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BilingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilingServiceApplication.class, args);
    }

    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductItemRestClient productItemRestClient){
        return args -> {
            Customer customer=customerRestClient.getCustomerById(1L);
            Bill bill=billRepository.save(new Bill(null, new Date(), null, customer.getId(), null));
            PagedModel<Product> productPagedModel=productItemRestClient.pageProducts();
            productPagedModel.forEach(p->{
                ProductItem productItem= new ProductItem();
                ProductItem
            });


        };
    }

}
