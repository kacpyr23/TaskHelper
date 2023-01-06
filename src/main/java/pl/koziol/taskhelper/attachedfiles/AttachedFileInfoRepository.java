package pl.koziol.taskhelper.attachedfiles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachedFileInfoRepository extends JpaRepository<AttachedFileInfoEntity, Long> {

    AttachedFileInfoEntity getAttachedFileInfoByAttachedFileInfoId(Long attachedFileInfoId);
}
