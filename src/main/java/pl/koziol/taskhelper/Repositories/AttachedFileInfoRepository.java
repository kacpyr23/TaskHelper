package pl.koziol.taskhelper.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koziol.taskhelper.Models.AttachedFileInfo;

public interface AttachedFileInfoRepository extends JpaRepository<AttachedFileInfo, Long> {
}
