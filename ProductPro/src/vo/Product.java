package vo;

public class Product {
	private int code;
	private String name;
	private int price;
	private String pictureurl;
	private String description;
	
	public Product() {}
	
	public Product(String name, int price, String pictureurl, String description) {
		super();
		this.name = name;
		this.price = price;
		this.pictureurl = pictureurl;
		this.description = description;
	}

	public Product(int code, String name, int price, String pictureurl, String description) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.pictureurl = pictureurl;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", pictureurl=" + pictureurl
				+ ", description=" + description + "]";
	}
	
}
