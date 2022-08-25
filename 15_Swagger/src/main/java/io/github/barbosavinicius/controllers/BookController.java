package io.github.barbosavinicius.controllers;

import io.github.barbosavinicius.data.vo.v1.BookVO;
import io.github.barbosavinicius.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

	@Autowired
	private BookServices service;

	@GetMapping
	public List<BookVO> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public BookVO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}

	@PutMapping
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
