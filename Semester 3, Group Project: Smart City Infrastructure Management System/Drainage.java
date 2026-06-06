public class Drainage
{
    private String drainID;
    private String drainName;
    private String drainLocation;
    private String drainStatus;
    private int drainPriority;
    
    public Drainage(){}
    
    public Drainage(String id, String name, String loc, String stat, int prio)
    {
        this.drainID = id;
        this.drainName = name;
        this.drainLocation = loc;
        this.drainStatus = stat;
        this.drainPriority = prio;
    }
    
    public String getDrainID()
    {
        return this.drainID;
    }
    public String getDrainName()
    {
        return this.drainName;
    }
    public String getDrainLocation()
    {
        return this.drainLocation;
    }
    public String getDrainStatus()
    {
        return this.drainStatus;
    }
    public int getDrainPriority()
    {
        return this.drainPriority;
    }
    
    public void setDrainID(String id)
    {
        this.drainID = id;
    }
    public void setDrainName(String name)
    {
        this.drainName = name;
    }
    public void setDrainLocation(String loc)
    {
        this.drainLocation = loc;
    }
    public void setDrainStatus(String stat)
    {
        this.drainStatus = stat;
    }
    public void setDrainPriority(int prio)
    {
        this.drainPriority = prio;
    }
    
    public String toString()
    {
        return "\n\nDrainage Info: \nID:" + getDrainID() +
               "\nName: " + getDrainName() +
               "\nLocation: " + getDrainLocation() +
               "\nStatus: " + getDrainStatus() +
               "\nPriority Level: " + getDrainPriority();
    }
}