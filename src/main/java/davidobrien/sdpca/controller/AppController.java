package davidobrien.sdpca.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import davidobrien.sdpca.card.AbstractValidator;
import davidobrien.sdpca.card.Visa;
import davidobrien.sdpca.card.MasterCard;
import davidobrien.sdpca.card.AmericanExpress;
import davidobrien.sdpca.item.Item;
import davidobrien.sdpca.item.ItemService;
import davidobrien.sdpca.orders.Orders;
import davidobrien.sdpca.orders.OrdersService;
import davidobrien.sdpca.stock.InStock;
import davidobrien.sdpca.stock.OutOfStock;
import davidobrien.sdpca.stock.State;
import davidobrien.sdpca.user.User;
import davidobrien.sdpca.user.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private OrdersService orderService;

	private ArrayList<Item> shoppingCart = new ArrayList<Item>();

	/*
	 * @PostMapping("/cardPurchase") public String
	 * cardPurchase(@SessionAttribute("user") User u, HttpServletRequest request,
	 * HttpSession session) {
	 * 
	 * String cardName = request.getParameter("cardName"); String LongCardNum =
	 * request.getParameter("LongCardNum"); int expiryDateMonth =
	 * Integer.parseInt(request.getParameter("expiryDateMonth")); int expiryDateYear
	 * = Integer.parseInt(request.getParameter("expiryDateYear")); String cvv =
	 * request.getParameter("cvv"); boolean Cardresult = false; AbstractValidator
	 * validator = null;
	 * 
	 * String cardType = request.getParameter("cardType"); if
	 * (cardType.equals("Visa Card")) { validator = new Visa(AppController.this,
	 * cardName, LongCardNum, expiryDateMonth, expiryDateYear, cvv);
	 * 
	 * } else if (cardType.equals("MasterCard")) { validator = new
	 * MasterCard(AppController.this, cardName, LongCardNum, expiryDateMonth,
	 * expiryDateYear, cvv);
	 * 
	 * } else if (cardType.equals("American Express")) { validator = new
	 * AmericanExpress(AppController.this, cardName, LongCardNum, expiryDateMonth,
	 * expiryDateYear, cvv);
	 * 
	 * }
	 * 
	 * Cardresult = validator.validate();
	 * 
	 * if (!Cardresult) {
	 * 
	 * request.setAttribute("Error", "Invalid Card Details"); return "PurchasePage";
	 * } else { double Fullprice = Double.parseDouble(request.getParameter("p"));
	 * Orders O = new Orders(Fullprice); orderService.addOrder(O);
	 * 
	 * Orders O1 = orderService.getOrderById(O.getProductId()); for (Item i :
	 * shoppingCart) { O1.getProducts().add(i); }
	 * orderService.updateOrder(O1.getProductId(), O1);
	 * 
	 * int userId = u.getCustomerId(); User newUser =
	 * userService.getUserById(userId); newUser.getUserOrders().add(O1);
	 * userService.updateUser(userId, u);
	 * 
	 * shoppingCart.clear(); return "home"; } }
	 */

	@RequestMapping("/index")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/searchProducts")
	public String searchProducts() {
		return "search";
	}
	
	@RequestMapping("/addStock")
	public String addStock() {
		return "addStock";
	}
	
	@RequestMapping("/adminSearching")
	public String adminSearching() {
		return "adminSearch";
	}

	@PostMapping("/addUser")
	public String registerUser(HttpServletRequest request, HttpSession session) {
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String date = request.getParameter("dob");
		String uname = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("shippingAddress");
		String method = request.getParameter("paymentMethod");

		User u = new User(first, last, date, uname, password, address, method);
		userService.addUser(u);
		session.setAttribute("user", u);

		return "home";
	}

	@PostMapping("/addItem")
	public String addItem(HttpServletRequest request) {
		String title = request.getParameter("title");
		String manufacturer = request.getParameter("manufacturer");
		String category = request.getParameter("category");
		String photo = request.getParameter("photo");
		double price = Double.parseDouble(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		

		boolean state;
		State noStock = new OutOfStock();
		State hasStock = new InStock();
		
		if (amount <= 0) {
			state = noStock.stateOfStock();
		}
		else {
			state = hasStock.stateOfStock();
		}


		Item i = new Item(title, manufacturer, category, photo, price, amount, state);
		itemService.addItem(i);

		return "itemSuccess";
	}

	@RequestMapping("/searchProduct")
	public String search(@RequestParam("search") String search, HttpServletRequest request, HttpSession session) {
		if (request.getParameter("category") != null) {
			String type = "category";
			session.setAttribute("searchBy", type);
			session.setAttribute("query", search);
			return "Results";

		} else if (request.getParameter("title") != null) {
			String type = "title";
			session.setAttribute("searchBy", type);
			session.setAttribute("query", search);
			return "Results";

		} else if (request.getParameter("manufacturer") != null) {
			String type = "manufacturer";
			session.setAttribute("searchBy", type);
			session.setAttribute("query", search);
			return "Results";

		} else {
			return "search";
		}
	}

	@RequestMapping("/login")
	public String loginUser(@ModelAttribute User u, HttpServletRequest request, HttpSession session) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (userService.getUserByUsernameAndPassword(username, password) != null) {
			u = userService.getUserByUsernameAndPassword(username, password);
			session.setAttribute("user", u);

			return "home";

		} else if (username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("Admin123")) {
			session.setAttribute("admin", username);
			return "admin";

		} else {
			request.setAttribute("error", "Invalid Username or Password");
			return "index";
		}
	}

	/*
	 * @RequestMapping("/purchase") public String purchase() { return "purchase"; }
	 */

	@RequestMapping("/cart")
	public String userShoppingshoppingCart(HttpSession session) {
		int count = 0;
		double price = 0.0;
		for (Item currentItem : shoppingCart) {
			count = count + 1;
			double itemPrice = currentItem.getPrice();
			price = price + itemPrice;
		}
		session.setAttribute("itemPrice", price);
		session.setAttribute("amount", count);
		return "cart";
	}

	@RequestMapping("/addShoppingCart")
	public String addProduct(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("prodID"));
		Item up = itemService.getItemById(id);
		System.out.println(up.toString());

		shoppingCart.add(up);

		HttpSession session = request.getSession();
		session.setAttribute("list", shoppingCart);

		return "home";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		shoppingCart.clear();
		session.invalidate();
		return "index";
	}
	
	@PostMapping("/addingStock")
	public String addStock(HttpServletRequest request, HttpSession session) {
		String title = request.getParameter("title");
		String manu = request.getParameter("manufacturer");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		String photo = request.getParameter("photo");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		boolean state;
		State noStock = new OutOfStock();
		State hasStock = new InStock();
		
		if (amount <= 0) {
			state = noStock.stateOfStock();
		}
		else {
			state = hasStock.stateOfStock();
		}

		Item si = new Item(title, manu, category, photo, price, amount, state);
		itemService.addItem(si);

		return "admin";
	}
	
	@RequestMapping("adminSearch")
	public String adminSearch(@RequestParam("adminSearch") String adminSearch, HttpServletRequest request, HttpSession session) {
		
		ArrayList<Item> items = (ArrayList<Item>) itemService.getAllItems();
		ArrayList<Item> searchStock = new ArrayList<Item>();
		if (request.getParameter("category") != null) {
			for(Item s: items) {
				if(s.getCategory().contains(adminSearch)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			
			return "adminSearchResults";

		} else if (request.getParameter("manufacturer") != null) {
			for(Item s: items) {
				if(s.getManufacturer().equalsIgnoreCase(adminSearch)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "adminSearchResults";

		} else if (request.getParameter("title") != null) {
			for(Item s: items) {
				if(s.getTitle().contains(adminSearch)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "adminSearchResults";

		} else {
			return "adminSearch";
		}
	}
	
	@RequestMapping("/search")
	public String Search(@RequestParam("search") String search, HttpServletRequest request, HttpSession session) {

		ArrayList<Item> items = (ArrayList<Item>) itemService.getAllItems();
		ArrayList<Item> searchStock = new ArrayList<Item>();
		if (request.getParameter("category") != null) {
			for(Item s: items) {
				if(s.getCategory().contains(search)) {
					searchStock.add(s);
				}
			}
			session.setAttribute("searchResult", searchStock);
			return "searchResults";

		} else if (request.getParameter("manufacturer") != null) {
			for(Item s: items) {
				if(s.getManufacturer().equalsIgnoreCase(search)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "searchResults";

		} else if (request.getParameter("title") != null) {
			for(Item s: items) {
				if(s.getTitle().contains(search)) {
					searchStock.add(s);
				}
			}
			
			session.setAttribute("searchResult", searchStock);
			return "searchResults";

		} else {
			return "search";
		}
	}
}

