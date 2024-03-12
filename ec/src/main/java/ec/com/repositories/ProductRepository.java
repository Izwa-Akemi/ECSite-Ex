package ec.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.models.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity save(ProductEntity productEntity);
	ProductEntity findByProductName(String productName);
	ProductEntity findByProductId(Long productId);
	
	
}
