package com.zed.bagofood.repository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.product.ProductCiqual;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCiqualRepository extends CrudRepository<ProductCiqual, Long> {

    List<ProductCiqual> findFirst100ByOrigfdnmLikeIgnoreCaseOrderByOrigfdnmAsc(String origfdnm);
}
