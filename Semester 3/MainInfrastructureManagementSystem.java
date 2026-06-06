import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;

class Node<E>
{
    E data;
    Node <E> next;
    
    public Node(E data)
    {
        this.data = data;
    }
}

class LinkedList<E> {
   
    private Node<E> head, current, tail;    
    
    public LinkedList() {
        head = current = tail = null;
    }
    
    public boolean isEmpty() {
        return head == null;
    }    
    
    public void addFirst(E data) {
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;          
        if(this.tail == null) {
            this.tail = this.head;
        }
    }
    
    public void addLast(E data) {
        Node newNode = new Node(data);
        
        if(this.tail == null) {
            this.head = this.tail = newNode;
        }
        else {
            this.tail.next = newNode;
            this.tail = this.tail.next;
        }       
    }
     
    public E getFirst() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            this.current = this.head;
            return this.current.data;
        }
    }
    
    public E getLast() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            return this.tail.data;
        }
    }
    
    public E getNext() {
        if (this.current == this.tail) {
            return null;
        }
        else {
            this.current = this.current.next;
            return this.current.data;
        }
    }

    public void clear() {
        this.head = this.current = this.tail = null;

    }

    public boolean contains(E data) {
        boolean isContain = false;
        this.current = this.head;
        
        while (this.current != null) {
            if (data.equals(this.current.data)) {
                isContain = true;
                break;
            }
        }
 
        return isContain;
    }

    public E removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            this.current = this.head;
            this.head = this.head.next;            
            if (this.head == null)
                this.tail = null;
            return current.data;
        }
    }
        
    public E removeLast() {
        if (this.isEmpty()) 
            return null;
        else if (this.head == this.tail) {
            this.current = this.head;
            this.head = this.tail = null;           
            return current.data;            
        }
        else {
            this.current = this.head;
            while (this.current.next != tail) {
                this.current = this.current.next;                
            }      
            Node<E> temp = this.tail;
            this.tail = this.current;
            this.tail.next = null;            
            return temp.data;
        }
    }
    
    public E removeAfter(E data) {        
        if (this.isEmpty()) {
            return null;
        }
        else if (this.head == this.tail) {
            this.current = this.head;
            this.head = this.tail = null;           
            return current.data;            

        }
        else {
            Node<E> previous = this.head;            
            while (previous.next != null) {
                if (data.equals(previous.data))
                {
                    break;
                }
                previous = previous.next;
            }            
            current = previous.next;
            previous.next = current.next;          
            return current.data;
        }
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder("[");        
        if (this.isEmpty()) {
            result.append("The list is empty]");
        }
        else {
            this.current = this.head;
            while (this.current != null) {
                result.append(this.current.data);
                this.current = this.current.next;
                if (this.current != null)
                    result.append(", ");
                else
                    result.append("]");                
            }            
        }
        return result.toString();
    }
}

class Queue <E> 
{
    private LinkedList <E> list;
    public Queue() {list = new LinkedList<E>();}
    
    public void enqueue(E data) {
        list.addLast(data);
    }
    
    public E dequeue() {
        return list.removeFirst();
    }
    
