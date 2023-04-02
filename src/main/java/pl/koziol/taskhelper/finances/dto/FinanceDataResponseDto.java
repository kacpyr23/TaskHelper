package pl.koziol.taskhelper.finances.dto;

import lombok.Data;
import pl.koziol.taskhelper.finances.FinanceType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FinanceDataResponseDto {

	private Long id;
	private String title;
	private String description;
	private BigDecimal amount;
	private FinanceType type;
	private LocalDateTime created;
}
