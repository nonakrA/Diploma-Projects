#include <iostream>
#include <string.h>

using namespace std;

int userInterface();
int chooseLocation(int &, int, int &, int &, int &);
bool checkInvalidLocation(int);
void locationCounter(int, int &, int &, int &);
bool confirmation();


int main()
{
	int userLocation[10], userParking[10], userReservedHour[10];
	int location = 0, totalLocation1 = 0, totalLocation2 = 0, totalLocation3 = 0, user, parkingNum, adminOption, totalUser = 0, nameLength, hourStatus, totalProfit = 0;
	double reserveHour;
	double totalCost[10];
	char userName[10][50], parkingSlot1[15] = {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, parkingSlot2[10] = {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, parkingSlot3[12] = {'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'}, userVehicleType[10][20], userStatus[10][10];
	char name[50], vehicleType, extraNecessities, carCharger, status, finalOption;
	bool invalid, rerun;
	
	do
	{
		rerun = false;
		user = userInterface();
		
		if (user == 1)
		{
			for (int i = 0; i < 10; i++)
			{
				if (totalUser > 0)
				{
					i = totalUser;
				}
				totalCost[i] = 0;
				
				do
				{
					cout<<"Enter your name: ";
					cin.ignore();
					cin.getline(name, 49);
					strcpy(userName[i], name);
					cout<<"Is your name "<<userName[i]<<"? (Y/N): ";
					invalid = confirmation();
				}while (invalid == true);
				userLocation[i] = chooseLocation(location, i, totalLocation1, totalLocation2, totalLocation3);
				
				if (location == 1)
				{
					cout<<"Overview for available parking in AEON Supermarket"<<endl;
					cout<<"+-----------------------------------------------------------------+"<<endl;
					cout<<"|                                                                 |"<<endl;
					cout<<"| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 14 | 15 |"<<endl;
					cout<<"| ";
					for (int totalParking = 0; totalParking < 15; totalParking++)
					{
						if (totalParking >= 9)
						{
							cout<<parkingSlot1[totalParking]<<"  | ";
						}
						else
						{
							cout<<parkingSlot1[totalParking]<<" | ";
						}
					}
					cout<<"\n+-----------------------------------------------------------------+"<<endl;
					cout<<"Each parking spot has a fixed price of RM5.00 for reservation."<<endl;
					
					do
					{
						do
						{
							invalid = false;
							
							cout<<"Enter a parking number: ";
							cin>>parkingNum;
							
							if (parkingNum <= 0 || parkingNum > 15)
							{
								cout<<"Invalid parking number!"<<endl;
								invalid = true;
							}
							else if (parkingSlot1[parkingNum - 1] == 'Y')
							{
								cout<<"That parking number is taken!"<<endl;
								invalid = true;
							}
						}while (invalid == true);
						
						cout<<"Are you sure that you want to choose parking number "<<parkingNum<<"? (Y/N): ";
						invalid = confirmation();
						
					}while (invalid == true);
					
					parkingSlot1[parkingNum - 1] = 'Y';
				}
				else if (location == 2)
				{
					cout<<"Overview for available parking in Lotus Supermarket"<<endl;
					cout<<"+----------------------------------------+"<<endl;
					cout<<"|                                        |"<<endl;
					cout<<"| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |"<<endl;
					cout<<"| ";
					for (int totalParking = 0; totalParking < 10; totalParking++)
					{
						if (totalParking >= 9)
						{
							cout<<parkingSlot2[totalParking]<<"  | ";
						}
						else
						{
							cout<<parkingSlot2[totalParking]<<" | ";
						}
					}
					cout<<"\n+----------------------------------------+"<<endl;
					cout<<"Each parking spot has a fixed price of RM5.00 for reservation."<<endl;
					
					do
					{
						do
						{
							invalid = false;
							
							cout<<"Enter a parking number: ";
							cin>>parkingNum;
							
							if (parkingNum <= 0 || parkingNum > 15)
							{
								cout<<"Invalid parking number!"<<endl;
								invalid = true;
							}
							else if (parkingSlot2[parkingNum - 1] == 'Y')
							{
								cout<<"That parking number is taken!"<<endl;
								invalid = true;
							}
						}while (invalid == true);
						
						cout<<"Are you sure that you want to choose parking number "<<parkingNum<<"? (Y/N): ";
						invalid = confirmation();
						
					}while (invalid == true);
					
					parkingSlot2[parkingNum - 1] = 'Y';
				}
				else if (location == 3)
				{
					cout<<"Overview for available parking in Billion Supermarket"<<endl;
					cout<<"+--------------------------------------------------+"<<endl;
					cout<<"|                                                  |"<<endl;
					cout<<"| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |"<<endl;
					cout<<"| ";
					for (int totalParking = 0; totalParking < 12; totalParking++)
					{
						if (totalParking >= 9)
						{
							cout<<parkingSlot3[totalParking]<<"  | ";
						}
						else
						{
							cout<<parkingSlot3[totalParking]<<" | ";
						}
					}
					cout<<"\n+--------------------------------------------------+"<<endl;
					cout<<"Each parking spot has a fixed price of RM5.00 for reservation."<<endl;
					
					do
					{
						do
						{
							invalid = false;
							
							cout<<"Enter a parking number: ";
							cin>>parkingNum;
							
							if (parkingNum <= 0 || parkingNum > 15)
							{
								cout<<"Invalid parking number!"<<endl;
								invalid = true;
							}
							else if (parkingSlot3[parkingNum - 1] == 'Y')
							{
								cout<<"That parking number is taken!"<<endl;
								invalid = true;
							}
						}while (invalid == true);
						
						cout<<"Are you sure that you want to choose parking number "<<parkingNum<<"? (Y/N): ";
						invalid = confirmation();
						
					}while (invalid == true);
					
					parkingSlot3[parkingNum - 1] = 'Y';
				}
				userParking[i] = parkingNum;
				totalCost[i] = totalCost[i] + 5.00;
				
				do
				{
					invalid = false;
				
					cout<<"What type of vehicle are you using? (C-Cars, M-Motorcycle): ";
					cin>>vehicleType;
				
					if (vehicleType == 'C' || vehicleType == 'c')
					{
						strcpy(userVehicleType[i], "Car");
					}
					else if (vehicleType == 'M' || vehicleType == 'm')
					{
						strcpy(userVehicleType[i], "Motorcycle");
					}
					else
					{
						cout<<"Invalid vehicle code type!"<<endl;
						invalid = true;
					}
				}while (invalid == true);
					
				do
				{
					invalid = false;
				
					cout<<"is your "<<userVehicleType[i]<<" electrical? (Y/N): ";
					cin>>extraNecessities;
						
					if (extraNecessities == 'Y' || extraNecessities == 'y')
					{
						cout<<"A charger would add RM30 to your total cost."<<endl;
				
						do
						{	
							cout<<"Would you like to have a charger at your parking location? (Y/N): ";												
							cin>>carCharger;
							
							if (carCharger == 'Y' || carCharger == 'y')
							{
								cout<<"Are you sure that you want to add a charger? (Y/N): ";
								invalid = confirmation();
								
								if (invalid == false)
								{
									totalCost[i] = totalCost[i] + 30.00;
								}
							}
							else if (carCharger == 'N' || carCharger == 'n')
							{
								invalid = false;
							}
							else
							{
								cout<<"Invalid input!"<<endl;
								invalid = true;
							}
						}while (invalid == true);						
					}
					else if (extraNecessities == 'N' || extraNecessities == 'n')
					{
						invalid = false;
					}
					else
					{
						cout<<"Invalid input!"<<endl;
						invalid = true;
					}
				}while (invalid == true);
				
				cout<<"The rate is RM2.00 per hour of reservation"<<endl;
				do
				{
					do
					{
						invalid = false;
						
						cout<<"How long are you reserving the parking for? (Must be at least 1 hour): ";
						cin>>reserveHour;
						
						if (reserveHour <= 0)
						{
							cout<<"Invalid hour!";
							invalid = true;
						}
					}while (invalid == true);
					
					cout<<"Are you sure that you are reserving for "<<reserveHour<<" hours? (Y/N): ";
					invalid = confirmation();
				}while (invalid == true);
				
				userReservedHour[i] = reserveHour;
				totalCost[i] = totalCost[i] + (reserveHour * 2.00);
				
				cout<<"Are you an OKU driver? (Y/N): ";
				cin>>status;
				
				do
				{
					if (status == 'Y' || status == 'y')
					{
						strcpy(userStatus[i], "OKU");
						
						cout<<"Would you like to apply a discount of 10%? (Y/N): ";
						invalid = confirmation();
							
						if (invalid == false)
						{
							totalCost[i] = totalCost[i] * 0.9;
						}
						invalid = false;
					}
					else if (status == 'N' || status == 'n')
					{
						strcpy(userStatus[i], "Non-OKU");
					}
					else
					{
						cout<<"Invalid status!";
						invalid = true;
					}
				}while (invalid == true);
				
				cout<<"\n**********INVOICE**********"<<endl;
				cout<<"Location Code : "<<userLocation[i]<<endl;
				cout<<"Parking Number: "<<userParking[i]<<endl;
				cout<<"Vehicle Type  : "<<userVehicleType[i]<<endl;
				cout<<"Driver Status : "<<userStatus[i]<<endl;
				cout<<"Park duration : "<<userReservedHour[i]<<endl;
				cout<<"Total Cost    : RM"<<totalCost[i]<<endl;
				cout<<"**********INVOICE**********"<<endl;
				
				totalUser++;
				cout<<"Would you like to return to the main menu, rerun the customer program or exit the app? (M-Main menu, R-rerun the program, E-Exit): ";
				cin>>finalOption;
				
				if (finalOption == 'M' || finalOption == 'm')
				{
					rerun = true;
					break;
				}
				else if (finalOption == 'R' || finalOption == 'r')
				{
					continue;
				}
				else if (finalOption == 'E' || finalOption == 'e')
				{
					cout<<"Thank you for using our Parking Lot Management System!";
					return 0;
				}
			}
		}
		else
		{
			cout<<"+---------------------+"<<endl;
			cout<<"| ADMINISTRATOR PANEL |"<<endl;
			cout<<"|                     |"<<endl;
			cout<<"| 1. User Info        |"<<endl;
			cout<<"| 2. Total Profit     |"<<endl;
			cout<<"+---------------------+"<<endl;
			cout<<"Select an option(1/2): ";
			do
			{
				invalid = false;
				cin>>adminOption;
				if (adminOption != 1 && adminOption != 2)
				{
					cout<<"Invalid option!";
					invalid = true;
				}
			}while (invalid == true);
			
			if (adminOption == 1)
			{
				cout<<"+-----------------------------------------------------------------------------------------------------------+"<<endl;
				cout<<"|                                            USER INFORMATION                                               |"<<endl;
				cout<<"+-----------------------------------------------------------------------------------------------------------+"<<endl;
				cout<<"|                         User                         | Location | Parking |  Vehicle  | Driver | Park     |"<<endl;
				cout<<"|                         Name                         |   Code   | Number  |  Type     | Status | Time (H) |"<<endl;
				cout<<"+-----------------------------------------------------------------------------------------------------------+"<<endl;
				if (totalUser != 0)
				{
					for (int i = 0; i < totalUser; i++)
					{
						cout<<"| ";
						cout<<i + 1<<". "<<userName[i];
						nameLength = strlen(userName[i]);
						for (int nameBorder = 50; nameLength < nameBorder; nameLength++)
						{
							cout<<" ";
						}
						cout<<"|     "<<userLocation[i]<<"    |";
						parkingNum = userParking[i];
						if (parkingNum < 10)
						{
							cout<<"    "<<userParking[i]<<"    |";
						}
						else
						{
							cout<<"    "<<userParking[i]<<"   |";
						}
						if (strcmp(userVehicleType[i], "Car") == 0)
						{
							cout<<"    "<<userVehicleType[i]<<"    |";
						}
						else if (strcmp(userVehicleType[i], "Motorcycle") == 0)
						{
							cout<<userVehicleType[i]<<" |";
						}
						if (strcmp(userStatus[i], "OKU") == 0)
						{
							cout<<userStatus[i]<<"     |";
						}
						else
						{
							cout<<userStatus[i]<<" |";
						}
						hourStatus = userReservedHour[i];
						cout<<"    ";
						if (hourStatus < 10)
						{
							cout<<userReservedHour[i]<<"     |"<<endl;
						}
						else if (hourStatus > 9 && hourStatus < 100)
						{
							cout<<userReservedHour[i]<<"    |"<<endl;
						}
						else
						{
							cout<<userReservedHour[i]<<"   |"<<endl;
						}	
						cout<<"+-----------------------------------------------------------------------------------------------------------+"<<endl;
					}				
				}
				else
				{
					cout<<"There's no user yet!"<<endl;
				}			
			}
			else if (adminOption == 2)
			{
				cout<<"+--------------------------------------+"<<endl;
				cout<<"|             TOTAL PROFIT             |"<<endl;
				cout<<"|--------------------------------------|"<<endl;
				cout<<"| Customer in AEON Supermarket   : ";
				if (totalLocation1 > 9)
				{
					cout<<totalLocation1<<"  |"<<endl;
				}
				else
				{
					cout<<totalLocation1<<"   |"<<endl;
				}
				cout<<"| Customer in Lotus Supermarket  : ";
				if (totalLocation2 > 9)
				{
					cout<<totalLocation2<<"  |"<<endl;
				}
				else
				{
					cout<<totalLocation2<<"   |"<<endl;
				}
				cout<<"| Customer in Billion Supermarket: ";
				if (totalLocation3 > 9)
				{
					cout<<totalLocation3<<"  |"<<endl;
				}
				else
				{
					cout<<totalLocation3<<"   |"<<endl;
				}
				cout<<"|--------------------------------------|"<<endl;
				if (totalUser == 0)
				{
					cout<<"| Total Profit : RM0                   |"<<endl;
				}
				else
				{
					totalProfit = 0;
					for (int addProfit = 0; addProfit < totalUser; addProfit++)
					{
						totalProfit = totalProfit + totalCost[addProfit];
					}
					if (totalProfit < 10 )
					{
						cout<<"| Total Profit : RM"<<totalProfit<<"                   |";
					}
					else if (totalProfit >= 10 && totalProfit < 100)
					{
						cout<<"| Total Profit : RM"<<totalProfit<<"                  |"<<endl;
					}
					else if (totalProfit >= 100 && totalProfit < 1000)
					{
						cout<<"| Total Profit : RM"<<totalProfit<<"                 |"<<endl;
					}
					else if (totalProfit >= 1000 && totalProfit < 10000)
					{
						cout<<"| Total Profit : RM"<<totalProfit<<"                |"<<endl;
					}
					else if (totalProfit >= 10000 && totalProfit < 100000)
					{
						cout<<"| Total Profit : RM"<<totalProfit<<"               |"<<endl;
					}
				}
				cout<<"+--------------------------------------+"<<endl;
			}
			
			do
			{
				invalid = false;
				cout<<"Enter 'M' to return to main menu or 'E' to exit: ";
				cin>>finalOption;
				
				if (finalOption == 'M' || finalOption == 'm')
				{
					rerun = true;
				}
				else if (finalOption == 'E' || finalOption == 'e')
				{
					return 0;
				}
				else
				{
					cout<<"Invalid input!";
					invalid = true;
				}
			}while (invalid == true);
		}
	}while (rerun == true);
}



int userInterface()
{
	int user;
	bool invalid;
	
	cout<<"+----------------------------+"<<endl;
	cout<<"| CAR PARK MANAGEMENT SYSTEM |"<<endl;
	cout<<"|                            |"<<endl;
	cout<<"| 1. CUSTOMER                |"<<endl;
	cout<<"| 2. ADMINISTRATOR           |"<<endl;
	cout<<"+----------------------------+"<<endl;
	cout<<"Select an option(1/2): ";
	
	do
	{
		invalid = false;
		cin>>user;
	
		if (user != 1 && user != 2)
		{
			cout<<"Invalid Option!"<<endl;
			invalid = true;
		}
	}while (invalid == true);

	return user;
}

int chooseLocation(int &location, int i, int &totalLocation1, int &totalLocation2, int &totalLocation3)
{
	bool invalid, repeat;
	
	cout<<"Welcome! Here's a list of available parking area:"<<endl;
	cout<<"1. AEON Supermarket"<<endl;
	cout<<"2. Lotus Supermarket"<<endl;
	cout<<"3. Billion Supermarket"<<endl; 
		
	do
	{	
		do
		{
			cout<<"Enter your desired location (1/2/3): ";
			cin>>location;
			invalid = checkInvalidLocation(location);	
		}while (invalid == true);
		
		cout<<"Are you sure you want to choose location "<<location<<"? (Y/N): ";
		repeat = confirmation();
		
	}while (repeat == true);
	
	locationCounter(location, totalLocation1, totalLocation2, totalLocation3);
	cout<<"X - Parking is available | Y - Parking is occupied"<<endl;
	return location;
}

bool checkInvalidLocation(int location)
{
	bool invalid;
	
	if (location == 1 || location == 2 || location == 3)
	{
		invalid = false;
	}
	else
	{
		cout<<"Invalid location!"<<endl;
		invalid = true;
	}
	
	return invalid;
}

bool confirmation()
{
	char confirm;
	bool repeat, invalid;
	
	do
	{
		invalid = false;
		cin>>confirm;
	
		if (confirm == 'Y'|| confirm == 'y')
		{
			repeat = false;
		}
		else if (confirm == 'N' || confirm == 'n')
		{
			repeat = true;
		}
		else 
		{
			cout<<"Invalid input!"<<endl;
			invalid = true;
		}
	}while (invalid == true);
	
	return repeat;
}

void locationCounter(int location, int &totalLocation1, int &totalLocation2, int &totalLocation3)
{
	if (location == 1)
	{
		totalLocation1++;
	}
	else if (location == 2)
	{
		totalLocation2++;
	}
	else if (location == 3)
	{
		totalLocation3++;
	}	
}

