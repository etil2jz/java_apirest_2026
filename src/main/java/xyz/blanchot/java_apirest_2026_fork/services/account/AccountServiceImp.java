package xyz.blanchot.java_apirest_2026_fork.services.account;

import xyz.blanchot.java_apirest_2026_fork.configuration.exception.types.NotFoundException;
import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dto.Feature;
import xyz.blanchot.java_apirest_2026_fork.models.dto.GeocodingResponse;
import xyz.blanchot.java_apirest_2026_fork.models.dto.Properties;
import xyz.blanchot.java_apirest_2026_fork.repositories.AccountJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import xyz.blanchot.java_apirest_2026_fork.services.account.port.AddressVerificationPort;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

	private final AccountJPARepository repository;

	private final AddressVerificationPort addressVerificationPort;

	private final PasswordEncoder passwordEncoder;

	public AccountEntity save(AccountEntity account) {
		if (account == null || account.getDescription() == null || account.getAddress() == null || account.getAddress().getAddress() == null) {
			throw new IllegalArgumentException("Account, description or address must not be null");
		}

		String addressToVerify = account.getAddress().getAddress();

		String validatedAddress = addressVerificationPort.verifyAndFormatAddress(addressToVerify)
				.orElseThrow(() -> new NotFoundException("Address '" + addressToVerify + "' not found or incorrect"));

		account.setPassword(passwordEncoder.encode(account.getPassword()));
		account.getAddress().setAddress(validatedAddress);

		return repository.save(account);
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
