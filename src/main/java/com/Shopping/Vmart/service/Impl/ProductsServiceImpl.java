package com.Shopping.Vmart.service.Impl;

import com.Shopping.Vmart.entity.Products;
import com.Shopping.Vmart.excepction.ResourceNotFoundException;
import com.Shopping.Vmart.repositry.ProductsRepository;
import com.Shopping.Vmart.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class ProductsServiceImpl implements Service {
    @Autowired
    private ProductsRepository productsRepository;
    @Override
    public List<Products> getAllProducts() {

        return productsRepository.findAll();
    }

    @Override
    public Products saveProducts(Products products) {
        return productsRepository.save(products);
    }

    @Override
    public Products getProductsById(Long id) {

        return productsRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Product not found With id:"+id));

    }

    @Override
    public Products updateProduct(Long id,Products productsDetails) {
        Products products = productsRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("product not found with id:"+id));
        products.setProductName(productsDetails.getProductName());
        products.setProductPrice(productsDetails.getProductPrice());
        
        Products updatedproduct=productsRepository.save(products);
        return ResponseEntity.ok(updatedproduct).getBody();
    }

    @Override
    public void deleteProductById(Long id) {
        Products products = productsRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("product Does Not Exist With Id: "+id));
        productsRepository.delete(products);
    }
}
