package CRUD;

public class Employee {
	private String FirstName;
	private String LastName;
	private String Email;
	private String MobileNo;
	
	public Employee(String firstName, String lastName,
			String email, String mobileNo) {
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		MobileNo = mobileNo;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	
}
