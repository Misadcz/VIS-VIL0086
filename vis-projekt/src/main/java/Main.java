import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import BusinessLayer.mapper.CustomerMapper;
import BusinessLayer.mapper.OrderMapper;
import BusinessLayer.objects.Customer;
import BusinessLayer.objects.Order;


public class Main
{

    public static void main(String args[]) throws IOException
    {
    	while(true)
    	{
    		CustomerMapper customerMapper = new CustomerMapper();
    		OrderMapper orderMapper = new OrderMapper();
    		
        	String alergy;
    		String email;
    		String lastname;
    		String firstname;
    		int customer_id;
    		
    		
    		System.out.println(" 0 - EXIT");
    		System.out.println(" 1 - Show Order by Order ID");
    		System.out.println(" 2 - Show All Customers");
    		System.out.println(" 3 - Show All Orders");
    		System.out.println(" 4 - Create Order");
    		System.out.println(" 5 - Edit Customer ");
    		System.out.println(" 6 - Delete Order ");
    			
    		BufferedReader ans = new BufferedReader(new InputStreamReader(System.in));
    		String answer = ans.readLine();
    		 
    		switch(answer)
    		{
    		case "0" :
    			return;
    			
    		case "1" :
    			System.out.println("Type ID of Order");
        		Order temp_order = orderMapper.find(Integer.parseInt(ans.readLine()));
        		if(temp_order != null)
        		{System.out.println("ID\t|Type of menu\t|Customer ID\t|Menu ID");
        		System.out.println( temp_order.getId() 
        				+ "\t|" + temp_order.getType() 
        				+ "\t|" + temp_order.getCustomerId()
        				+ "\t\t|" + temp_order.getMenuId()
        				);
        		}
        		else
        		{
        			System.out.println("Order does not exist.");
        		}
    			break;
    			
    		case "2" :
    			System.out.println("-------------------------------------------------");
    			System.out.println("ID\t|First name\t|Last name\t|Email\t\t\t|Alergy\t|Date");
    			customerMapper.selectAll().forEach((n) -> System.out.println( n.getId() 
				+ "\t|" + n.getFirstname() 
				+ "\t\t|" + n.getLastname()
				+ "\t\t|" + n.getEmail()
				+ "\t\t\t|" + n.getAlergy()
				+ "\t|" + n.getDate()
				));
    			System.out.println("-------------------------------------------------");
    			break;
    			
    		case "3" :
    			System.out.println("-------------------------------------------------");
    			System.out.println("ID\t|Type of menu\t|Customer ID\t|Menu ID");
    			orderMapper.selectAll().forEach((n) -> System.out.println( n.getId() 
				+ "\t|" + n.getType() 
				+ "\t|" + n.getCustomerId()
				+ "\t\t|" + n.getMenuId()
				));
    			System.out.println("-------------------------------------------------");
    			break;
    			
    		case "4" :
    			System.out.println("First name:");
    	    	 firstname = ans.readLine();
    	    	System.out.println("Last name:");
    			 lastname = ans.readLine();
    	    	System.out.println("Email:");
    	    	 email = ans.readLine();
    	    	System.out.println("Alergy:");
    	    	 alergy = ans.readLine();
    	    	System.out.println("Type of Menu:");
    	    	String type = ans.readLine();
    	    	
    	    	Random random = new Random();
    	    	int id_order = random.nextInt(400);
    	    	 customer_id  = random.nextInt(400);
    	    	customerMapper.insert(new Customer(customer_id,firstname,lastname,email,alergy,"2023-12-01"));
    	    	orderMapper.insert(new Order(id_order,type,customer_id,0));
    	    	
    			break;
    		case "5" :
    			System.out.print("ID of Customer");
    			customer_id = Integer.parseInt(ans.readLine());
    			System.out.println("Write new first name:");
    			 firstname = ans.readLine();
    			System.out.println("Write new last name:");
    			 lastname = ans.readLine();
    			System.out.println("Write new email:");
    			 email = ans.readLine();
    			System.out.println("Write new alergy:");
    			 alergy = ans.readLine();
    			if( customerMapper.find(customer_id)!= null)
    			{customerMapper.update(new Customer(customer_id,firstname,lastname,email,alergy,"2023-12-01"));}
    			else
    			{
    				System.out.println("Customer Does not exist."); 
    			}
    			break;
    		case "6" :
    			System.out.print("ID of Order");
    			temp_order = orderMapper.find(Integer.parseInt(ans.readLine()));
    			if(temp_order!= null)
    			{
    				orderMapper.delete(temp_order);
    				System.out.println("Deleted.");
    			}
    			else
    			{
    				System.out.println("Order does not exist.");
    			}
    			break;
    			
    		default:
    			break;
    		}
    		
    	}	
    }
}
