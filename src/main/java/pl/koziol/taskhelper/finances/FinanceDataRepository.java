package pl.koziol.taskhelper.finances;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceDataRepository extends JpaRepository<FinanceDataEntity, Long> {
}
