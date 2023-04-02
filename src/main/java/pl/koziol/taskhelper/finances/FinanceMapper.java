package pl.koziol.taskhelper.finances;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.koziol.taskhelper.finances.dto.FinanceDataRequestDto;
import pl.koziol.taskhelper.finances.dto.FinanceDataResponseDto;


@Mapper(componentModel = "spring")
public interface FinanceMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdDate", ignore = true)
	FinanceDataEntity mapToFinanceDataEntity(FinanceDataRequestDto requestDto);
	
	@Mapping(target = "created", source = "createdDate")
	FinanceDataResponseDto mapToFinanceDataResponseDto(FinanceDataEntity financeDataEntity);
	
}
