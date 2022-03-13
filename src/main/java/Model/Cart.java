package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items;

	public Cart() {
		items = new ArrayList<>();
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}

	public int size() {
		int n = 0;
		for (int i = 0; i < items.size(); i++) {
			n++;
		}
		return n;
	}

	public void add(Product ci) {
		for (Product x : items) {
			if (ci.getId() == x.getId()) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
		items.add(ci);
	}

	public void sub(Product ci) {
		for (Product x : items) {
			if (ci.getId() == x.getId()) {
				if (x.getNumber() == 1) {
					items.remove(x);
					return;
				}
				x.setNumber(x.getNumber() - 1);
			}
		}
	}

	public void remove(int id) {
		for (Product x : items) {
			if (x.getId() == id) {
				items.remove(x);
				return;
			}
		}
	}

	public double getAmount() {
		double s = 0;
		for (Product x : items) {
			s += x.getPrice() * x.getNumber();
		}
		return Math.round(s * 100.00) / 100.00;
	}

	public double getAmountById(int id) {
		double s = 0;
		for (Product x : items) {
			if (id == x.getId()) {
				s += x.getPrice() * x.getNumber();
				return Math.round(s * 100.00) / 100.00;
			}
		}
		return Math.round(s * 100.00) / 100.00;
	}

}
