package com.zed.bagofood.controller;

import com.zed.bagofood.model.product.ProductCiqual;
import com.zed.bagofood.model.product.ProductField;
import com.zed.bagofood.repository.ProductCiqualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductCiqualRepository productRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProductCiqual> getAllProduct() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
     public ProductCiqual getProductById(@PathVariable String id) {
        return productRepository.findOne(id);
    }

    @RequestMapping(value = "/designation/{id}", method = RequestMethod.GET)
    public Collection<ProductField> getProductByIdWithDesignation(@PathVariable String id) {
        ProductCiqual product = productRepository.findOne(id);
        if (product != null){
            return product.getProductCiqualWithDesignation();
        }
        return new ArrayList<>();
    }

    @RequestMapping(value = "/origfdnm/{origfdnm}", method = RequestMethod.GET)
    public List<ProductCiqual> getFoodListByOrigfdnm(@PathVariable String origfdnm) {
        return productRepository.findFirst100ByOrigfdnmLikeIgnoreCaseOrderByOrigfdnmAsc(origfdnm);
    }
}
