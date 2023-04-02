package pl.koziol.taskhelper.finances.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FinancesDataResponseDto {

	private List<FinanceDataResponseDto> finances;
}
