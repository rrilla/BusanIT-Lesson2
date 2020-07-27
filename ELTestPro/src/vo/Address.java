package vo;

public class Address {
	private String zipcode;
	private String addr;
	
	public Address() {}
	
	public Address(String zipcode, String addr) {
		super();
		this.zipcode = zipcode;
		this.addr = addr;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", addr=" + addr + "]";
	}
	
}
