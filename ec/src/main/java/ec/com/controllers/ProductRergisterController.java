package ec.com.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ec.com.models.AdminEntity;
import ec.com.services.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/product")
public class ProductRergisterController {
	@Autowired
	private ProductService productService;

	@Autowired
	private HttpSession session;

	@GetMapping("/register")
	public String getProductRegisterPage() {
		return "/admin/product-login.html";
	}

	@PostMapping("/register")
	public String register(@RequestParam String productName, @RequestParam Integer productPrice,
			@RequestParam MultipartFile productImg, @RequestParam String productDetail, Date registerDate,
			Model model) {
		AdminEntity admin = (AdminEntity) session.getAttribute("admin");
		if(admin == null) {
			return "redirect:/admin/login";
		}else {
			String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-").format(new Date(productPrice))
					+ productImg.getOriginalFilename();
			try {
				Files.copy(productImg.getInputStream(), Path.of("src/main/resources/static/product-img/" + fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (productService.productRegisterCheck(productName, productPrice, productDetail, fileName, registerDate, admin)) {
				return "redirect:/admin/product/register";
			} else {
				return "/admin/product-login.html";

			}	
		}
	

	}
}
