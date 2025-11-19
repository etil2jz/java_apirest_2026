package xyz.blanchot.java_apirest_2026_fork.services.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.blanchot.java_apirest_2026_fork.configuration.exception.types.NotFoundException;
import xyz.blanchot.java_apirest_2026_fork.models.dao.AccountEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dao.OrdersDetailsEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dao.OrdersDetailsId;
import xyz.blanchot.java_apirest_2026_fork.models.dao.OrdersEntity;
import xyz.blanchot.java_apirest_2026_fork.models.dao.ProductEntity;
import xyz.blanchot.java_apirest_2026_fork.repositories.OrdersDetailsJPARepository;
import xyz.blanchot.java_apirest_2026_fork.repositories.OrdersJPARepository;
import xyz.blanchot.java_apirest_2026_fork.services.account.AccountService;
import xyz.blanchot.java_apirest_2026_fork.services.product.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImp {

	private final OrdersJPARepository ordersRepository;

	private final OrdersDetailsJPARepository ordersDetailsRepository;

	private final AccountService accountService;

	private final ProductService productService;

	@Transactional
	public OrdersEntity createOrder(Long accountId, List<Long> productIds) {
		// Récupérer l'utilisateur
		AccountEntity account = accountService.findById(accountId);

		// Créer la commande
		OrdersEntity order = new OrdersEntity();
		order.setAccount(account);
		order = ordersRepository.save(order); // save pour avoir l'ID

		// Ajouter les produits (Details)
		List<OrdersDetailsEntity> detailsList = new ArrayList<>();
		for (Long productId : productIds) {
			ProductEntity product = productService.findById(productId);

			OrdersDetailsId detailsId = new OrdersDetailsId();
			detailsId.setOrdersId(order.getOrdersId());
			detailsId.setProductId(product.getProductId());

			OrdersDetailsEntity details = new OrdersDetailsEntity();
			details.setOrdersDetailsId(detailsId);
			details.setOrders(order);
			details.setProduct(product);

			ordersDetailsRepository.save(details);

			detailsList.add(details);
		}

		order.setOrdersDetails(detailsList);

		return order;
	}

	// Retourner toutes les commandes
	public List<OrdersEntity> findAll() {
		List<OrdersEntity> orders = ordersRepository.findAll();
		if (orders.isEmpty()) {
			throw new NotFoundException("No orders found");
		}
		return orders;
	}

	// Retourner la commande correspondante
	public OrdersEntity findById(Long id) {
		return ordersRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Order id " + id + " not found"));
	}

}
