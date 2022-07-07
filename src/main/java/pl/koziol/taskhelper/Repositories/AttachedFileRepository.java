package pl.koziol.taskhelper.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koziol.taskhelper.Models.AttachedFile;

public interface AttachedFileRepository extends JpaRepository<AttachedFile, Long> {
}
