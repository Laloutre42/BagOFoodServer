package com.zed.bagofood.repository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.Item;
import com.zed.bagofood.model.product.Product;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findFirst100ByOrigfdnmLikeIgnoreCaseOrderByOrigfdnmAsc(String origfdnm);
}
