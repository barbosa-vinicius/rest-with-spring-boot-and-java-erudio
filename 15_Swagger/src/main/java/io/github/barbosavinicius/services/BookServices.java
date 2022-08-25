package io.github.barbosavinicius.services;

import io.github.barbosavinicius.data.vo.v1.BookVO;
import io.github.barbosavinicius.exceptions.RequiredObjectIsNullException;
import io.github.barbosavinicius.exceptions.ResourceNotFoundException;
import io.github.barbosavinicius.mapper.DozerMapper;
import io.github.barbosavinicius.model.Book;
import io.github.barbosavinicius.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	private BookRepository repository;

	public List<BookVO> findAll() {
		logger.info("Finding all books!");

		var books = DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
		return books;
	}

	public BookVO findById(Long id) {
		logger.info("Finding one book!");

		var book = repository.findById(id)
							 .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		var vo = DozerMapper.parseObject(book, BookVO.class);

		return vo;
	}

	public BookVO create(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();

		logger.info("Creating one new book!");

		var entity = DozerMapper.parseObject(book, Book.class);
		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);

		return vo;
	}

	public BookVO update(BookVO book) {

		if (book == null) throw new RequiredObjectIsNullException();

		logger.info("Updating one book!");

		var entity = repository.findById(book.getKey())
							   .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());

		var vo = DozerMapper.parseObject(repository.save(entity), BookVO.class);

		return vo;
	}

	public void delete(Long id) {
		logger.info("Deleting one book!");


		var entity = repository.findById(id)
							   .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		repository.delete(entity);
	}

}
