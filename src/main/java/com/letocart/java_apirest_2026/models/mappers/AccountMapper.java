package com.letocart.java_apirest_2026.models.mappers;

import com.letocart.java_apirest_2026.models.dao.AccountEntity;
import com.letocart.java_apirest_2026.models.dto.CreateAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    // TODO create DTO to DAO and DAO to DTO
    AccountEntity buildDaoFromDto(CreateAccount dto);
}
