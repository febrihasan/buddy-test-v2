package org.ait.project.product.modules.product.service.delegate.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.ait.project.product.modules.product.exception.JPHProductNotFoundException;
import org.ait.project.product.modules.product.model.entity.Product;
import org.ait.project.product.modules.product.model.repository.ProductRepository;
import org.ait.project.product.modules.product.service.delegate.ProductDelegate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**.
 * Class Product Delegate Implements
 */
@Service
@RequiredArgsConstructor
public class ProductDelegateImpl implements ProductDelegate {

  private final ProductRepository repository;

  public List<Product> getAllProducts() {
    return repository.findAll();
  }

  @Override
  public Page<Product> getAllProductsWithPage(final Pageable page) {
    return repository.findAll(page);
  }

  @Override
  public Product getProductById(final Long id) {
    return repository.findById(id).orElseThrow(JPHProductNotFoundException::new);
  }

  @Override
  public List<Product> saveAll(final List<Product> productList) {
    return repository.saveAll(productList);
  }

  @Override
  public Product save(final Product product) {
    return repository.save(product);
  }

  @Override
  public void deleteById(final Long id) {
    repository.deleteById(id);
  }

  @Override
  public void updateStockProduct(Boolean flag, final Long id) {
    repository.updateStockProduct(flag, id);
  }

}
