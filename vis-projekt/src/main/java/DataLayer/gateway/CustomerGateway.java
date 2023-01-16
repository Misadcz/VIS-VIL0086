package DataLayer.gateway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLayer.objects.Customer;
import DataLayer.connection.SQLConnection;

public class CustomerGateway
{
	private SQLConnection sqlConnection;
	
	public CustomerGateway()
	{
		this.sqlConnection = new SQLConnection();
	}
	
	
	public void insert(Customer customer)
    {
        try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
             Statement statement = connection.createStatement();) 
        {
             String insertSql = "INSERT INTO Customer (id_customer, firstname, lastname, email, alergie,datum_narozeni) VALUES "
                    		   + "("+customer.getId()+",'"+ customer.getFirstname()+"','"+customer.getLastname()+"','"+customer.getEmail()+"','"+customer.getAlergy()+"','"+customer.getDate()+"')";
             statement.executeUpdate(insertSql);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
	
	public void delete(Customer customer)
    {
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
	             Statement statement = connection.createStatement();) 
	        {
	             String deleteSql = "DELETE FROM Customer WHERE id_customer = " + customer.getId();
	             statement.executeUpdate(deleteSql);
	        }
	        catch (SQLException e) 
			{
	             e.printStackTrace();
	        }	
    }

	public Customer find(int id) 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
	         Statement statement = connection.createStatement();) 
		{
	         String selectSql = "SELECT * FROM Customer WHERE id_customer =" + id;
	         ResultSet rs = statement.executeQuery(selectSql);
	         while(rs.next())
	         {	
	        	 return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
	         }
	    }
	    catch (SQLException e) 
		{
	    	e.printStackTrace();
	    }
		return null;
	}

	public ArrayList<Customer> selectAll() 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
	         Statement statement = connection.createStatement();) 
		{
	         String selectSql = "SELECT * FROM Customer";
	         ResultSet rs = statement.executeQuery(selectSql);
	         ArrayList<Customer> customers = new ArrayList<Customer>();
	         while(rs.next())
	         {	
	        	 customers.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(5)));
	         }
	         return customers;
	    }
	    catch (SQLException e) 
		{
	    	e.printStackTrace();
	    }
		return null;
	}

	public void update(Customer customer) 
	{
        try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
             Statement statement = connection.createStatement();) 
        {
             String updateSql = "UPDATE Customer set firstname = '" + customer.getFirstname() +"', lastname = '"+ customer.getLastname() +"',email = '"+ customer.getEmail()+"',alergie = '"+customer.getAlergy()+"' where id_customer = "+customer.getId();                                                      
             statement.executeUpdate(updateSql);  
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
}