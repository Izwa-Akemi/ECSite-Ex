package ec.com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.models.AdminEntity;
import ec.com.repositories.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepo;

	//管理者登録処理
	public boolean createAdminAccount(String adminName, String adminEmail, String adminPassword) {
		//もし同じ管理者が存在しなかった場合
		if (adminRepo.findByAdminName(adminName) == null) {
			adminRepo.save(new AdminEntity(adminName, adminEmail, adminPassword,0));
			return true;
		} else {
			return false;
		}
	}

	//管理者ログイン処理
    public AdminEntity adminLoginCheck(String adminName,String adminPassword) {
    	AdminEntity admin = adminRepo.findByAdminNameAndAdminPassword(adminName, adminPassword);
    	if(admin == null) {
    		return null;
    	}else {
    		return admin;
    	}
    }

}
