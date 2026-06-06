public class Facilities
{
    private String facID;
    private String facName;
    private String facLocation;
    private String facStatus;
    private int facPriority;
    
    public Facilities(){}
    
    public Facilities(String id, String name, String loc, String stat, int prio)
    {
        this.facID = id;
        this.facName = name;
        this.facLocation = loc;
        this.facStatus = stat;
        this.facPriority = prio;
    }
    
    public String getFacID()
    {
        return this.facID;
    }
    public String getFacName()
    {
        return this.facName;
    }
    public String getFacLocation()
    {
        return this.facLocation;
    }
    public String getFacStatus()
    {
        return this.facStatus;
    }
    public int getFacPriority()
    {
        return this.facPriority;
    }
    
    public void setFacID(String id)
    {
        this.facID = id;
    }
    public void setFacName(String name)
    {
        this.facName = name;
    }
    public void setFacLocation(String loc)
    {
        this.facLocation = loc;
    }
    public void setFacStatus(String stat)
    {
        this.facStatus = stat;
    }
    public void setFacPriority(int prio)
    {
        this.facPriority = prio;
    }
    
    public String toString()
    {
        return "\n\nFacility Info: \nID:" + getFacID() +
               "\nName: " + getFacName() +
               "\nLocation: " + getFacLocation() +
               "\nStatus: " + getFacStatus() +
               "\nPriority Level: " + getFacPriority();
    }
}