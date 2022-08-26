package io.github.barbosavinicius.controllers;

import io.github.barbosavinicius.data.vo.v1.BookVO;
import io.github.barbosavinicius.services.BookServices;
import io.github.barbosavinicius.util.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Books", description = "Endpoints for Managing Books")
public class BookController {

	@Autowired
	private BookServices service;

	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds all Books", description = "Finds all Books", tags = {"Books"}, responses = {
			@ApiResponse(description = "Success", responseCode = "200",
						 content = {@Content(array = @ArraySchema(schema = @Schema(implementation = BookVO.class)))}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),})
	public List<BookVO> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}",
				produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Finds one Book", description = "Finds one Book", tags = {"Books"}, responses = {
			@ApiResponse(description = "Success", responseCode = "200",
						 content = @Content(schema = @Schema(implementation = BookVO.class))),
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),})
	public BookVO findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
				 consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Adds a new Book",
			   description = "Adds a new Book by passing in a JSON, XML or YML representation of the person!",
			   tags = {"Books"}, responses = {@ApiResponse(description = "Success", responseCode = "200",
														   content = @Content(
																   schema = @Schema(implementation = BookVO.class))),
											  @ApiResponse(description = "Bad Request", responseCode = "400",
														   content = @Content),
											  @ApiResponse(description = "Unauthorized", responseCode = "401",
														   content = @Content),
											  @ApiResponse(description = "Not Found", responseCode = "404",
														   content = @Content),
											  @ApiResponse(description = "Internal Error", responseCode = "500",
														   content = @Content),})
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}

	@PutMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
				consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Updates a new Book",
			   description = "Updates a new Book by passing in a JSON, XML or YML representation of the person!",
			   tags = {"Books"}, responses = {@ApiResponse(description = "Success", responseCode = "200",
														   content = @Content(
																   schema = @Schema(implementation = BookVO.class))),
											  @ApiResponse(description = "Bad Request", responseCode = "400",
														   content = @Content),
											  @ApiResponse(description = "Unauthorized", responseCode = "401",
														   content = @Content),
											  @ApiResponse(description = "Not Found", responseCode = "404",
														   content = @Content),
											  @ApiResponse(description = "Internal Error", responseCode = "500",
														   content = @Content),})
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Deletes a Book", description = "Deletes a Book", tags = {"Books"},
			   responses = {@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
							@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
							@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
							@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
							@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),})
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
