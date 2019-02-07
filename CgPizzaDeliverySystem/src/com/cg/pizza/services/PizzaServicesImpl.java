package com.cg.pizza.services;

import java.util.HashMap;
import java.util.regex.Pattern;

import com.cg.pizza.beans.Address;
import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.Items;
import com.cg.pizza.beans.Order;
import com.cg.pizza.daoservices.PizzaDAO;
import com.cg.pizza.daoservices.PizzaServicesDAOImpl;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.exceptions.InvalidEmailIdException;
import com.cg.pizza.exceptions.InvalidMobileNumberException;
import com.cg.pizza.util.PizzaDBUtil;

public class PizzaServicesImpl implements PizzaServices
{
	private PizzaDAO pizzaDAO;
	public PizzaServicesImpl() {
		pizzaDAO = new PizzaServicesDAOImpl();
	}
    public PizzaServicesImpl(PizzaDAO pizzaDAO)
    {
    	super();
    	this.pizzaDAO = pizzaDAO;
    }
    public  boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    
    @Override
	public int acceptCustomerDetails(String firstName, String lastName, String mobNumber, String emailId,String city,
			String landmark, long zipCode) throws InvalidMobileNumberException, InvalidEmailIdException {
		Customer customer = new Customer(firstName, lastName, mobNumber, emailId, new Address(city,landmark,zipCode));
		String email = customer.getEmailId();
		if(customer.getMobNumber().length() < 10)
			throw new InvalidMobileNumberException("Invalid Mobile Number!");
		if(!isValid(email))
			throw new InvalidEmailIdException("Invalid Email Id!");
		customer = pizzaDAO.save(customer);
		return customer.getCustId();
	}
	@Override
	public Customer acceptOrder(int custId, Order order) throws CustomerNotFoundException {
		Customer customer = pizzaDAO.findOne(custId);
		if(customer == null)
		   throw new CustomerNotFoundException("Sorry Customer Not Found!");
		Order orders = new Order();
		Integer orderId = PizzaDBUtil.getORDER_ID();
		int oId = orderId;
		orders.setOrderId(oId);
		orders.setQuantity(customer.order.getQuantity());
		return null;
	}

	@Override
	public int calculatePrice(int orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashMap<String, Items> showAllItems() 
	{
		return null;
	}
	
	
}
