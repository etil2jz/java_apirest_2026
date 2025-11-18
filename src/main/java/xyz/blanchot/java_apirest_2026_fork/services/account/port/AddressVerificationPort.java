package xyz.blanchot.java_apirest_2026_fork.services.account.port;

import java.util.Optional;

public interface AddressVerificationPort {

	Optional<String> verifyAndFormatAddress(String address);

}
