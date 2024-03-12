package ec.com.services;



import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import ec.com.models.AdminEntity;
import ec.com.models.ProductEntity;
import ec.com.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepo;
	public boolean productRegisterCheck(String productName,Integer productPrice,String productDetail,String productImage,@DateTimeFormat(pattern = "yyyy-MM-dd") Date registerDate,AdminEntity admin) {
		if(productRepo.findByProductName(productName) == null) {
			productRepo.save(new ProductEntity(productName,productPrice,productDetail,productImage,registerDate,0,admin));
		    return true;
		}else {
			return false;
		}
	}
	
	public ProductEntity editPageCheck(Long adminId,Long productId) {
		if(adminId == null || productId == null) {
			return null;
		}else {
			return productRepo.findByProductId(productId);
		}
		
	}
	public boolean productUpdateCheck(Long productId,String productName,Integer productPrice,String productDetail,String productImage,@DateTimeFormat(pattern = "yyyy-MM-dd") Date registerDate,AdminEntity admin) {
		ProductEntity productEntity  = productRepo.findByProductId(productId);
		if(productEntity == null || admin.getAdminId() == null) {
			return false;
		}else {
			productEntity.setProductName(productName);
			productEntity.setProductPrice(productPrice);
			productEntity.setProductDetail(productDetail);
			productEntity.setProductImage(productImage);
			productEntity.setRegisterDate(registerDate);
		    return true;
			
		}
	}
	public boolean productDeleteCheck(Long productId,AdminEntity admin) {
		ProductEntity productEntity  = productRepo.findByProductId(productId);
		if(productEntity == null || admin.getAdminId() == null) {
			return false;
		}else {
			productEntity.setDeleteFlg(1);
			productRepo.save(productEntity);
		    return true;
			
		}
	}
}
