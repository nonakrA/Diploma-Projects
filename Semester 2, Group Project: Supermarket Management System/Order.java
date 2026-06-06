public class Order
{
    private String orderID; //Change in progress report later
    private Item[] itemList;
    private int quantity;
    
    public Order(String id, Item[] list, int quantity)//Use Normal Constructor, change in report
    {
        this.orderID = id;
        this.itemList = list;
        this.quantity = quantity;
    }
    
    public void setOrderID(String id)//Change in progress report later
    {
        this.orderID = id;
    }
    public void setItemList(Item[] list)
    {
        this.itemList = list;
    }
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public String getOrderID()//Change in progress report later
    {
        return orderID;
    }
    public Item[] getItemList()
    {
        return itemList;
    }
    public double getQuantity()
    {
        return quantity;
    }
    
    public String toString()
    {
        return "Order ID: " + getOrderID() + 
               "\nItems:  " + getItemList() +
               "\nItem Quantity: " + getQuantity();
    }
}