    public E getFront() {
        return list.getFirst();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

public class MainInfrastructureManagementSystem
{
    public static void main(String []a)
    {
        LinkedList electricalLL = new LinkedList();
        LinkedList roadLL = new LinkedList();
        LinkedList facLL = new LinkedList();
        LinkedList drainLL = new LinkedList();
        
        File electricalFile = new File("ElectricalData.txt");
        File roadFile = new File("RoadData.txt");
        File facFile = new File("FacilitiesData.txt");        
        File drainFile = new File("DrainageData.txt");
        
        Scanner scanner = new Scanner(System.in);
        
        boolean repeat = false;
        boolean again = false;
        boolean trueRepeat = false;
        boolean flag = false;
        
        char decide;
        
        //Insert data into Linked List
        try
        {
            Scanner inElectrical = new Scanner(electricalFile);
            Scanner inRoad = new Scanner(roadFile);
            Scanner inFac = new Scanner(facFile);
            Scanner inDrain = new Scanner(drainFile);
            
            while(inElectrical.hasNextLine())
            {
                String s = inElectrical.nextLine();
                String delimiter = ";";
                StringTokenizer st = new StringTokenizer(s, delimiter);
                
                String id = st.nextToken();
                String name = st.nextToken();
                String location = st.nextToken();
                String status = st.nextToken();
                int priority = Integer.parseInt(st.nextToken());
                
                Electrical electrical = new Electrical(id, name, location, status, priority);
                electricalLL.addLast(electrical);
            }
            
            while(inRoad.hasNextLine())
            {
                String s = inRoad.nextLine();
                String delimiter = ";";
                StringTokenizer st = new StringTokenizer(s, delimiter);
                
                String id = st.nextToken();
                String name = st.nextToken();
                String location = st.nextToken();
                String status = st.nextToken();
                int priority = Integer.parseInt(st.nextToken());
                
                Road road = new Road(id, name, location, status, priority);
                roadLL.addLast(road);
            }
            
            while(inFac.hasNextLine())
            {
                String s = inFac.nextLine();
                String delimiter = ";";
                StringTokenizer st = new StringTokenizer(s, delimiter);
                
                String id = st.nextToken();
                String name = st.nextToken();
                String location = st.nextToken();
                String status = st.nextToken();
                int priority = Integer.parseInt(st.nextToken());
                
                Facilities fac = new Facilities(id, name, location, status, priority);
                facLL.addLast(fac);
            }
            
            while(inDrain.hasNextLine())
            {
                String s = inDrain.nextLine();
                String delimiter = ";";
                StringTokenizer st = new StringTokenizer(s, delimiter);
                
                String id = st.nextToken();
                String name = st.nextToken();
                String location = st.nextToken();
                String status = st.nextToken();
                int priority = Integer.parseInt(st.nextToken());
                
                Drainage drain = new Drainage(id, name, location, status, priority);
                drainLL.addLast(drain);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        do
        {
            trueRepeat = false;
            
            //Process option
            System.out.println("What do you need? (1/2/3/4/5/6):");
            System.out.println("1. Add new infrastructure");
            System.out.println("2. View current infrastructure");
            System.out.println("3. View priority queue");
            System.out.println("4. Update existing infrastructure");
            System.out.println("5. Search for an infrastructure");
            System.out.println("6. Delete existing infrastructure");
            System.out.println("7. Exit");
            
            int choose = scanner.nextInt();
            
            do
            {
                again = false;
                if(choose == 1)
                {
                    //Add new data in linked list
                    System.out.println("Which infrastructure are you adding to? (1/2/3/4)");
                    System.out.println("1. Electrical");
                    System.out.println("2. Road");
                    System.out.println("3. Facilities");
                    System.out.println("4. Drainage");
                    
                    int add = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    if(add == 1)
                    {
                        do
                        {
                            repeat = false;
                            
                            System.out.println("Enter electrical ID:");
                            String elecID = scanner.nextLine();
                            
                            System.out.println("Enter electrical name:");
                            String elecName = scanner.nextLine();
                            
                            System.out.println("Enter electrical location:");
                            String elecLocation = scanner.nextLine();
                            
                            System.out.println("Enter electrical status (Normal/Minor Damage/Major Damage)");
                            String elecStatus = scanner.nextLine();
                             
                            System.out.println("Enter electrical priority (1 to 5);");
                            int elecPriority = scanner.nextInt();
                            
                            Electrical electrical = new Electrical(elecID, elecName, elecLocation, elecStatus, elecPriority);
                            
                            LinkedList tempElecLL = new LinkedList();
                            tempElecLL = electricalLL;
                            
                            Object obj = tempElecLL.getFirst();
                            
                            while(obj != null)
                            {
                                Electrical elec = (Electrical) obj;
                                
                                if(elec.getElectricalID().equals(electrical.getElectricalID()))
                                {
                                    System.out.println("Same ID cannot exist at the same time!");
                                    repeat = true;
                                    break;
                                }
                                else if(elec.getElectricalName().equals(electrical.getElectricalName()) && elec.getElectricalLocation().equals(electrical.getElectricalLocation()))
                                {
                                    System.out.println("Same name and location of this infrastructure has already been registered!");
                                    repeat = true;
                                    break;
                                }
                                
                                obj = tempElecLL.getNext();
                            }
                            
                            if(repeat == false)
                            {
                                electricalLL.addLast(electrical);
                            }
                            
                            scanner.nextLine();
                        }while(repeat == true);
                    }
                    
                
                    else if(add == 2)
                    {
                        do
                        {
                            repeat = false;
                            
                            System.out.println("Enter road ID:");
                            String roadID = scanner.nextLine();
                            
                            System.out.println("Enter road name:");
                            String roadName = scanner.nextLine();
                            
                            System.out.println("Enter road location:");
                            String roadLocation = scanner.nextLine();
                            
                            System.out.println("Enter road status (Normal/Minor Damage/Major Damage)");
                            String roadStatus = scanner.nextLine();
                             
                            System.out.println("Enter road priority (1 to 5);");
                            int roadPriority = scanner.nextInt();
                            
                            Road road = new Road(roadID, roadName, roadLocation, roadStatus, roadPriority);
                            
                            LinkedList tempRoadLL = new LinkedList();
                            tempRoadLL = roadLL;
                            
                            Object obj = tempRoadLL.getFirst();
                            
                            while(obj != null)
                            {
                                Road roads = (Road) obj;
                                
                                if(roads.getRoadID().equals(road.getRoadID()))
                                {
                                    System.out.println("Same ID cannot exist at the same time!");
                                    repeat = true;
                                    break;
                                }
                                else if(roads.getRoadName().equals(road.getRoadName()) && roads.getRoadLocation().equals(road.getRoadLocation()))
                                {
                                    System.out.println("Same name and location of this infrastructure has already been registered!");
                                    repeat = true;
                                    break;
                                }
                                
                                obj = tempRoadLL.getNext();
                            }
                            
                            if(repeat == false)
                            {
                                roadLL.addLast(road);
                            }
                            
                            scanner.nextLine();
                        }while(repeat == true);               
                    }
                    
                    
                    else if(add == 3)
                    {
                        do
                        {
                            repeat = false;
                            
                            System.out.println("Enter facility ID:");
                            String facID = scanner.nextLine();
                            
                            System.out.println("Enter facility name:");
                            String facName = scanner.nextLine();
                            
                            System.out.println("Enter facility location:");
                            String facLocation = scanner.nextLine();
                            
                            System.out.println("Enter facility status (Normal/Minor Damage/Major Damage):");
                            String facStatus = scanner.nextLine();
                             
                            System.out.println("Enter facility priority (1 to 5):");
                            int facPriority = scanner.nextInt();
                            
                            Facilities fac = new Facilities(facID, facName, facLocation, facStatus, facPriority);
                            
                            LinkedList tempFacLL = new LinkedList();
                            tempFacLL = facLL;
                            
                            Object obj = tempFacLL.getFirst();
                            
                            while(obj != null)
                            {
                                Facilities facility = (Facilities) obj;
                                
                                if(facility.getFacID().equals(fac.getFacID()))
                                {
                                    System.out.println("Same ID cannot exist at the same time!");
                                    repeat = true;
                                    break;
                                }
                                else if(facility.getFacName().equals(fac.getFacName()) && facility.getFacLocation().equals(fac.getFacLocation()))
                                {
                                    System.out.println("Same name and location of this infrastructure has already been registered!");
                                    repeat = true;
                                    break;
                                }
                                
                                obj = tempFacLL.getNext();
                            }
                            
                            if(repeat == false)
                            {
                                facLL.addLast(fac);
                            }
                            
                            scanner.nextLine();
                        }while(repeat == true);
                    }
                    
                    else if(add == 4)
                    {
                        do
                        {
                            repeat = false;
                            
                            System.out.println("Enter drainage ID:");
                            String drainID = scanner.nextLine();
                            
                            System.out.println("Enter drainage name:");
                            String drainName = scanner.nextLine();
                            
                            System.out.println("Enter drainage location:");
                            String drainLocation = scanner.nextLine();
                            
                            System.out.println("Enter drainage status (Normal/Minor Damage/Major Damage)");
                            String drainStatus = scanner.nextLine();
                             
                            System.out.println("Enter drainage priority (1 to 5);");
                            int drainPriority = scanner.nextInt();
                            
                            Drainage drain = new Drainage(drainID, drainName, drainLocation, drainStatus, drainPriority);
                            
                            LinkedList tempDrainLL = new LinkedList();
                            tempDrainLL = drainLL;
                            
                            Object obj = tempDrainLL.getFirst();
                            
                            while(obj != null)
                            {
                                Drainage drainage = (Drainage) obj;
                                
                                if(drainage.getDrainID().equals(drain.getDrainID()))
                                {
                                    System.out.println("Same ID cannot exist at the same time!");
                                    repeat = true;
                                    break;
                                }
                                else if(drainage.getDrainName().equals(drain.getDrainName()) && drainage.getDrainLocation().equals(drain.getDrainLocation()))
                                {
                                    System.out.println("Same name and location of this infrastructure has already been registered!");
                                    repeat = true;
                                    break;
                                }
                                
                                obj = tempDrainLL.getNext();
                            }
                            
                            if(repeat == false)
                            {
                                drainLL.addLast(drain);
                            }
                            
                            scanner.nextLine();
                        }while(repeat == true);          
                    }
                    else
                    {
                        System.out.println("Please choose a valid option!");
                        System.out.println("No infrastructure was added!");
                    }
                    
                    do
                    {
                        flag = false;
                        System.out.println("Do you want to add another infrastructure? (Y/N):");
                        decide = scanner.next().charAt(0);
                        
                        if(decide == 'y' || decide == 'Y')
                        {
                            again = true;
                        }
                        else if(decide == 'n' || decide == 'N')
                        {
                            again = false;
                            trueRepeat = true;
                        }
                        else
                        {
                            System.out.println("Please enter a valid character!");
                            flag = true;
                        }
                    }while(flag == true);
                }
                
                else if(choose == 2)
                {
                    //View current content of linked list
                    System.out.println("Which infrastructure are you viewing? (1/2/3/4):");
                    System.out.println("1. Electrical");
                    System.out.println("2. Road");
                    System.out.println("3. Facilities");
                    System.out.println("4. Drainage");
                    
                    int view = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(view == 1)
                    {
                        System.out.println("\nList of Electrical:");
                        System.out.println("=======================");
                        System.out.println(electricalLL.toString() + "\n");
                    }
                    else if(view == 2)
                    {
                        System.out.println("\nList of Road:");
                        System.out.println("=======================");
                        System.out.println(roadLL.toString() + "\n");
                    }
                    else if(view == 3)
                    {
                        System.out.println("\nList of Facilities:");
                        System.out.println("=======================");
                        System.out.println(facLL.toString() + "\n");
                    }
                    else if(view == 4)
                    {
                        System.out.println("\nList of Drainage:");
                        System.out.println("=======================");
                        System.out.println(drainLL.toString() + "\n");
                    }
                    
                    do
                    {
                        flag = false;
                        System.out.println("Would you like to view another infrastructure? (Y/N):");
                        decide = scanner.next().charAt(0);
                        
                        if(decide == 'y' || decide == 'Y')
                        {
                            again = true;
                        }
                        else if(decide == 'n' || decide == 'N')
                        {
                            again = false;
                            trueRepeat = true;
                        }
                        else
                        {
                            System.out.println("Please enter a valid character!");
                            flag = true;
                        }
                    }while(flag == true);
                }
                
                else if(choose == 3)
                {
                    //Create queue for prioritization
                    System.out.println("Which infrastructure do you want to see the priority queue of? (1/2/3/4):");
                    System.out.println("1. Electrical");
                    System.out.println("2. Road");
                    System.out.println("3. Facilities");
                    System.out.println("4. Drainage");
                    
                    int pQueue = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(pQueue == 1)
                    {
                        Queue elecQ = new Queue();
                        
                        for(int i = 5; i > 0; i--)
                        {
                            LinkedList tempElecLL = electricalLL;
                            Object obj = tempElecLL.getFirst();
                            
                            while(obj != null)
                            {
                                Electrical elec = (Electrical) obj;
                                
                                if(elec.getElectricalPriority() == i)
                                {
                                    elecQ.enqueue(elec);
                                }
                                
                                obj = tempElecLL.getNext();
                            }
                        }
                        
                        while(!elecQ.isEmpty())
                        {
                            Object obj = elecQ.dequeue();
                            Electrical elec = new Electrical();
                            elec = (Electrical) obj;
                            
                            System.out.println(elec.toString());
                        }
                    }
                    else if(pQueue == 2)
                    {
                        Queue roadQ = new Queue();
                        
                        for(int i = 5; i > 0; i--)
                        {
                            LinkedList tempRoadLL = roadLL;
                            Object obj = tempRoadLL.getFirst();
                            
                            while(obj != null)
                            {
                                Road road = (Road) obj;
                                
                                if(road.getRoadPriority() == i)
                                {
                                    roadQ.enqueue(road);
                                }
                                
                                obj = tempRoadLL.getNext();
                            }
                        }
                        
                        while(!roadQ.isEmpty())
                        {
                            Object obj = roadQ.dequeue();
                            Road road = new Road();
                            road = (Road) obj;
                            
                            System.out.println(road.toString());
                        }
                    }
                    else if(pQueue == 3)
                    {
                        Queue facQ = new Queue();
                        
                        for(int i = 5; i > 0; i--)
                        {
                            LinkedList tempFacLL = facLL;
                            Object obj = tempFacLL.getFirst();
                            
                            while(obj != null)
                            {
                                Facilities fac = (Facilities) obj;
                                
                                if(fac.getFacPriority() == i)
                                {
                                    facQ.enqueue(fac);
                                }
                                
                                obj = tempFacLL.getNext();
                            }
                        }
                        
                        while(!facQ.isEmpty())
                        {
                            Object obj = facQ.dequeue();
                            Facilities fac = new Facilities();
                            fac = (Facilities) obj;
                            
                            System.out.println(fac.toString());
                        }
                    }
                    else if(pQueue == 4)
                    {
                        Queue drainQ = new Queue();
                        
                        for(int i = 5; i > 0; i--)
                        {
                            LinkedList tempDrainLL = drainLL;
                            Object obj = tempDrainLL.getFirst();
                            
                            while(obj != null)
                            {
                                Drainage drain = (Drainage) obj;
                                
                                if(drain.getDrainPriority() == i)
                                {
                                    drainQ.enqueue(drain);
                                }
                                
                                obj = tempDrainLL.getNext();
                            }
                        }
                        
                        while(!drainQ.isEmpty())
                        {
                            Object obj = drainQ.dequeue();
                            Drainage drain = new Drainage();
                            drain = (Drainage) obj;
                            
                            System.out.println(drain.toString());
                        }
                    }
                    do
                    {
                        flag = false;
                        System.out.println("Would you like to view another priority queue? (Y/N):");
                        decide = scanner.next().charAt(0);
                        
                        if(decide == 'y' || decide == 'Y')
                        {
                            again = true;
                        }
                        else if(decide == 'n' || decide == 'N')
                        {
                            again = false;
                            trueRepeat = true;
                        }
                        else
                        {
                            System.out.println("Please enter a valid character!");
                            flag = true;
                        }
                    }while(flag == true);
                }
                else if(choose == 4)
                {
                    int point = 1;
                    int count = 1;
                    
                    System.out.println("Which infrastructure do you want to update? (1/2/3/4):");
                    System.out.println("1. Electrical");
                    System.out.println("2. Road");
                    System.out.println("3. Facilities");
                    System.out.println("4. Drainage");
                    
                    int upd = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(upd == 1)
                    {
                        System.out.println("Enter the ID of the electrical infrastructure that you want to update:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempElecLL = electricalLL;
                        LinkedList uElecLL = new LinkedList();
                        Object obj = tempElecLL.getFirst();
                        
                        while(obj != null)
                        {
                            Electrical elec = (Electrical) obj;
                            
                            if(!elec.getElectricalID().equals(id))
                            {
                                uElecLL.addLast(elec);
                            }
                            else
                            {
                                 System.out.println("Enter new electrical name:");
                                String elecName = scanner.nextLine();
                                
                                System.out.println("Enter new electrical location:");
                                String elecLocation = scanner.nextLine();
                                
                                System.out.println("Enter new electrical status (Normal/Minor Damage/Major Damage)");
                                String elecStatus = scanner.nextLine();
                                 
                                System.out.println("Enter new electrical priority (1 to 5);");
                                int elecPriority = scanner.nextInt();
                                
                                Electrical uElec = new Electrical(id, elecName, elecLocation, elecStatus, elecPriority);
                                uElecLL.addLast(uElec);
                            }
                            
                            obj = tempElecLL.getNext();
                        }
                        
                        electricalLL = uElecLL;
                        System.out.println("Successful update!");
                    }
                    else if(upd == 2)
                    {
                        System.out.println("Enter the ID of the road infrastructure you would like to update:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempRoadLL = roadLL;
                        LinkedList uRoadLL = new LinkedList();
                        Object obj = tempRoadLL.getFirst();
                        
                        while(obj != null)
                        {
                            Road road = (Road) obj;
                            
                            if(!road.getRoadID().equals(id))
                            {
                                uRoadLL.addLast(road);
                            }
                            else
                            {
                                System.out.println("Enter new road name:");
                                String roadName = scanner.nextLine();
                                
                                System.out.println("Enter new road location:");
                                String roadLocation = scanner.nextLine();
                                
                                System.out.println("Enter new road status (Normal/Minor Damage/Major Damage)");
                                String roadStatus = scanner.nextLine();
                                 
                                System.out.println("Enter new road priority (1 to 5);");
                                int roadPriority = scanner.nextInt();
                                
                                Road uRoad = new Road(id, roadName, roadLocation, roadStatus, roadPriority);
                                uRoadLL.addLast(uRoad);
                            }
                            
                            obj = tempRoadLL.getNext();
                        }
                        roadLL = uRoadLL;
                        System.out.println("Successful update!");
                    }
                    else if(upd == 3)
                    {
                        System.out.println("Enter the ID of the facility infrastructure you would like to update:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempFacLL = facLL;
                        LinkedList uFacLL = new LinkedList();
                        Object obj = tempFacLL.getFirst();
                        
                        while(obj != null)
                        {
                            Facilities fac = (Facilities) obj;
                            
                            if(!fac.getFacID().equals(id))
                            {
                                uFacLL.addLast(fac);
                            }
                            else
                            {
                                System.out.println("Enter new facility name:");
                                String facName = scanner.nextLine();
                                
                                System.out.println("Enter new facility location:");
                                String facLocation = scanner.nextLine();
                                
                                System.out.println("Enter new facility status (Normal/Minor Damage/Major Damage)");
                                String facStatus = scanner.nextLine();
                                 
                                System.out.println("Enter new facility priority (1 to 5);");
                                int facPriority = scanner.nextInt();
                                
                                Facilities uFac = new Facilities(id, facName, facLocation, facStatus, facPriority);
                                uFacLL.addLast(uFac);
                            }
                            
                            obj = tempFacLL.getNext();
                        }
                        facLL = uFacLL;
                        System.out.println("Successful update!");
                    }
                    else if(upd == 4)
                    {
                        System.out.println("Enter the ID of the drainage infrastructure you would like to update:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempDrainLL = drainLL;
                        LinkedList uDrainLL = new LinkedList();
                        Object obj = tempDrainLL.getFirst();
                        
                        while(obj != null)
                        {
                            Drainage drain = (Drainage) obj;
                            
                            if(!drain.getDrainID().equals(id))
                            {
                                uDrainLL.addLast(drain);
                            }
                            else
                            {
                                System.out.println("Enter new drain name:");
                                String drainName = scanner.nextLine();
                                
                                System.out.println("Enter new drain location:");
                                String drainLocation = scanner.nextLine();
                                
                                System.out.println("Enter new drain status (Normal/Minor Damage/Major Damage)");
                                String drainStatus = scanner.nextLine();
                                 
                                System.out.println("Enter new drain priority (1 to 5);");
                                int drainPriority = scanner.nextInt();
                                
                                Drainage uDrain = new Drainage(id, drainName, drainLocation, drainStatus, drainPriority);
                                uDrainLL.addLast(uDrain);
                            }
                            
                            obj = tempDrainLL.getNext();
                        }
                        drainLL = uDrainLL;
                        System.out.println("Successful update!");
                    }
                    
                    do
                    {
                        flag = false;
                        System.out.println("Would you like to update another infrastructure? (Y/N):");
                        decide = scanner.next().charAt(0);
                        
                        if(decide == 'y' || decide == 'Y')
                        {
                            again = true;
                        }
                        else if(decide == 'n' || decide == 'N')
                        {
                            again = false;
                            trueRepeat = true;
                        }
                        else
                        {
                            System.out.println("Please enter a valid character!");
                            flag = true;
                        }
                    }while(flag == true);
                }
                else if(choose == 5)
                {
                    System.out.println("What type infrastructure of are you searching? (1/2/3/4):");
                    System.out.println("1. Electrical");
                    System.out.println("2. Road");
                    System.out.println("3. Facilities");
                    System.out.println("4. Drainage");
                    
                    int search = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(search == 1)
                    {
                        System.out.println("Enter the ID of the electrical infrastructure that you want to find:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempElecLL = electricalLL;
                        Object obj = tempElecLL.getFirst();
                        
                        while(obj != null)
                        {
                            Electrical elec = (Electrical) obj;
                            
                            if(elec.getElectricalID().equals(id))
                            {
                                System.out.println("Here's the info of electrical infrastructure with an ID of " + id + ":");
                                System.out.print(elec.toString());
                            }
                            
                            obj = tempElecLL.getNext();
                        }
                    }
                    else if(search == 2)
                    {
                        System.out.println("Enter the ID of the road infrastructure that you want to find:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempRoadLL = roadLL;
                        Object obj = tempRoadLL.getFirst();
                        
                        while(obj != null)
                        {
                            Road road = (Road) obj;
                            
                            if(road.getRoadID().equals(id))
                            {
                                System.out.println("Here's the info of road infrastructure with an ID of " + id + ":");
                                System.out.print(road.toString());
                            }
                            
                            obj = tempRoadLL.getNext();
                        }
                    }
                    else if(search == 3)
                    {
                        System.out.println("Enter the ID of the facility infrastructure that you want to find:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempFacLL = facLL;
                        Object obj = tempFacLL.getFirst();
                        
                        while(obj != null)
                        {
                            Facilities fac = (Facilities) obj;
                            
                            if(fac.getFacID().equals(id))
                            {
                                System.out.println("Here's the info of facility infrastructure with an ID of " + id + ":");
                                System.out.print(fac.toString());
                            }
                            
                            obj = tempFacLL.getNext();
                        }
                    }
                    else if(search == 4)
                    {
                        System.out.println("Enter the ID of the drainage infrastructure that you want to find:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempDrainLL = drainLL;
                        Object obj = tempDrainLL.getFirst();
                        
                        while(obj != null)
                        {
                            Drainage drain = (Drainage) obj;
                            
                            if(drain.getDrainID().equals(id))
                            {
                                System.out.println("Here's the info of drainage infrastructure with an ID of " + id + ":");
                                System.out.print(drain.toString());
                            }
                            
                            obj = tempDrainLL.getNext();
                        }
                    }
                    
                    do
                    {
                        flag = false;
                        System.out.println("\nWould you like to search another infrastructure? (Y/N):");
                        decide = scanner.next().charAt(0);
                        
                        if(decide == 'y' || decide == 'Y')
                        {
                            again = true;
                        }
                        else if(decide == 'n' || decide == 'N')
                        {
                            again = false;
                            trueRepeat = true;
                        }
                        else
                        {
                            System.out.println("Please enter a valid character!");
                            flag = true;
                        }
                    }while(flag == true);
                }
                else if(choose == 6)
                {
                    System.out.println("What type of infrastructure are you deleting? (1/2/3/4):");
                    System.out.println("1. Electrical");
                    System.out.println("2. Road");
                    System.out.println("3. Facilities");
                    System.out.println("4. Drainage");
                    
                    int delete = scanner.nextInt();
                    scanner.nextLine();
                    
                    if(delete == 1)
                    {
                        System.out.println("Enter the ID of the electrical infrastructure that you want to delete:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempElecLL = electricalLL;
                        LinkedList dElecLL = new LinkedList();
                        Object obj = tempElecLL.getFirst();
                        
                        while(obj != null)
                        {
                            Electrical elec = (Electrical) obj;
                            
                            if(!elec.getElectricalID().equals(id))
                            {
                                dElecLL.addLast(elec);
                            }
                            
                            obj = tempElecLL.getNext();
                        }
                        
                        electricalLL = dElecLL;
                        System.out.println("Successful deletion!");
                    }
                    else if(delete == 2)
                    {
                        System.out.println("Enter the ID of the road infrastructure that you want to delete:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempRoadLL = roadLL;
                        LinkedList dRoadLL = new LinkedList();
                        Object obj = tempRoadLL.getFirst();
                        
                        while(obj != null)
                        {
                            Road road = (Road) obj;
                            
                            if(!road.getRoadID().equals(id))
                            {
                                dRoadLL.addLast(road);
                            }
                            
                            obj = tempRoadLL.getNext();
                        }
                        
                        roadLL = dRoadLL;
                        System.out.println("Successful deletion!");
                    }
                    else if(delete == 3)
                    {
                        System.out.println("Enter the ID of the facility infrastructure that you want to delete:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempFacLL = facLL;
                        LinkedList dFacLL = new LinkedList();
                        Object obj = tempFacLL.getFirst();
                        
                        while(obj != null)
                        {
                            Facilities fac = (Facilities) obj;
                            
                            if(!fac.getFacID().equals(id))
                            {
                                dFacLL.addLast(fac);
                            }
                            
                            obj = tempFacLL.getNext();
                        }
                        
                        facLL = dFacLL;
                        System.out.println("Successful deletion!");
                    }
                    else if(delete == 4)
                    {
                        System.out.println("Enter the ID of the drainage infrastructure that you want to delete:");
                        String id = scanner.nextLine();
                        
                        LinkedList tempDrainLL = drainLL;
                        LinkedList dDrainLL = new LinkedList();
                        Object obj = tempDrainLL.getFirst();
                        
                        while(obj != null)
                        {
                            Drainage drain = (Drainage) obj;
                            
                            if(!drain.getDrainID().equals(id))
                            {
                                dDrainLL.addLast(drain);
                            }
                            
                            obj = tempDrainLL.getNext();
                        }
                        
                        drainLL = dDrainLL;
                        System.out.println("Successful deletion!");
                    }
                    
                    do
                    {
                        flag = false;
                        System.out.println("Would you like to delete another infrastructure? (Y/N):");
                        decide = scanner.next().charAt(0);
                        
                        if(decide == 'y' || decide == 'Y')
                        {
                            again = true;
                        }
                        else if(decide == 'n' || decide == 'N')
                        {
                            again = false;
                            trueRepeat = true;
                        }
                        else
                        {
                            System.out.println("Please enter a valid character!");
                            flag = true;
                        }
                    }while(flag == true);
                }
                else if(choose == 7)
                {
                    scanner.close();
                }
                else
                {
                    System.out.println("Please choose a valid option!");
                    again = false;
                    trueRepeat = true;
                }
            }while(again == true);
        }while(trueRepeat == true);
    }
}