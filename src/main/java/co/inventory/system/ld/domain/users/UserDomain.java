package co.inventory.system.ld.domain.users;

import java.util.UUID;

import co.inventory.system.ld.domain.Domain;
import co.inventory.system.ld.domain.commons.IdTypeDomain;
import co.inventory.system.ld.domain.commons.StatusDomain;

public class UserDomain extends Domain {

	private String name;
	private String lastName;
	private IdTypeDomain idType;
	private Long idNumber;
	private String email;
	private UserTypeDomain userType;
	private StatusDomain status;
	private String password;

	public UserDomain(UUID id, String name, String lastName, IdTypeDomain idType, Long idNumber, String email,
			UserTypeDomain userType, StatusDomain status, String password) {
		super(id);
		setName(name);
		setLastName(lastName);
		setIdType(idType);
		setIdNumber(idNumber);
		setEmail(email);
		setUserType(userType);
		setStatus(status);
		setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public IdTypeDomain getIdType() {
		return idType;
	}

	public void setIdType(IdTypeDomain idType) {
		this.idType = idType;
	}

	public Long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserTypeDomain getUserType() {
		return userType;
	}

	public void setUserType(UserTypeDomain userType) {
		this.userType = userType;
	}

	public StatusDomain getStatus() {
		return status;
	}

	public void setStatus(StatusDomain status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
