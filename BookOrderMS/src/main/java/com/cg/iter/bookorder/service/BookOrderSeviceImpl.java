package com.cg.iter.bookorder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.bookorder.dto.BookOrderEntity;
import com.cg.iter.bookorder.exception.OrderAlreadyPresentException;
import com.cg.iter.bookorder.repository.BookOrderRepo;

@Service
public class BookOrderSeviceImpl implements BookOrderService {

	@Autowired
	BookOrderRepo OrderRepo;

	@Override
	public Iterable<BookOrderEntity> viewAllOrder() {
		return OrderRepo.findAll();
	}

	@Override
	public Optional<BookOrderEntity> viewOrderById(long orderId) {
		return OrderRepo.findById(orderId);
	}

	@Override
	public BookOrderEntity addOrder(BookOrderEntity order) {

		if(order.getOrderId()==null) {
			order.setTotalAmount(order.getOrderbookcopies() * order.getBookRate());
			order.setPaymentMethod("COD");
		}
		return OrderRepo.save(order);
	}

	@Override
	public Optional<BookOrderEntity> modifyOrder(long orderId) {
		if (!OrderRepo.existsById(orderId)) {
			throw new OrderAlreadyPresentException(
					"Order with orderCode: " + orderId + " is already there!!!!");
		}
//		BookDTO Book = bookRepository.findById(bookId).get();
		return OrderRepo.findById(orderId);
	}
		
//		order.setTotalAmount(order.getOrderbookcopies() * order.getBookRate());
//		order.setPaymentMethod("COD");
//		OrderRepo.save(order);
//		return order;

	

	@Override
	public BookOrderEntity removeOrder(long orderId) {

		BookOrderEntity order=OrderRepo.findById(orderId).get();
		OrderRepo.delete(order);
		return order;
	
	}
}
