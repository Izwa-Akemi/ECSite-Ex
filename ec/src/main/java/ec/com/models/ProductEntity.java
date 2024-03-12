package ec.com.models;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private Integer productPrice;
	private String productDetail;
	private String productImage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registerDate;
	private Integer deleteFlg;
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private AdminEntity admin; // 外部キーとの関連
	public ProductEntity(String productName, Integer productPrice, String productDetail, String productImage,
			Date registerDate, Integer deleteFlg, AdminEntity admin) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDetail = productDetail;
		this.productImage = productImage;
		this.registerDate = registerDate;
		this.deleteFlg = deleteFlg;
		this.admin = admin;
	}

}
