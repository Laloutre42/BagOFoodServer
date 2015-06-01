package com.zed.bagofood.controller;

import com.zed.bagofood.model.Product;
import com.zed.bagofood.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAllProduct() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value = "/origfdnm/{origfdnm}", method = RequestMethod.GET)
    public List<Product> getFoodListByOrigfdnm(@PathVariable String origfdnm) {
        return productRepository.findFirst100ByOrigfdnmLikeIgnoreCaseOrderByOrigfdnmAsc(origfdnm);
    }
}
