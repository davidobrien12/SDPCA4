package davidobrien.sdpca.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodID;
	private String title;
	private String manufacturer;
	private String category;
	private String photo;
	private double price;
	private int amount;
	private boolean state;

	public Item() {

	}

	public Item(String title, String manufacturer, String category, String photo, double price, int amount, boolean state) {
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.photo = photo;
		this.amount = amount;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getphoto() {
		return photo;
	}

	public void setphoto(String photo) {
		this.photo = photo;
	}

	public int getamount() {
		return amount;
	}

	public void setamount(int amount) {
		this.amount = amount;
	}
	

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Item [prodID=" + prodID + ", title=" + title + ", manufacturer=" + manufacturer + ", category="
				+ category + ", photo=" + photo + ", price=" + price + ", amount=" + amount + ", state=" + state + "]";
	}

	

}
