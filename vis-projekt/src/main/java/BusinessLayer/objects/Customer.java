package BusinessLayer.objects;


public class Customer
{
	private int id_customer;
	private String firstname;
	private String lastname;
	private String email;
	private String date;
	private String alergy;
    
    public Customer(int rand,String firstname,String lastname,String email , String alergy,String date)
    {
    	this.id_customer = rand;
		this.firstname =firstname;
		this.lastname = lastname;
		this.email = email;
	   this.alergy = alergy;
	   this.date =  date;
    }
    
    public int getId() { return this.id_customer;}
    public String getFirstname() { return this.firstname;}
    public String getLastname() { return this.lastname;}
    public String getEmail() { return this.email;}
    public String getDate() { return this.date;}
    public String getAlergy() { return this.alergy;}
    
    public void setFirstname(String firstname) {  this.firstname = firstname;}
    public void setLastname(String lastname) {  this.lastname = lastname;}
    public void setEmail(String email) {  this.email = email;}
    public void setDate(String date) {  this.date = date;}
    public void setAlergy(String alergy) {  this.alergy = alergy;}
    
}