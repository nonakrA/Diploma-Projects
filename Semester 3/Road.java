public class Road
{
    private String roadID;
    private String roadName;
    private String roadLocation;
    private String roadStatus;
    private int roadPriority;
    
    public Road(){}
    
    public Road(String id, String name, String loc, String stat, int prio)
    {
        this.roadID = id;
        this.roadName = name;
        this.roadLocation = loc;
        this.roadStatus = stat;
        this.roadPriority = prio;
    }
    
    public String getRoadID()
    {
        return this.roadID;
    }
    public String getRoadName()
    {
        return this.roadName;
    }
    public String getRoadLocation()
    {
        return this.roadLocation;
    }
    public String getRoadStatus()
    {
        return this.roadStatus;
    }
    public int getRoadPriority()
    {
        return this.roadPriority;
    }
    
    public void setRoadID(String id)
    {
        this.roadID = id;
    }
    public void setRoadName(String name)
    {
        this.roadName = name;
    }
    public void setRoadLocation(String loc)
    {
        this.roadLocation = loc;
    }
    public void setRoadStatus(String stat)
    {
        this.roadStatus = stat;
    }
    public void setRoadPriority(int prio)
    {
        this.roadPriority = prio;
    }
    
    public String toString()
    {
        return "\n\nRoad Info: \nID:" + getRoadID() +
               "\nName: " + getRoadName() +
               "\nLocation: " + getRoadLocation() +
               "\nStatus: " + getRoadStatus() +
               "\nPriority Level: " + getRoadPriority();
    }
}