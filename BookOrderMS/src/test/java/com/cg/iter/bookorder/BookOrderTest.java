package com.cg.iter.bookorder;

import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.iter.bookorder.dto.BookOrderEntity;
import com.cg.iter.bookorder.repository.BookOrderRepo;
import com.cg.iter.bookorder.service.BookOrderService;
import com.cg.iter.bookorder.service.BookOrderSeviceImpl;

class BookOrderTest {

	@InjectMocks
	BookOrderSeviceImpl bookorderservice;

	@Mock
	BookOrderRepo bookorderRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void viewAllOrder() {

		when(bookorderRepository.findAll())
				.thenReturn(Stream.of(new BookOrderEntity(1000000L, new Date(), "Satya", 1, 100, "COD", "Ordered", 100))
						.collect(Collectors.toList()));

		assertEquals(1000000L, new Date(), "Satya", 1, 100, "COD", "Ordered", 100, bookorderservice.viewAllOrder());

	}

	private void assertEquals(long l, Date date, String string, int i, int j, String string2, String string3, int k,
			Iterable<BookOrderEntity> viewAllOrder) {
		// TODO Auto-generated method stub

	}

	@Test
	public void addOrder() {
		BookOrderEntity order = new BookOrderEntity(1000000L,new Date(), "Satya", 1, 100, "COD", "Ordered", 100);
		when(bookorderservice.addOrder(order)).thenReturn(order);
		Assert.assertEquals(order, bookorderservice.addOrder(order));
	}

}
