public class Payment
{
    private double amount;
    private String paymentID; //Change in progress report later
    private String paymentDate;
    
    public Payment(double amount, String id, String date)//Use Normal Constructor, change in report
    {
        this.amount = amount;
        this.paymentID = id;
        this.paymentDate = date;
    }
    
    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    public void setPaymentID(String id)//Change in progress report later
    {
        this.paymentID = id;
    }
    public void setPaymentDate(String date)
    {
        this.paymentDate = date;
    }
    
    public double getAmount()
    {
        return amount;
    }
    public String getPaymentID()//Change in progress report later
    {
        return paymentID;
    }
    public String getPaymentDate()
    {
        return paymentDate;
    }
    
    public String toString()
    {
        return "Total Cost: " + getAmount() + 
               "\nPurchase ID: " + getPaymentID() +
               "\nPurchase Date: " + getPaymentDate();
    }
}