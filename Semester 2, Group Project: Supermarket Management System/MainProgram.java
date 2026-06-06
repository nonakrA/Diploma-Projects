import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileReader;
import java.util.StringTokenizer;

public class MainProgram
{
    public static void main(String []a)
    {
        Item[] arrItem = new Item[100];
        Order[] order = new Order[100];
        Customer[] myCustomer = new Customer[30];
        Admin[] myAdmin = new Admin[30];
        
        //item.close();
        //user.close();
        //customer.close();
        //admin.close();
        
        try
        {
            //List to store information
            FileWriter fItem = new FileWriter("ItemList.txt");
            FileWriter fUser = new FileWriter("User.txt", true);
            FileWriter fCustomer = new FileWriter("CustomerList.txt", true);
            FileWriter fAdmin = new FileWriter("AdminList.txt", true);
            /*FileWriter fReceipt = new FileWriter("ReceiptList.txt");*/
            
            PrintWriter item = new PrintWriter(fItem);
            PrintWriter user = new PrintWriter(fUser);
            PrintWriter customer = new PrintWriter(fCustomer);
            PrintWriter admin = new PrintWriter(fAdmin);
            /*PrintWriter receipt = new PrintWriter(fReceipt);*/
            
            //Item preset
            Item milk = new Item("Milk", "A1", 7.99, "Dairy");
            Item bread = new Item("Bread", "B3", 4.99, "Baked Goods");
            Item rice = new Item("Rice", "A2", 14.99, "Dry Goods");
            Item brownies = new Item("Brownies", "B9", 8.99, "Baked Goods");
            
            //File Readers
            FileReader rItem = new FileReader("ItemList.txt");
            Scanner inItem = new Scanner(rItem);
            FileReader rUser = new FileReader("User.txt");
            Scanner inUser = new Scanner(rUser);
            FileReader rCustomer = new FileReader("CustomerList.txt");
            Scanner inCustomer = new Scanner(rCustomer);
            
            item.print(milk.getItemCategory() + "@" + milk.getItemName() + "@" + milk.getItemID() + "@" + milk.getUnitCost());
            item.print("@" + bread.getItemCategory() + "@" + bread.getItemName() + "@" + bread.getItemID() + "@" + bread.getUnitCost());
            item.print("@" + rice.getItemCategory()+ "@" + rice.getItemName() + "@" + rice.getItemID() + "@" + rice.getUnitCost());
            item.print("@" + brownies.getItemCategory()+ "@" + brownies.getItemName() + "@" + brownies.getItemID() + "@" + brownies.getUnitCost());
            
            item.close();
            
            String lineItem = inItem.nextLine();
            StringTokenizer stItem = new StringTokenizer(lineItem, "@");
            String lineCustomer = inCustomer.nextLine();
            StringTokenizer stCustomer = new StringTokenizer(lineCustomer, "@");
            String lineUser = inUser.nextLine();
            StringTokenizer stUser = new StringTokenizer(lineUser, "@");
            
            //Login
            Scanner scanner = new Scanner(System.in);
            
            //Verify new, customer or admin
            for(int i = 0; i < 1000; i++)
            {
                boolean exist = false, existCustomer = false, existAdmin = false, verifyPassword = false, again = false;
                char answer = 'N';
                String password = "X", category = "X", extractItemList = "", storeItemList = "";
                int choose = 0, count = 0, indexArrItem = 0;;
                
                while(stItem.hasMoreTokens())
                {
                    if(count == 0)
                    {
                        extractItemList = extractItemList + stItem.nextToken() + "@" ;
                    }
                    else
                    {
                        extractItemList = extractItemList + "@" + stItem.nextToken();
                    }
                    count++;
                }
                
                storeItemList = extractItemList;
                
                count = 0;
                
                System.out.println("Enter Name: ");
                String nameUser = scanner.nextLine();
            
                System.out.println("Enter ID: ");
                String idUser = scanner.nextLine();
                
                String tempUser = nameUser + "@" + idUser;

                while(stUser.hasMoreTokens())
                {           
                    String userName = stUser.nextToken();
                    String userId = stUser.nextToken();
                    
                    if(tempUser.equalsIgnoreCase(userName + "@" + userId))
                    {
                        exist = true;
                    }
                }
                
                String tempName = stCustomer.nextToken();
                String tempId = stCustomer.nextToken();
                
                if(exist == false)
                {    
                    user.print("@" + nameUser + "@" + idUser);
                    user.close();
                    
                    System.out.println("Looks like your new here! Are you a customer or an administrator?(C/A)");
                    answer = scanner.next().charAt(0);
                    scanner.nextLine();
                }
                else
                {
                   while(stCustomer.hasMoreTokens())
                   {
                       if(nameUser.equalsIgnoreCase(tempName) && idUser.equalsIgnoreCase(tempId))
                       {
                           answer = 'C';
                           existCustomer = true;
                           break;
                       }
                       else
                       {
                           stCustomer.nextToken();
                           tempName = stCustomer.nextToken();
                           tempId = stCustomer.nextToken();
                       }
                   }
                   if(answer == 'N')
                   {
                       answer = 'A';
                       existAdmin = true;
                   }
                }

                if(answer == 'C' || answer == 'c')
                {
                    if(existCustomer == true)
                    {
                        String checkPassword = stCustomer.nextToken();
                        
                        do
                        {
                            verifyPassword = false;
                            
                            System.out.println("Enter your password: ");
                            String tempPassword = scanner.nextLine();
                                                          
                            if(tempPassword.equals(checkPassword))
                            {
                                verifyPassword = true;
                                tempPassword = checkPassword;
                                myCustomer[i] = new Customer(nameUser, idUser, tempPassword);
                            }
                            else
                            {
                                System.out.println("Wrong Password!");
                                verifyPassword = false;
                            }
                        }while(verifyPassword == false);
                    }
                    else
                    {
                        do
                        {
                            verifyPassword = false;
                            System.out.println("Enter your new password: ");
                            password = scanner.nextLine();
                            
                            System.out.println("Password confirmation: ");
                            String confirmPassword = scanner.nextLine();
                            
                            if(password.equals(confirmPassword))
                            {
                                verifyPassword = true;
                            }
                            else
                            {
                                System.out.println("Password confirmation failed. Please try again.");
                            }
                        }while(verifyPassword == false);
                        
                        myCustomer[i] = new Customer(nameUser, idUser, password);
                        customer.print("@" + nameUser + "@" + idUser + "@" + password);
                        customer.close();
                    }   
                    
                    
                    do
                    {
                        System.out.println("What category of items are you looking for?(1/2/3)");
                        System.out.println("1. Baked Goods");
                        System.out.println("2. Dry Goods");
                        System.out.println("3. Dairy");
                        
                        extractItemList = storeItemList;
                        StringTokenizer tokenItem = new StringTokenizer(extractItemList, "@");
                        
                        again = false;
                        choose = scanner.nextInt();
                        
                        if(choose == 1)
                        {   
                            System.out.println("Here's a list of all available baked goods products that we have!");
                            System.out.println("\nBAKED GOODS");
                            
                            while(tokenItem.hasMoreTokens())
                            {
                                category = tokenItem.nextToken();
                                
                                if(category.equalsIgnoreCase("Baked Goods"))
                                {
                                    String name = tokenItem.nextToken();
                                    String id = tokenItem.nextToken();
                                    String cost = tokenItem.nextToken();
                                    
                                    System.out.println(name);
                                    System.out.println("ID: " + id);
                                    System.out.println("Price: RM" + cost + "\n");
                                }
                            }
                        }
                        else if(choose == 2)
                        {
                            System.out.println("Here's a list of all available dry goods products that we have!");
                            System.out.println("\nDRY GOODS");
                        
                            while(tokenItem.hasMoreTokens())
                            {
                                category = tokenItem.nextToken();
                                
                                if(category.equalsIgnoreCase("Dry Goods"))
                                {
                                    String name = tokenItem.nextToken();
                                    String id = tokenItem.nextToken();
                                    String cost = tokenItem.nextToken();
                                    
                                    System.out.println(name);
                                    System.out.println("ID: " + id);
                                    System.out.println("Price: RM" + cost + "\n");
                                }
                            }
                        }
                        else if(choose == 3)
                        {
                            System.out.println("Here's a list of all available dairy products that we have!");
                            System.out.println("\nDAIRY");
                        
                            while(tokenItem.hasMoreTokens())
                            {
                                category = tokenItem.nextToken();
                                
                                if(category.equalsIgnoreCase("Dairy"))
                                {
                                    String name = tokenItem.nextToken();
                                    String id = tokenItem.nextToken();
                                    String cost = tokenItem.nextToken();
                                    
                                    System.out.println(name);
                                    System.out.println("ID: " + id);
                                    System.out.println("Price: RM" + cost + "\n");
                                }
                            }
                        }
            
                        extractItemList = storeItemList;
                        tokenItem = new StringTokenizer(extractItemList, "@");
                        
                        System.out.println("Enter the ID of the item you want to buy, Enter 'EXIT' to exit the current category: ");
                        scanner.nextLine();
                        String buy = scanner.nextLine();
                        
                        while(tokenItem.hasMoreTokens())
                        {   
                            if(buy.equals(tokenItem.nextToken()))
                            {
                                extractItemList = storeItemList;
                                tokenItem = new StringTokenizer(extractItemList, "@");
                                
                                while(count > 2)
                                {
                                    tokenItem.nextToken();
                                    count--;
                                }
                                
                                String pointCategory = tokenItem.nextToken();
                                String pointName = tokenItem.nextToken();
                                String pointId = tokenItem.nextToken();
                                String cost = tokenItem.nextToken();
                                double convertCost = 0;
                                convertCost = convertCost + Double.parseDouble(cost);
                                
                                arrItem[indexArrItem] = new Item(pointName, pointId, convertCost, pointCategory);
                            }
                            else
                            {
                                count++;
                            }
                        }
                        
                        /*System.out.println("Do you want to pick more item?(Y/N)");
                        answer = scanner.next().charAt(0);
                        if(answer == 'Y' || answer == 'y')
                        {
                            again = true;
                            indexArrItem++;
                        }
                        else if(answer == 'N' || answer == 'n')
                        {
                            again = false;
                        }*/
                    }while(again == true);
                    
                    System.out.println("Enter the quantity of item that you want to buy: ");
                    int quantity = scanner.nextInt();
                    
                    order[i] = new Order("A0", arrItem, quantity);
                    
                    double totalCost = order[i].getQuantity() * arrItem[indexArrItem].getUnitCost();
                    
                    System.out.println("The cost is RM" + totalCost);
                    System.out.println("Please enter your payment: RM");
                    
                    double pay = scanner.nextDouble();
                    
                    Payment payment = new Payment(pay, "A0", "??/??/20??");
                    
                    double change = pay - totalCost;
                    Receipt receipt = new Receipt(myCustomer[i].getName(), "A0", totalCost);
                    
                    System.out.println("Here is your receipt:");
                    System.out.println(receipt.toString());
                    System.out.println("Payment made: RM" + pay);
                    System.out.println("Balance: RM" + change);
                    
                    System.exit(0);
                }
                else if(answer == 'A' || answer == 'a')
                {
                    System.out.println("Enter your Admin Key: ");
                    String key = scanner.nextLine();
                        
                    myAdmin[i] = new Admin(nameUser, idUser, key);
                    admin.println(nameUser + "@" + idUser + "@" + key);
                        
                    admin.close();
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }
    }
}