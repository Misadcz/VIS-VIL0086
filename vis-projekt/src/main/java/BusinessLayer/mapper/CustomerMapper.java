package BusinessLayer.mapper;
import java.util.ArrayList;

import BusinessLayer.objects.Customer;
import DataLayer.gateway.CustomerGateway;

public class CustomerMapper
{
	CustomerGateway customerGateway;
	public CustomerMapper()
	{
		this.customerGateway = new CustomerGateway();
	}
    
	public void insert(Customer customer)	
	{
		customerGateway.insert(customer);
	}
	
	public Customer find(int id)
	{
		return customerGateway.find(id);
	}
	
	public void update(Customer customer)
	{
		customerGateway.update(customer);
	}
	
	public void delete(Customer customer)
	{
		customerGateway.delete(customer);
	}
		
	public ArrayList<Customer> selectAll()
	{
		 return customerGateway.selectAll();
	} 
}