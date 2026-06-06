#include <iostream>
using namespace std;

int main()
{
	
	//Product Variable
	int countBread = 4732, countRice = 6483, countPotato = 2937, countCereal = 3852, countCanned = 1763, countPasta = 9238, countDisinfectant = 3829, countMicroFiberCloth = 3563;
	double priceBread = 3.99, priceRice = 19.99, pricePotato = 2.50, priceCereal = 7.99, priceCanned = 4.99, pricePasta = 5.99, priceDisinfectant = 9.99, priceMicroFiberCloth = 8.99;
	//Selection Variable
	int option, product;
	//User Info
	char membership;
	//Output Variable
	double totalCost, discount;
	int quantity;
	
	cout<<"Welcome to Lotus Supermarket!"<<endl;
	cout<<"Here's a list of our category of products available for purchase:"<<endl;
	
	cout<<"+---------------------------+"<<endl;
	cout<<"|     Products Category     |"<<endl;
	cout<<"|                           |"<<endl;
	cout<<"| 1. Staple Food            |"<<endl;
	cout<<"| 2. Other Food             |"<<endl;
	cout<<"| 3. Cleaning Supplies      |"<<endl;
	cout<<"+---------------------------+"<<endl;
	
	cout<<"Please pick an option (1/2/3): ";
	cin>>option;
	
	if (option == 1) { //Staple Food Product
		cout<<"\nWhat staple food are you buying?"<<endl;
		cout<<"+---------------------------+"<<endl;
		cout<<"|    Staple Food Product    |"<<endl;
		cout<<"|                           |"<<endl;
		cout<<"| 1. Bread                  |"<<endl;
		cout<<"| 2. Rice                   |"<<endl;
		cout<<"| 3. Potatoes               |"<<endl;
		cout<<"+---------------------------+"<<endl;
		
		cout<<"Please pick a product (1/2/3): ";
		cin>>product;
		
		switch(product) {
			case 1: { //Bread
				cout<<"\nThere are currently "<<countBread<<" bread product in stock"<<endl; //Display bread in stock
				cout<<"The price per unit of this product is RM"<<priceBread<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countBread && quantity >= 0) {
					totalCost = priceBread * quantity;
					countBread = countBread - quantity;
				}
				else if (quantity > countBread && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;				
			}
			case 2: { //Rice
				cout<<"\nThere are currently "<<countRice<<" rice product in stock"<<endl; //Display rice in stock
				cout<<"The price per unit of this product is RM"<<priceRice<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countRice && quantity >= 0) {
					totalCost = priceRice * quantity;
					countRice = countRice - quantity;
				}
				else if (quantity > countRice && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;				
			}
			case 3: { //Potatoes
				cout<<"\nThere are currently "<<countPotato<<" potatoes in stock"<<endl; //Display potatoes in stock
				cout<<"The price per unit of this product is RM"<<pricePotato<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countPotato && quantity >= 0) {
					totalCost = pricePotato * quantity;
					countPotato = countPotato - quantity;
				}
				else if (quantity > countPotato && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;
			}
			default: { //Invalid product
				cout<<"We don't have that in the list!";
				return 0;
				break;
			}
		}
	}
	else if (option == 2) { //Other Food Product
		cout<<"\nWhat other food product are you buying?"<<endl;
		cout<<"+----------------------------+"<<endl;
		cout<<"|     Other Food Product     |"<<endl;
		cout<<"|                            |"<<endl;
		cout<<"| 1. Cereals                 |"<<endl;
		cout<<"| 2. Canned Food             |"<<endl;
		cout<<"| 3. Pasta                   |"<<endl;
		cout<<"+----------------------------+"<<endl;
		
		cout<<"Please pick a product (1/2/3): ";
		cin>>product;
		
		switch(product) {
			case 1: { //Cereal
				cout<<"\nThere are currently "<<countCereal<<" cereal product in stock"<<endl; //Display cereal in stock
				cout<<"The price per unit of this product is RM"<<priceCereal<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countCereal && quantity >= 0) {
					totalCost = priceCereal * quantity;
					countCereal = countCereal - quantity;
				}
				else if (quantity > countCereal && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;				
			}
			case 2: { //Canned Food
				cout<<"\nThere are currently "<<countCanned<<" canned product in stock"<<endl; //Display canned food in stock
				cout<<"The price per unit of this product is RM"<<priceCanned<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countCanned && quantity >= 0) {
					totalCost = priceCanned * quantity;
					countCanned = countCanned - quantity;
				}
				else if (quantity > countCanned && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;				
			}
			case 3: { //Pasta
				cout<<"\nThere are currently "<<countPasta<<" pasta product in stock"<<endl; //Display pasta in stock
				cout<<"The price per unit of this product is RM"<<pricePasta<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countPasta && quantity >= 0) {
					totalCost = pricePasta * quantity;
					countPasta = countPasta - quantity;
				}
				else if (quantity > countPasta && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;
			}
			default: { //Invalid Product
				cout<<"We don't have that in the list!";
				return 0;
				break;
			}
		}
	}	
	else if (option == 3) { //Cleaning Supplies
		cout<<"\nWhat cleaning supplies are you buying?"<<endl;
		cout<<"+-----------------------------+"<<endl;
		cout<<"|  Cleaning Supplies Product  |"<<endl;
		cout<<"|                             |"<<endl;
		cout<<"| 1. Disinfectant Spray       |"<<endl;
		cout<<"| 2. Micro Fiber Cloth        |"<<endl;
		cout<<"+-----------------------------+"<<endl;
		
		cout<<"Please pick a product (1/2): ";
		cin>>product;
		
		switch(product) {
			case 1: { //Disinfectant Spray
				cout<<"\nThere are currently "<<countDisinfectant<<" disinfectant product in stock"<<endl; //Display disinfectant spray in stock
				cout<<"The price per unit of this product is RM"<<priceDisinfectant<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countDisinfectant && quantity >= 0) {
					totalCost = priceDisinfectant * quantity;
					countDisinfectant = countDisinfectant - quantity;
				}
				else if (quantity > countDisinfectant && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;				
			}
			case 2: { //Micro Fiber Cloth
				cout<<"\nThere are currently "<<countMicroFiberCloth<<" micro fiber cloth product in stock"<<endl; //Display micro fiber cloth in stock
				cout<<"The price per unit of this product is RM"<<priceMicroFiberCloth<<endl<<endl; //Display price per unit
				cout<<"State the quantity that you are buying: ";
				cin>>quantity;
				
				//Check for valid input for variable quantity
				//if valid, calculate the cost and substract the product purchased from the available stock
				if (quantity <= countMicroFiberCloth && quantity >= 0) {
					totalCost = priceMicroFiberCloth * quantity;
					countMicroFiberCloth = countMicroFiberCloth - quantity;
				}
				else if (quantity > countCanned && quantity >= 0) {
					cout<<"Sorry, we don't have enough in stock";
					return 0;
				}
				else {
					cout<<"Invalid quantity!";
					return 0;
				}
				break;				
			}
			default: { //Invalid Product
				cout<<"We don't have that in the list!";
				return 0;
				break;
			}
		}
	}
	else { //Invalid Option
		cout<<"Invalid option!";
		return 0;
	}
	cout<<"\nDo you have a membership? (Y/N): ";
	cin>>membership;

	//Check for membership to apply discount
	if (membership == 'Y' || membership == 'y') { //Have Membership
		cout<<"\nThe total price of your puchased product was RM"<<totalCost<<endl; //Display initial total cost of product
		
		discount = totalCost * 0.1;
		totalCost = totalCost - discount;
		
		cout<<"You've gained a 10% discount thanks to your membership!"<<endl;
		cout<<"The total discounted from the original price is RM"<<discount<<endl; //Display discounted amount
		cout<<"\nThe total price is now RM"<<totalCost; //Display final total cost
	}
	else if (membership == 'N' || membership == 'n') { //No Membership
		cout<<"\nThe total price of your puchased product is RM"<<totalCost; //Display total cost
	}
	else { //Invalid membership status
		cout<<"Invalid status!";
		return 0;
	}						  		
}
