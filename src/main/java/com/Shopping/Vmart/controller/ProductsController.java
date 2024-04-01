package com.Shopping.Vmart.controller;

import com.Shopping.Vmart.entity.Products;
import com.Shopping.Vmart.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/Vmart")
public class ProductsController {
    @Autowired
    private Service service;

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return service.getAllProducts();
    }
    @PutMapping("/create")
    public Products createProducts(@RequestBody Products products){
        return service.saveProducts(products);
    }

    @GetMapping("/products/{id}")
    public Products getProductById(@PathVariable Long id){
        Products products = service.getProductsById(id);
        return ResponseEntity.ok(products).getBody();

    }
    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable Long id, @RequestBody Products products){
        Products products1 = service.updateProduct(id,products);
        return ResponseEntity.ok(products1).getBody();
    }

    @DeleteMapping("/products/{id}")
    public Map<String , Boolean> deleteProduct(@PathVariable Long id){
        service.deleteProductById(id);
        Map<String, Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        System.out.println("Deleted ");
        return ResponseEntity.ok(response).getBody();
    }

}
