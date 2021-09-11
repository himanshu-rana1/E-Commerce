package com.ecommerce.catalogservice;

import com.ecommerce.catalogservice.entity.Products;
import com.ecommerce.catalogservice.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Component
	public class ItemInitializer implements CommandLineRunner{

		@Autowired
		private ProductsRepository productsRepository;

		@Override
		public void run(String... args) throws Exception {
			productsRepository.deleteAll();

			productsRepository.save(new Products("POCO X3", "Mobile", "Red", "XAIOMI", "Nice Phone",25, 25000.00));
			productsRepository.save(new Products("POCO X3", "Mobile", "Blue", "XAIOMI", "Nice Phone", 25, 25000.00));
			productsRepository.save(new Products("ONE PLUS 7", "Mobile", "Black", "ONE PLUS", "Nice Phone", 20, 53000.00));
			productsRepository.save(new Products("IPHONE X", "Mobile", "White", "APPLE", "Nice Phone", 10, 110000.00));
            productsRepository.save(new Products("IPHONE X", "Mobile", "White", "APPLE", "Nice Phone", 10, 110000.00));
            productsRepository.save(new Products("SHOES", "Shoes", "White", "NIKE", "Sports Shoes", 100, 1800.00));
            productsRepository.save(new Products("SHOES", "Shoes", "Black", "PUMA", "Casual Shoes", 10, 1913.00));
            productsRepository.save(new Products("SHOES", "Shoes", "Blue",  "ADIDAS","Sports Shoes", 20, 2000.00));
            productsRepository.save(new Products("SHOES", "Shoes", "Black", "PUMA", "Casual Shoes", 60, 2500.00));
            productsRepository.save(new Products("SHOES", "Shoes", "Green", "NIKE", "Sports Shoes", 13, 2300.00));

		}
	}
}
