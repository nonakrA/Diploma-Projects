public class Customer extends User
{
    private String custPassword;
    
    public Customer(String name, String id,  String password)//Use Normal Constructor, change in report
    {
        super(name, id);
        this.custPassword = password;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public void setId(String id)//Change in progress report later
    {
        this.id = id;
    }
    public void setCustPassword(String password)//Change in progress report later
    {
        this.custPassword = password;
    }
    
    public String getName()
    {
        return name;
    }
    public String getId()//Change in progress report later
    {
        return id;
    }
    public String getCustPassword()//Change in progress report later
    {
        return custPassword;
    }
    
    public String toString()
    {
        return "Name: " + getName() + 
               "\nID: " + getId() +
               "\nPassword: " + getCustPassword();
    }
}