package com.Shopping.Vmart.service;

import com.Shopping.Vmart.entity.Products;
import com.Shopping.Vmart.repositry.ProductsRepository;

import java.util.List;

public interface Service {

    List<Products> getAllProducts();

    Products saveProducts(Products products);

   Products getProductsById(Long id);

   Products updateProduct(Long id,Products products);

   void deleteProductById(Long id);
}
