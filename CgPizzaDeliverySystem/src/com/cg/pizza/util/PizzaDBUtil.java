package com.cg.pizza.util;

import java.util.HashMap;
import java.util.Random;

import com.cg.pizza.beans.Customer;

public class PizzaDBUtil 
{
	public static HashMap<Long, Customer> customer = new HashMap<>();
	static private int n = 9999-1000;
	static Random customerId = new Random();
	public static int custId = customerId.nextInt(9999)%n;
	static Random oId = new Random();
	public static int orderId = oId.nextInt(9999)%n;
	
	public static int getCUSTOMER_ID()
	{
		return ++custId;
	}
	public static int  getORDER_ID() 
	{
	     return ++orderId;	
	}
	
}
