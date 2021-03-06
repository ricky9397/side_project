package cart;

public class CartDto {
	private int iCode;
	private String iName;
	private int iPrice;
	private int count;
	private String photo;
	
	public CartDto() {
	}
	public CartDto(int iCode, String iName, int iPrice, int count, String photo) {
		this.iCode = iCode;
		this.iName = iName;
		this.iPrice = iPrice;
		this.count = count;
		this.photo = photo;
	}
	public int getiCode() {
		return iCode;
	}
	public void setiCode(int iCode) {
		this.iCode = iCode;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public int getiPrice() {
		return iPrice;
	}
	public void setiPrice(int iPrice) {
		this.iPrice = iPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	// 가격 함수
	public int getSumPrice() {
		return this.iPrice * this.count;
	}
	@Override
	public String toString() {
		return "data [iCode=" + iCode + ", iName=" + iName + ", iPrice=" + iPrice + ", count=" + count + "]";
	}
}
