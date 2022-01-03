package com.shop.demo.controller;

import com.shop.demo.domain.Product;
import com.shop.demo.domain.ProductId;
import com.shop.demo.domain.ProductPrice;
import com.shop.demo.model.CreateProductInput;
import com.shop.demo.model.CreateProductOutput;
import com.shop.demo.model.UpdateProductInput;
import com.shop.demo.model.UpdateProductOutput;
import com.shop.demo.services.ProductServices;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductServices services;

    public ProductController(ProductServices services) {

        this.services = services;
    }


    @GetMapping
    public List<Product> listProduct() {
        return services.listProduct();
    }

    @PostMapping
    public CreateProductOutput createProduct(@RequestBody CreateProductInput input) {
        String name = (input.getName());
        String description = input.getDescription();
        ProductPrice productPrice = input.getPrice();
        ProductId random = ProductId.random();
        Product product = new Product(random, name, description, productPrice);
        Product createdProduct = services.createProduct(product);

        return new CreateProductOutput(createdProduct);
    }


    @GetMapping(value = "/{id}")
    public Product getProduct(@PathVariable("id") String productId) {
        final ProductId id = ProductId.fromString(productId);
        return services.getProduct(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") String productId) {
        final ProductId id = ProductId.fromString(productId);
        services.deleteProduct(id);
    }

    @PutMapping(value = "/{id}")//actualizar producto
    public UpdateProductOutput updateProductOutput(@PathVariable("id") String unsafeId, @RequestBody UpdateProductInput input) {
        final ProductId id = ProductId.fromString(unsafeId);
        //el fromString es un metodo estatico que internamente llama la constructor de productId
        Product newProduct = new Product(id, input.getName(), input.getDescription(), new ProductPrice(input.getPrice()));
        final Product updated = services.updateProduct(id, newProduct);
        return new UpdateProductOutput(updated);
    }
}