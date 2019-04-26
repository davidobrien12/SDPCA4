package davidobrien.sdpca.orders;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import davidobrien.sdpca.item.Item;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	private double Fullprice;

	@ManyToMany(targetEntity = Item.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Item> products = new HashSet<Item>();

	public Orders() {

	}
	public Orders(double Fullprice) {
		this.Fullprice = Fullprice;
	}

	public Orders(int productId, double fullprice) {
		this.productId = productId;
		this.Fullprice = fullprice;

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getFullprice() {
		return Fullprice;
	}

	public void setFullprice(double fullprice) {
		Fullprice = fullprice;
	}

	public Set<Item> getProducts() {
		return products;
	}

	public void setProducts(Set<Item> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ItemOrders [productId=" + productId + ", FullPrice=" + Fullprice + ", products=" + products + "]";
	}

}
