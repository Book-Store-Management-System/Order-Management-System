package com.cg.iter.bookorder.service;

import java.util.Optional;


import com.cg.iter.bookorder.dto.BookOrderEntity;

public interface BookOrderService {

	public Iterable<BookOrderEntity> viewAllOrder();

	public Optional<BookOrderEntity> viewOrderById(long orderId);

	public BookOrderEntity addOrder(BookOrderEntity order);

	Optional<BookOrderEntity> modifyOrder(long orderId);

	BookOrderEntity removeOrder(long orderId);

}
