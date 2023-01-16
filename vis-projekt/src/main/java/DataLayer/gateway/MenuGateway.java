package DataLayer.gateway;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLayer.objects.Menu;
import DataLayer.connection.SQLConnection;


public class MenuGateway
{
	SQLConnection sqlConnection;
	
	public MenuGateway() {
		this.sqlConnection = new SQLConnection();
	}
	public void insert(Menu m)
    {
        try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
             Statement statement = connection.createStatement();) 
        {
             String insertSql = "INSERT INTO Menu ( id_menu, breakfast, snack_1, lunch, snack_2, dinner, calories, carbohydrate, fat, protein, sugar, salt, fiber) VALUES "
                                + "('"+m.getID()+"','"+ m.getBreakfast()+"','"+m.getSnack_1()+"','"+m.getLunch()+"','"+m.getSnack_2()+"','"+m.getDinner()+"',"+m.getCalories()+","+ m.getCarbohydrate()+","+ m.getFat()+","+ m.getProtein()+","+ m.getSugar()+","+ m.getSalt()+","+ m.getFiber()+");";
             statement.executeUpdate(insertSql);
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
	
	public void SaveFileMenu(int id)
    {
		ResultSet rs;
		
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
                Statement statement = connection.createStatement();) 
		{
               String selectSql = "Select * from Menu;";
                rs=statement.executeQuery(selectSql);
               
           try(PrintWriter pw = new PrintWriter(new FileWriter("Menus.txt")))
           {
               while (rs.next()) {
                   pw.printf("%s!%s!%s!%s!%s!%s!%s!%s!%s!%s!%s!%s!%s\n",
                           rs.getString(1),
                           rs.getString(2), 
                           rs.getString(3),
                           rs.getString(4), 
                           rs.getString(5),
                           rs.getString(6),
                           rs.getString(7),
                           rs.getString(8),
                           rs.getString(9),
                           rs.getString(10),
                           rs.getString(11),
                           rs.getString(12),
                           rs.getString(13)
                           );
                   } 
           }
	       catch (IOException e) 
	       {
	               e.printStackTrace();
	       } 
	    }
	    catch (SQLException e) 
		{
	        e.printStackTrace();
	    }

    }

	public Menu find(int id) 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
		     Statement statement = connection.createStatement();) 
		{
		         String selectSql = "SELECT * FROM Menu WHERE id_menu =" + id;
		         ResultSet rs = statement.executeQuery(selectSql);
		            
		         while(rs.next())
		         {	
		        	 return new Menu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12));
		         }
		             return null;
		    }
		    catch (SQLException e) 
			{
		    	e.printStackTrace();
		    }
			return null;
	}

	public void delete(Menu menu) 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
	             Statement statement = connection.createStatement();) 
	        {
	             String deleteSql = "DELETE FROM Menu WHERE id_menu = " + menu.getID();
	             statement.executeUpdate(deleteSql);
	        }
	        catch (SQLException e) 
			{
	             e.printStackTrace();
	        }
	}

	public void update(Menu menu) 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
                Statement statement = connection.createStatement();) 
           {
                String updateSql = "UPDATE Menu set breakfast='"+menu.getBreakfast()+"','"+menu.getSnack_1()+"','"+menu.getLunch()+"','"+menu.getSnack_2()+"','"+menu.getDinner()+"','"+menu.getCalories()+"','"+menu.getCarbohydrate()+"','"+menu.getFat()+"','"+menu.getProtein()+"','"+menu.getSugar()+"','"+menu.getSalt()+"','"+menu.getFiber()+"'";                                                      
                statement.executeUpdate(updateSql);  
           }
           catch (SQLException e) 
           {
               e.printStackTrace();
           }
	}

	public ArrayList<Menu> selectAll() 
	{
		try (Connection connection = DriverManager.getConnection(sqlConnection.getConnection());
		         Statement statement = connection.createStatement();) 
			{
		         String selectSql = "SELECT * FROM Menu";
		         ResultSet rs = statement.executeQuery(selectSql);
		         ArrayList<Menu> menus = new ArrayList<Menu>();
		         while(rs.next())
		         {		
		            menus.add(new Menu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)));
		         }
		            return menus;
		        }
		        catch (SQLException e) 
				{
		            e.printStackTrace();
		        }
			return null;
	}
}