package ec.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.com.models.AdminEntity;
import ec.com.services.AdminService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/login")
    public String getAdminLoginPage(Model model) {
		model.addAttribute("error", false);
		return "/admin/login-admin.html";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String adminName,@RequestParam String password,Model model) {
		
		AdminEntity admin = adminService.adminLoginCheck(adminName, password);
		if(admin == null) {
			model.addAttribute("error", true);
			return "/admin/login-admin.html";
		}else {
			
			session.setAttribute("admin", admin);
			return "redirect:/admin/product/register";
		}
		
	}
	
	
}
