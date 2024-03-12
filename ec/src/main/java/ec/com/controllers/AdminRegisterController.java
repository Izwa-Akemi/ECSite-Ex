package ec.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.com.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminRegisterController {
	@Autowired
	private AdminService adminService;

	@GetMapping("/register")
	public String getAdminRegisterPage(Model model) {
		model.addAttribute("error", false);
		return "/admin/register-admin.html";
	}

	@PostMapping("/register")
	public String register(@RequestParam String email, @RequestParam String adminName, @RequestParam String password,Model model) {

		if (adminService.createAdminAccount(adminName, email, password)) {
			return "redirect:/admin/login";
		} else {
			// そうでない場合には、register.htmlに遷移する
			model.addAttribute("error", true);
			return "/admin/register-admin.html";

		}

	}
}
