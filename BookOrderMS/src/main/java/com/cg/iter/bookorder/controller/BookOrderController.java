package com.cg.iter.bookorder.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.bookorder.dto.BookOrderEntity;
import com.cg.iter.bookorder.exception.OrderAlreadyPresentException;
import com.cg.iter.bookorder.service.BookOrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Order")
@CrossOrigin(origins = "http://localhost:4200")
public class BookOrderController {
	private Logger logger = Logger.getLogger(BookOrderController.class);
	@Autowired
	BookOrderService orderService;

	@ApiOperation(value = " Get All Order", notes = "This api end point is to view all the orders", response = BookOrderEntity.class)

	@RequestMapping(value = "/viewAllOrder", method = RequestMethod.GET)
	public Iterable<BookOrderEntity> viewAllOrder() {
		return orderService.viewAllOrder();
	}

	@ApiOperation(value = " Get Order By Id", notes = "This api end point is to view the orders by id", response = BookOrderEntity.class)

	@RequestMapping(value = "/viewAllOrder/{orderId}", method = RequestMethod.GET)
	public Optional<BookOrderEntity> viewOrderById(@PathVariable("orderId") long orderId) {
		return orderService.viewOrderById(orderId);

	}

	@ApiOperation(value = " Add an order to BookOrder Database ", notes = "This api end point is to add the orders"
			+ "This api can be only accessed by the admin of the"
			+ "Book Order Management", response = BookOrderEntity.class)

	@ExceptionHandler(OrderAlreadyPresentException.class)
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public BookOrderEntity addOrder(@RequestBody BookOrderEntity order) {
		return orderService.addOrder(order);

	}

	@ApiOperation(value = " Delete an order From BookOrder Database ", notes = "This api end point is to delete the orders"
			+ "This api can be only accessed by the admin of the"
			+ "Book Order Management", response = BookOrderEntity.class)

	@RequestMapping(value = "/deleteOrder/{orderId}", method = RequestMethod.DELETE)
	public BookOrderEntity removeOrder(@PathVariable("orderId") long orderId) {
		return orderService.removeOrder(orderId);
	}

	@ApiOperation(value = " Modify an order in existing Orders ", notes = "This api end point is to edit the orders"
			+ "This api can be only accessed by the admin of the"
			+ "Book Order Management", response = BookOrderEntity.class)

	@ExceptionHandler(OrderAlreadyPresentException.class)
	@GetMapping("/updateOrderById/{id}")
	public Optional<BookOrderEntity> modifyOrder(@PathVariable("id") long orderId) {
		return orderService.modifyOrder(orderId);
	}

}
