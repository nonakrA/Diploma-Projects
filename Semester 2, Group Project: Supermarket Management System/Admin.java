public class Admin extends User
{
    private String adminKey;
    
    public Admin(String name, String id, String key)
    {
        super(name, id);
        this.adminKey = key;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public void setID(String id)//Change in progress report later
    {
        this.id = id;
    }
    public void setAdminKey(String key)
    {
        this.adminKey = key;
    }
    
    public String getName()
    {
        return name;
    }
    public String getId()//Change in progress report later
    {
        return id;
    }
    public String getAdminKey()
    {
        return adminKey;
    }
    
    public String toString()
    {
        return "Name: " + getName() + 
               "\nID: " + getId() +
               "\nAdmin Key: " + getAdminKey();
    }
}