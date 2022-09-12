package org.ait.project.product.modules.product.service.delegate;

import java.util.List;
import org.ait.project.product.modules.product.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductDelegate {

  List<Product> getAllProducts();

  Page<Product> getAllProductsWithPage(Pageable page);

  Product getProductById(Long id);

  List<Product> saveAll(List<Product> products);

  Product save(Product product);

  void deleteById(Long id);

  void updateStockProduct(Boolean flag, Long id);

}
