package pl.koziol.taskhelper.finances;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.koziol.taskhelper.finances.dto.FinanceDataRequestDto;
import pl.koziol.taskhelper.finances.dto.FinancesDataResponseDto;
import pl.koziol.taskhelper.finances.excelimporter.ExcelImporterService;

@RestController
@RequestMapping("/finance")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class FinanceController {
	
	private final FinanceService financeService;
	private final ExcelImporterService excelImporterService;
	
	@GetMapping("/all")
	public FinancesDataResponseDto getAllFinances() {
		return financeService.getAllFinances();
	}
	
	@PostMapping
	public void createFinance(@RequestBody FinanceDataRequestDto financeDataRequestDto) {
		financeService.createFinanceData(financeDataRequestDto);
	}
	
	@PostMapping("/import")
	public void importFinance(@RequestParam("file") MultipartFile multipartFile) {
		excelImporterService.importData(multipartFile);
	}
}
