package xyz.blanchot.java_apirest_2026_fork.services.notice;

import xyz.blanchot.java_apirest_2026_fork.models.dao.NoticeEntity;

import java.util.List;

public interface NoticeService {

	NoticeEntity create(Long accountId, Long productId, String review);

	NoticeEntity findById(Long id);

	List<NoticeEntity> findAll();

}
