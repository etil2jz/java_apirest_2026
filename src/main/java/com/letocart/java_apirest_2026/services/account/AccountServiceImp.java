package com.letocart.java_apirest_2026.services.account;

import com.letocart.java_apirest_2026.configuration.exception.types.NotFoundException;
import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import com.letocart.java_apirest_2026.models.dto.Feature;
import com.letocart.java_apirest_2026.models.dto.GeocodingResponse;
import com.letocart.java_apirest_2026.models.dto.Properties;
import com.letocart.java_apirest_2026.repositories.AccountJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

	private final AccountJPARepository repository;

	private final RestClient restClient;

	private final PasswordEncoder passwordEncoder;

	public AccountEntity save(AccountEntity account) {
		if (account == null || account.getDescription() == null || account.getAddress() == null || account.getAddress().getAddress() == null) {
			throw new IllegalArgumentException("Account, description or address must not be null");
		}

		String addressToVerify = account.getAddress().getAddress();

		GeocodingResponse response = restClient.get().uri("/geocodage/search?q={address}", addressToVerify).retrieve().body(GeocodingResponse.class);

		Optional<Properties> validAddressProperties = Optional.empty();
		if (response != null) {
			validAddressProperties = response.getFeatures().stream()
					.map(Feature::getProperties)
					.filter(properties -> properties.getScore() > 0.8)
					.findFirst();
		}

		if (validAddressProperties.isPresent()) {
			account.setPassword(passwordEncoder.encode(account.getPassword()));
			account.getAddress().setAddress(validAddressProperties.get().getLabel());
			return repository.save(account);
		} else {
			throw new NotFoundException("Address '" + addressToVerify + "' not found or incorrect");
		}
	}

	public AccountEntity findById(Long id) {
		Optional<AccountEntity> account = repository.findById(id);
		if (account.isEmpty()) {
			throw new NotFoundException("Account not found");
		}
		return account.get();
	}

	public List<AccountEntity> findAll() {
		List<AccountEntity> accounts = repository.findAll();
		if (accounts.isEmpty()) {
			throw new NotFoundException("No account found");
		}
		return accounts;
	}

}
