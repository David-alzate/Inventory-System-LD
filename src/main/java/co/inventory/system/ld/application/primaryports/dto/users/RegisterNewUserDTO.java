package co.inventory.system.ld.application.primaryports.dto.users;

import co.inventory.system.ld.application.primaryports.dto.commons.GetIdTypeDTO;
import co.inventory.system.ld.application.primaryports.dto.commons.GetStatusDTO;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.helpers.TextHelper;

public class RegisterNewUserDTO {

	private String name;
	private String lastName;
	private GetIdTypeDTO idType;
	private Long idNumber;
	private String email;
	private UserTypeDTO userType;
	private GetStatusDTO status;
	private String password;

	public RegisterNewUserDTO() {
		setName(TextHelper.EMPTY);
		setLastName(TextHelper.EMPTY);
		setIdType(GetIdTypeDTO.create());
		setIdNumber(0L);
		setEmail(TextHelper.EMPTY);
		setUserType(UserTypeDTO.create());
		setStatus(GetStatusDTO.create());
		setPassword(TextHelper.EMPTY);
	}

	public RegisterNewUserDTO(String name, String lastName, GetIdTypeDTO idType, Long idNumber, String email,
			UserTypeDTO userType, GetStatusDTO status, String password) {
		setName(name);
		setLastName(lastName);
		setIdType(idType);
		setIdNumber(idNumber);
		setEmail(email);
		setUserType(userType);
		setStatus(status);
		setPassword(password);
	}

	public static RegisterNewUserDTO create(String name, String lastName, GetIdTypeDTO idType, Long idNumber,
			String email, UserTypeDTO userType, GetStatusDTO status, String password) {
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

	public GetIdTypeDTO getIdType() {
		return idType;
	}

	public void setIdType(GetIdTypeDTO idType) {
		this.idType = ObjectHelper.getDefault(idType, GetIdTypeDTO.create());
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

	public GetStatusDTO getStatus() {
		return status;
	}

	public void setStatus(GetStatusDTO status) {
		this.status = ObjectHelper.getDefault(status, GetStatusDTO.create());
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = TextHelper.applyTrim(password);
	}

}
