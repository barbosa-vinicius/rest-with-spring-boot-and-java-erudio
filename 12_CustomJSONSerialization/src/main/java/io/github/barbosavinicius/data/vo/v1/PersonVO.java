package io.github.barbosavinicius.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
//permite modificar a ordem dos atributos retornados
public class PersonVO implements Serializable {

	public static final long serialVersionUID = 1L;

	private Long id;
	@JsonProperty("first_name") //Permite modificar o nome do atributo que será retornado
	private String firstName;
	@JsonProperty("last_name") //Permite modificar o nome do atributo que será retornado
	private String lastName;
	private String address;
	@JsonIgnore //ignora o campo e será omitido na serialização do JSON
	private String gender;

	public PersonVO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PersonVO person = (PersonVO) o;
		return id == person.id && Objects.equals(getFirstName(), person.getFirstName()) &&
			   Objects.equals(getLastName(), person.getLastName()) &&
			   Objects.equals(getAddress(), person.getAddress()) && Objects.equals(getGender(), person.getGender());
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, getFirstName(), getLastName(), getAddress(), getGender());
	}

}
