package com.letocart.java_apirest_2026.models.mappers;

import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import com.letocart.java_apirest_2026.models.dto.CreateAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

	@Mapping(source = "address", target = "address.address")
	@Mapping(source = "password", target = "password")
	AccountEntity buildDaoFromDto(CreateAccount dto);

}
