// Name: Saif A
// Date: 2019-11-20
// File Name: LinkedList 

// Linked List
public class LinkedList {
  int n;
  LinkedList pointer;
  
  public LinkedList() { 
    n = 0; 
    pointer = null;
  } // constructor
  
  public LinkedList(int y) { 
    n = y;
    pointer = null;
  } //constructor2
  
  public void add (int x) {  // adds (to the end) new element to linked list
    LinkedList newNode = new LinkedList();
    newNode.n = x;    // creates new item for the list
    LinkedList temp = this; // the list
    while (temp.pointer != null) {  // get to last item
      temp = temp.pointer;
    }  // temp now the last item in linked list
    temp.pointer = newNode;  // point the last item to the new item
  } // add
  
  public void Insert (int data, int index){
    LinkedList temp = this;
    if (index!=0){ // Run the following code if the user wants to insert a node not in index 0
    try{
      index = index-1; // Do this so that we insert the node in the correct index not 1 index after
      LinkedList node = new LinkedList();
      node.n = data; // set the node data equal to the parameter  
      int correctIndex = 0; // Varriable used to find the correct index 
      // loop until correct index, setting temp equal to that node 
      while (correctIndex != index){ 
        temp = temp.pointer;
        correctIndex ++;}
      node.pointer = temp.pointer; //Set the new pointer to the next node
      temp.pointer = node; // 
      }
    catch (Exception e){
      System.out.println("Invalid item");}
   }
    else{
      try{
        int tempValue = this.n; //tempValue now holds the value of first node 
        LinkedList newNode = new LinkedList(tempValue); //creates linked list from stored variable
        this.n = data; //changes the data value of first node to the user input
        newNode.pointer = this.pointer; //changes pointer of temp linked list to pointer of existing linked list
        this.pointer = newNode; //changes pointer of existing linked list to newly created linked list
      }
     catch (Exception e){
      System.out.println("Invalid item");}
    }
    
  }
  
   public void remove (int index) { //remove meathod 
    try {
      LinkedList temp = this; 
      int correctIndex = 0;
      while (correctIndex != index-1) { // loop until 1 index before 
        temp = temp.pointer;
        correctIndex++;
      }
      temp.pointer = temp.pointer.pointer; //change pointer to 2 indexs after, that way it dosen't go to the middle index  
    } catch (Exception e) {
      System.out.println("Error");
    }
  }

  public int Length(){
    LinkedList temp = this;
    int length = 0;
    while (temp.pointer != null){ 
      temp = temp.pointer;
      length ++;
    }
    return length;
  }
  
  
  public void display() {
    LinkedList temp = this;
    System.out.println(temp.n);
    while (temp.pointer != null) {      
      temp = temp.pointer;
      System.out.println(temp.n);    }
  } // display
  
} //class