package BusinessLayer.objects;

public class Order
{
    private int id_order;
    private String type_menu;
    private int customer_id_customer;
    private int menu_id_menu;

    public Order(int id_orders,String type_menu, int customer_id_customer,int menu_id_menu)
    {
        this.id_order = id_orders;
        this.type_menu = type_menu;
        this.customer_id_customer = customer_id_customer;
        this. menu_id_menu = menu_id_menu;
    }
    
    public int getId()
    {return this.id_order;}
    
    public String getType()
    {return this.type_menu;}
    
    public void setType(String menu)
    {this.type_menu = menu;}
    
    public int getCustomerId()
    {return this.customer_id_customer;}
    
    public void setCustomerId(int CustomerId)
    {this.customer_id_customer = CustomerId;}
    
    public int getMenuId()
    {return this.menu_id_menu;}
    
    public void setMenuId(int MenuId)
    { this.menu_id_menu = MenuId;}
    
    
    
    
    
}
