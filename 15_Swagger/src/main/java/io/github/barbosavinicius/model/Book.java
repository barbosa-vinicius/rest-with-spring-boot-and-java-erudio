package io.github.barbosavinicius.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 80)
	private String author;

	@Column(name = "launch_date", nullable = false)
	private Date launchDate;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(length = 150)
	private String title;

	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(Date launchDate) {
		this.launchDate = launchDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return getId().equals(book.getId()) && Objects.equals(getAuthor(), book.getAuthor()) &&
			   getLaunchDate().equals(book.getLaunchDate()) && getPrice().equals(book.getPrice()) &&
			   Objects.equals(getTitle(), book.getTitle());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getAuthor(), getLaunchDate(), getPrice(), getTitle());
	}
}
