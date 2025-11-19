package xyz.blanchot.java_apirest_2026_fork.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dto.CreateAccount;

@Mapper(componentModel = "spring")
public interface AccountMapper {

	@Mapping(source = "address", target = "address.address")
	@Mapping(source = "password", target = "password")
	AccountEntity buildDaoFromDto(CreateAccount dto);

}
