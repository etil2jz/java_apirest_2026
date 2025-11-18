package xyz.blanchot.java_apirest_2026_fork.infrastructure.external;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import xyz.blanchot.java_apirest_2026_fork.models.dto.Feature;
import xyz.blanchot.java_apirest_2026_fork.models.dto.GeocodingResponse;
import xyz.blanchot.java_apirest_2026_fork.models.dto.Properties;
import xyz.blanchot.java_apirest_2026_fork.services.account.port.AddressVerificationPort;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IgnAddressAdapter implements AddressVerificationPort {

	private final RestClient restClient;

	@Override
	public Optional<String> verifyAndFormatAddress(String addressToVerify) {
		// Appel API
		GeocodingResponse response = restClient.get()
				.uri("/geocodage/search?q={address}", addressToVerify)
				.retrieve()
				.body(GeocodingResponse.class);

		if (response == null || response.getFeatures() == null) {
			return Optional.empty();
		}

		// Filtrer la réponse avec un Stream
		return response.getFeatures().stream()
				.map(Feature::getProperties)
				.filter(properties -> properties.getScore() > 0.8)
				.map(Properties::getLabel)
				.findFirst();
	}

}
