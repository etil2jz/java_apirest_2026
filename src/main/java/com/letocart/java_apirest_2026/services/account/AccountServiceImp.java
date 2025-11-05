package com.letocart.java_apirest_2026.services.account;

import com.letocart.java_apirest_2026.configuration.exception.types.NotFoundException;
import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import com.letocart.java_apirest_2026.models.dto.GeocodingResponse;
import com.letocart.java_apirest_2026.repositories.AccountJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

	private final AccountJPARepository repository;

	private final RestClient restClient;

	public AccountEntity save(AccountEntity account) {
		if (account == null || account.getAddress() == null || account.getAddress().getAddress() == null) {
			throw new IllegalArgumentException("Account and address must not be null");
		}

		String addressToVerify = account.getAddress().getAddress();

		GeocodingResponse response = restClient.get().uri("/geocodage/search?q={address}&limit=1", addressToVerify).retrieve().body(GeocodingResponse.class);

		boolean isValid = false;
		if (response != null) {
			isValid = response.getFeatures().stream().findFirst().map(feature -> feature.getProperties().getScore()).filter(score -> score > 0.6).isPresent();
		}

		if (isValid) {
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
