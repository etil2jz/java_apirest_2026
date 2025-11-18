package xyz.blanchot.java_apirest_2026_fork.models.mappers;

import org.mapstruct.Mapper;
import xyz.blanchot.java_apirest_2026_fork.models.dao.ProductEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dto.CreateProduct;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductEntity toEntity(CreateProduct dto);

}
