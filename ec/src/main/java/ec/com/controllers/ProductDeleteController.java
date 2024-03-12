package ec.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.com.models.AdminEntity;
import ec.com.services.ProductService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/product")
public class ProductDeleteController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping("/delete")
	public String delete(@RequestParam Long productId) {
		AdminEntity admin = (AdminEntity) session.getAttribute("admin");
		if(admin == null) {
			return "redirect:/admin/login";
		}else {
			if(productService.productDeleteCheck(productId, admin)) {
				return "redirect:/admin/product-list/view"; 
			}else {
				return "redirect:/admin/product/edit"+productId;
			}
			
		}
	}
	
}
