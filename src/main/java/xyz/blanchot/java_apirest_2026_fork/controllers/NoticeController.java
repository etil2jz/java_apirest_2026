package xyz.blanchot.java_apirest_2026_fork.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.blanchot.java_apirest_2026_fork.models.dao.NoticeEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dto.CreateNotice;
import xyz.blanchot.java_apirest_2026_fork.services.notice.NoticeService;

import java.util.List;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

	private final NoticeService service;

	@PostMapping
	public NoticeEntity create(@RequestBody @Valid CreateNotice dto) {
		return service.create(dto.getAccountId(), dto.getProductId(), dto.getUserReview());
	}

	@GetMapping("/{noticeId}")
	public ResponseEntity<NoticeEntity> findById(@PathVariable Long noticeId) {
		return ResponseEntity.ok(service.findById(noticeId));
	}

	@GetMapping
	public List<NoticeEntity> findAll() {
		return service.findAll();
	}

}
