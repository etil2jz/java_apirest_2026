package xyz.blanchot.java_apirest_2026_fork.models.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;

	private String username;

	private String password;

	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	@JsonManagedReference
	private AddressEntity address;

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<OrdersEntity> orders;

}
