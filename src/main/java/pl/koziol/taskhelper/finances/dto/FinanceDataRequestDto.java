package pl.koziol.taskhelper.finances.dto;

import lombok.Data;
import pl.koziol.taskhelper.finances.FinanceType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class FinanceDataRequestDto {
	
	@NotBlank
	private String title;
	
	private String description;
	
	@NotNull
	private BigDecimal amount;
	
	@NotNull
	private FinanceType type;
}
