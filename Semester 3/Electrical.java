public class Electrical
{
    private String electricalID;
    private String electricalName;
    private String electricalLocation;
    private String electricalStatus;
    private int electricalPriority;
    
    public Electrical(){}
    
    public Electrical(String id, String name, String loc, String stat, int prio)
    {
        this.electricalID = id;
        this.electricalName = name;
        this.electricalLocation = loc;
        this.electricalStatus = stat;
        this.electricalPriority = prio;
    }
    
    public String getElectricalID()
    {
        return this.electricalID;
    }
    public String getElectricalName()
    {
        return this.electricalName;
    }
    public String getElectricalLocation()
    {
        return this.electricalLocation;
    }
    public String getElectricalStatus()
    {
        return this.electricalStatus;
    }
    public int getElectricalPriority()
    {
        return this.electricalPriority;
    }
    
    public void setElectricalID(String id)
    {
        this.electricalID = id;
    }
    public void setElectricalName(String name)
    {
        this.electricalName = name;
    }
    public void setElectricalLocation(String loc)
    {
        this.electricalLocation = loc;
    }
    public void setElectricalStatus(String stat)
    {
        this.electricalStatus = stat;
    }
    public void setElectricalPriority(int prio)
    {
        this.electricalPriority = prio;
    }
    
    public String toString()
    {
        return "\n\nElectrical Info: \nID:" + getElectricalID() +
               "\nName: " + getElectricalName() +
               "\nLocation: " + getElectricalLocation() +
               "\nStatus: " + getElectricalStatus() +
               "\nPriority Level: " + getElectricalPriority();
    }
}