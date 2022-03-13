package Model;

public class Account {
	private String user, passwordUser;
	private int role;
	private String name, addres, phone;
	private int check;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account(String user, String passwordUser, int role, String name, String addres, String phone) {
		super();
		this.user = user;
		this.passwordUser = passwordUser;
		this.role = role;
		this.name = name;
		this.addres = addres;
		this.phone = phone;
	}

	public Account(String user, String passwordUser, int role, String name, String addres, String phone, int check) {
		this.user = user;
		this.passwordUser = passwordUser;
		this.role = role;
		this.name = name;
		this.addres = addres;
		this.phone = phone;
		this.check = check;
	}

	public Account() {
		super();
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
}
