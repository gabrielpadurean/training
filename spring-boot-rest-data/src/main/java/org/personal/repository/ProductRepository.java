package org.personal.repository;

import org.personal.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author gabi
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}