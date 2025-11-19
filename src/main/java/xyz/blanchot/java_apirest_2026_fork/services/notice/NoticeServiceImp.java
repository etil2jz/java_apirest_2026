package xyz.blanchot.java_apirest_2026_fork.services.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.blanchot.java_apirest_2026_fork.configuration.exception.types.BadRequestException;
import xyz.blanchot.java_apirest_2026_fork.configuration.exception.types.NotFoundException;
import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dao.NoticeEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dao.OrdersEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dao.ProductEntity;
import xyz.blanchot.java_apirest_2026_fork.repositories.NoticeJPARepository;
import xyz.blanchot.java_apirest_2026_fork.services.account.AccountService;
import xyz.blanchot.java_apirest_2026_fork.services.product.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImp implements NoticeService {

	private final NoticeJPARepository noticeRepository;

	private final AccountService accountService;

	private final ProductService productService;

	@Override
	@Transactional
	public NoticeEntity create(Long accountId, Long productId, String review) {
		// Récupérer le compte et le produit
		AccountEntity account = accountService.findById(accountId);
		ProductEntity product = productService.findById(productId);

		// Vérifications
		OrdersEntity associatedOrder = account.getOrders().stream()
				.filter(order -> order.getOrdersDetails().stream()
						.anyMatch(detail -> detail.getProduct().getProductId().equals(productId)))
				.findFirst()
				.orElseThrow(() -> new BadRequestException("You must buy this product before leaving a review"));

		NoticeEntity notice = new NoticeEntity();
		notice.setAccount(account);
		notice.setProduct(product);
		notice.setOrders(associatedOrder);
		notice.setUserReview(review);

		return noticeRepository.save(notice);
	}

	@Override
	public NoticeEntity findById(Long id) {
		return noticeRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Notice id " + id + " not found"));
	}

	@Override
	public List<NoticeEntity> findAll() {
		List<NoticeEntity> notices = noticeRepository.findAll();
		if (notices.isEmpty()) {
			throw new NotFoundException("No notices found");
		}
		return notices;
	}

}
