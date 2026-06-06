public class Item
{
    private String itemName;
    private String itemID; //Change in progress report later
    private double unitCost;
    private String itemCategory;
    
    public Item(String name, String id, double cost, String category)
    {
        this.itemName = name;
        this.itemID = id;
        this.unitCost = cost;
        this.itemCategory = category;
    }
    
    public void setItemName(String name)
    {
        this.itemName = name;
    }
    public void setItemID(String id)//Change in progress report later
    {
        this.itemID = id;
    }
    public void setUnitCost(double cost)
    {
        this.unitCost = cost;
    }
    public void setItemCategory(String category)
    {
        this.itemCategory = category;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    public String getItemID()//Change in progress report later
    {
        return itemID;
    }
    public double getUnitCost()
    {
        return unitCost;
    }
    public String getItemCategory()
    {
        return itemCategory;
    }
    
    public String toString()
    {
        return "\n" + getItemName() +
               "\nItem Name: " + getItemName() + 
               "\nItem ID: " + getItemID() +
               "\nCost per Unit: RM" + getUnitCost() +
               "\nCategory: " + getItemCategory();
    }
}