package ec.com.models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="admin")
public class AdminEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long adminId;

	private String adminName;
	private String adminEmail;
	private String adminPassword;
	private Integer deleteFlg;
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
	private List<ProductEntity> products; // 一対多の関連
	public AdminEntity(String adminName, String adminEmail, String adminPassword, Integer deleteFlg) {
		super();
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.deleteFlg = deleteFlg;
	}
	





}
