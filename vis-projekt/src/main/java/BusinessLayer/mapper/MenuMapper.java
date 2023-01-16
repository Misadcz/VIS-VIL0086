package BusinessLayer.mapper;

import java.util.ArrayList;

import BusinessLayer.objects.Menu;
import DataLayer.gateway.MenuGateway;

public class MenuMapper
{
	private MenuGateway menuGateway;
	
	public MenuMapper()
	{
		this.menuGateway = new MenuGateway();
	}
	
	public Menu find(int id)
    {
    	return menuGateway.find(id);
    }

	public void insert(Menu menu)
    {
		menuGateway.insert(menu);
    }
    
	public void delete(Menu menu) 
	{
		menuGateway.delete(menu);
	}
	
	public void update(Menu menu) 
	{
		menuGateway.update(menu);
	}
	
	public ArrayList<Menu> selectAll() 
	{
    	return menuGateway.selectAll();
	}
}