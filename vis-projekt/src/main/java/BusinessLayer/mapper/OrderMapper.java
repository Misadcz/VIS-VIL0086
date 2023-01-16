package BusinessLayer.mapper;
import java.util.ArrayList;

import BusinessLayer.objects.Order;
import DataLayer.gateway.OrderGateway;

public class OrderMapper
{
	private OrderGateway orderGateway;

    public OrderMapper()
    {
    	this.orderGateway = new OrderGateway();
    }
    
    public Order find(int id)
    {
    	return orderGateway.find(id);
    }

	public void insert(Order order)
    {
		orderGateway.insert(order);
    }
    
	public void delete(Order order) 
	{
		orderGateway.delete(order);
	}
	
	public void update(Order order) 
	{
		orderGateway.update(order);
	}
	
    public ArrayList<Order> selectAll() 
	{
    	return orderGateway.selectAll();
	}
}
