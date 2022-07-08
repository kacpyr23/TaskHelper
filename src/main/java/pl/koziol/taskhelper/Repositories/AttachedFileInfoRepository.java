package pl.koziol.taskhelper.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.koziol.taskhelper.Models.AttachedFileInfo;

import java.util.Optional;

public interface AttachedFileInfoRepository extends JpaRepository<AttachedFileInfo, Long> {

    Optional<AttachedFileInfo> getAttachedFileInfoByAttachedFileInfoId(Long attachedFileInfoId);
}
