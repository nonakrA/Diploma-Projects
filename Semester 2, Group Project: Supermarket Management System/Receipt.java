public class Receipt
{
    private String custName;//Probably not needed, Customer class already have it
    private String receiptID;//Change in progress report later
    private double totalPay;//Also probably not needed, Order class already have total cost?
    
    public Receipt(String name, String id, double total)//Use Normal Constructor, change in report
    {
        this.custName = name;
        this.receiptID = id;
        this.totalPay = total;
    }
    
    public void setCustName(String name)
    {
        this.custName = name;
    }
    public void setReceiptID(String id)//Change in progress report later
    {
        this.receiptID = id;
    }
    public void setTotalPay(double total)
    {
        this.totalPay = total;
    }
    
    public String getCustName()
    {
        return custName;
    }
    public String getReceiptID()//Change in progress report later
    {
        return receiptID;
    }
    public double getTotalPay()
    {
        return totalPay;
    }
    
    public String toString()
    {
        return "Name: " + getCustName() + 
               "\nReceipt ID: " + getReceiptID() +
               "\nTotal Cost: RM" + getTotalPay();
    }
}