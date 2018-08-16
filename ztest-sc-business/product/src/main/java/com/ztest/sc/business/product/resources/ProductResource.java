package com.ztest.sc.business.product.resources;

import com.ztest.sc.business.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/8/14 0014 57
 */
@RestController
public class ProductResource {

    @Autowired
    private ProductService productService;


    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

}
