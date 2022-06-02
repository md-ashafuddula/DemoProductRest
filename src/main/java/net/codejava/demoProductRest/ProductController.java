package net.codejava.demoProductRest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/products")
	public List<Product> list() {
		return service.listAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Product>( HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/products")
	public void add(@RequestBody Product product){ //annotation automatic serialize Json response to Java object
		try {
			service.save(product);
		}catch(Exception e) {
			System.out.println("product creation error");
		}
	}
	
	@PutMapping("/products/{id}") // Note: id and Json id not sync
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
	    try {
	        Product existProduct = service.get(id);;
	        if (Objects.nonNull(product.getId()) && product.getId()!= 0) {
	        	existProduct.setId(id);
			}

			if (Objects.nonNull(product.getName())	&& !"".equalsIgnoreCase(product.getName())) {
				existProduct.setName(product.getName());
			}

			if (Objects.nonNull(product.getPrice())	&& product.getPrice() != 0.0) {
				existProduct.setPrice(product.getPrice());
			}
	        service.save(product);
	        return new ResponseEntity<>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
	    service.delete(id);
	}
}
