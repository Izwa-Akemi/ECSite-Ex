package ec.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.com.models.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
	AdminEntity save(AdminEntity adminEntity);

	AdminEntity findByAdminName(String adminName);

	AdminEntity findByAdminNameAndAdminPassword(String adminName, String adminPassword);
}
