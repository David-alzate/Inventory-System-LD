package co.inventory.system.ld.application.primaryports.dto.users;

import co.inventory.system.ld.application.primaryports.dto.commons.IdTypeDTO;
import co.inventory.system.ld.application.primaryports.dto.commons.StatusDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class RegisterNewUserDTO {

	private String name;
	private String lastName;
	private IdTypeDTO idType;
	private Long idNumber;
	private String email;
	private UserTypeDTO userType;
	private StatusDTO status;
	private String password;

	public RegisterNewUserDTO() {
		setName(TextHelper.EMPTY);
		setLastName(TextHelper.EMPTY);
		setIdType(IdTypeDTO.create());
		setIdNumber(0L);
		setEmail(TextHelper.EMPTY);
		setUserType(UserTypeDTO.create());
		setStatus(StatusDTO.create());
		setPassword(TextHelper.EMPTY);
	}

	public RegisterNewUserDTO(String name, String lastName, IdTypeDTO idType, Long idNumber, String email,
							  UserTypeDTO userType, StatusDTO status, String password) {
		setName(name);
		setLastName(lastName);
		setIdType(idType);
		setIdNumber(idNumber);
		setEmail(email);
		setUserType(userType);
		setStatus(status);
		setPassword(password);
	}

	public static RegisterNewUserDTO create(String name, String lastName, IdTypeDTO idType, Long idNumber,
											String email, UserTypeDTO userType, StatusDTO status, String password) {
		return new RegisterNewUserDTO(name, lastName, idType, idNumber, email, userType, status, password);
	}

	public static RegisterNewUserDTO create() {
		return new RegisterNewUserDTO();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = TextHelper.applyTrim(lastName);
	}

	public IdTypeDTO getIdType() {
		return idType;
	}

	public void setIdType(IdTypeDTO idType) {
		this.idType = ObjectHelper.getDefault(idType, IdTypeDTO.create());
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
		this.email = TextHelper.applyTrim(email);
	}

	public UserTypeDTO getUserType() {
		return userType;
	}

	public void setUserType(UserTypeDTO userType) {
		this.userType = ObjectHelper.getDefault(userType, UserTypeDTO.create());
	}

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = ObjectHelper.getDefault(status, StatusDTO.create());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = TextHelper.applyTrim(password);
	}

}
