package Model;

public class Product {
	private int id;
	private String name;
	private String description;
	private float price;
	private String type;
	private String brand;
	private int number;
	private String sourceImg;
	public Product(int id, String name, String description, float price, String type, String brand, String sourceImg) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.brand = brand;
		this.sourceImg = sourceImg;
	}
	public Product() {
		super();
	}
	public Product(int id, String name, String description, float price, String type, String brand, int number) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.brand = brand;
		this.number = number;
	}
	public Product(int id, String name, String description, float price, String type, String brand, int number,
			String sourceImg) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.type = type;
		this.brand = brand;
		this.number = number;
		this.sourceImg = sourceImg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSourceImg() {
		return sourceImg;
	}
	public void setSourceImg(String sourceImg) {
		this.sourceImg = sourceImg;
	}
}
