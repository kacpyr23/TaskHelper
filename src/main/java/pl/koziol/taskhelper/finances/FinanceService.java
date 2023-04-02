package pl.koziol.taskhelper.finances;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.koziol.taskhelper.finances.dto.FinanceDataRequestDto;
import pl.koziol.taskhelper.finances.dto.FinanceDataResponseDto;
import pl.koziol.taskhelper.finances.dto.FinancesDataResponseDto;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class FinanceService {
	
	private FinanceDataRepository financeDataRepository;
	private FinanceMapper financeMapper;
	
	public FinancesDataResponseDto getAllFinances() {
		List<FinanceDataResponseDto> financesResponse = financeDataRepository.findAll().stream()
			.map(finance -> financeMapper.mapToFinanceDataResponseDto(finance))
			.toList();
		return FinancesDataResponseDto.builder()
			.finances(financesResponse)
			.build();
	}
	
	public FinanceDataResponseDto getFinanceById(Long id) {
		FinanceDataEntity financeData = getFinanceDataEntity(id);
		return financeMapper.mapToFinanceDataResponseDto(financeData);
	}
	
	public void createFinanceData(FinanceDataRequestDto financeDataRequest) {
		FinanceDataEntity financeData = financeMapper.mapToFinanceDataEntity(financeDataRequest);
		financeData.setCreatedDate(LocalDateTime.now());
		financeDataRepository.save(financeData);
	}
	
	private FinanceDataEntity getFinanceDataEntity(Long id) {
		return financeDataRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Finance with id %s not found.".formatted(id)));
	}
}
