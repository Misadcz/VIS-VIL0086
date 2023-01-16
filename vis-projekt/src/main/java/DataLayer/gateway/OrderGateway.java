package DataLayer.gateway;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import BusinessLayer.objects.Order;
import DataLayer.connection.SQLConnection;

public class OrderGateway {
	
	private SQLConnection sqlConnection;
	
 public OrderGateway()
 {
	 this.sqlConnection = new SQLConnection();
 }
	
	public void insert(Order order) 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
	         Statement statement = connection.createStatement();) 
		{
			String insertSql = "INSERT INTO Orders ( id_orders, type_menu, customer_id_customer, menu_id_menu) VALUES "
	                    		+ "("+ order.getId()+",'"+ order.getType() + "',"+order.getCustomerId()+","+order.getMenuId()+");";
	        statement.executeUpdate(insertSql);
	    }
	    catch (SQLException e) 
		{
	    	e.printStackTrace();
	    }
	}
	
	public void update(Order order) 
	{
        try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
                Statement statement = connection.createStatement();) 
           {
                String updateSql = "UPDATE Orders set type_menu = '" + order.getType() +"', customer_id_customer = '"+ order.getCustomerId() +"',menu_id_menu = '"+ order.getMenuId();                                                      
                statement.executeUpdate(updateSql);  
           }
           catch (SQLException e) 
           {
               e.printStackTrace();
           }
   	}
		
	public Order find(int id) 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
	         Statement statement = connection.createStatement();) 
		{
	         String selectSql = "SELECT * FROM Orders WHERE id_orders =" + id;
	         ResultSet rs = statement.executeQuery(selectSql);
	            
	         while(rs.next())
	         {	
	        	 return new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
	         }
	             return null;
	    }
	    catch (SQLException e) 
		{
	    	e.printStackTrace();
	    }
		return null;
	}

	public void delete(Order order) 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
             Statement statement = connection.createStatement();) 
        {
             String deleteSql = "DELETE FROM Orders WHERE id_orders = " + order.getId();
             statement.executeUpdate(deleteSql);
        }
        catch (SQLException e) 
		{
             e.printStackTrace();
        }	
	}

	public ArrayList<Order> selectAll() 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
	         Statement statement = connection.createStatement();) 
		{
	         String selectSql = "SELECT * FROM Orders";
	         ResultSet rs = statement.executeQuery(selectSql);
	         ArrayList<Order> orders = new ArrayList<Order>();
	         while(rs.next())
	         {		
	            orders.add(new Order(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
	         }
	            return orders;
	        }
	        catch (SQLException e) 
			{
	            e.printStackTrace();
	        }
		return null;
	}
}
