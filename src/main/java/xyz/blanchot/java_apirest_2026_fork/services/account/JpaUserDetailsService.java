package xyz.blanchot.java_apirest_2026_fork.services.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;
import xyz.blanchot.java_apirest_2026_fork.repositories.AccountJPARepository;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

	private final AccountJPARepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountEntity account = accountRepository.findByUsername(username)
				.orElseThrow(() ->
						new UsernameNotFoundException("User not found : " + username)
				);

		return new User(
				account.getUsername(),
				account.getPassword(),
				Collections.singletonList(() -> "ROLE_USER")
		);
	}

}
