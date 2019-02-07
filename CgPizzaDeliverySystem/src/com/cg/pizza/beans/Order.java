package com.cg.pizza.beans;

import java.util.HashMap;

public class Order 
{
	private int orderId;
	private int quantity;
	public HashMap<String,Integer> items;

	public Order()
	{
		items.put("Onion Pizza",90);
		items.put("Cheese Pizza", 110);
		items.put("FarmHouse Pizza",190);
		items.put("Chicken Pizza",220);
	}

	/*
	 * public Order(int quantity, HashMap<String, Integer> items) { super();
	 * this.quantity = quantity; this.items = items; }
	 * 
	 * 
	 * public Order(int orderId, int quantity, HashMap<String, Integer> items) {
	 * super(); this.orderId = orderId; this.quantity = quantity; this.items =
	 * items; }
	 */

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public HashMap<String, Integer> getItems() {
		return items;
	}

	public void setItems(HashMap<String, Integer> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + orderId;
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (orderId != other.orderId)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", quantity=" + quantity + ", items=" + items + "]";
	}


}
