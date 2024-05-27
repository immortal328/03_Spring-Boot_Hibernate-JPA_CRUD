package ap.immortal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {
	@Id
	@Column(name="house_number")
	private String houseNumber;
	
	@Column(name="road")
	private String road;
	
	@Column(name="pin_code")
	private Integer pinCode;
}
