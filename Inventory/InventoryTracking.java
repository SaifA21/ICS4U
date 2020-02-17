//Name: Saif A
//Class: ICS 4U
//Date: 2019-11-11

import java.util.*;
import java.io.*;

// Define class
public class InventoryTracking{
  
// Create an string input method
  public static String StringInput() {
    Scanner input = new Scanner(System.in); 
    String stringInput = input.nextLine(); 
    return stringInput;
  } 
  //Create an integer input method
  public static int IntInput (){
  Scanner intInput = new Scanner(System.in); 
  int int_input = intInput.nextInt(); 
  return int_input;
  } 
  
    
  // Defining the "main" meathod 
  public static void main (String[] args){
    ArrayList<Product> listOfProducts = new ArrayList<Product>(); // ArrayList of Products which will need to be used by all methods
    // Manually adding products because read/write function not compiling  
    
    // Reading file
    
    try{
      FileInputStream fis = new FileInputStream("products");
      ObjectInputStream ois = new ObjectInputStream(fis);
      
      listOfProducts = (ArrayList) ois.readObject();
      
      ois.close();
      fis.close();
    }
    catch(IOException ioe){
      ioe.printStackTrace();
      return;
    }
    catch (ClassNotFoundException c){
      System.out.println("File could not be loaded");
      c.printStackTrace();
      return;
    }

    Product addProduct1 = new Product ("Pen1","pen001","Blue Pen",0,0);
    Product addProduct2 = new Product ("Pen2","pen002","Red Pen",10,1);
    Product addProduct3 = new Product ("Pen3","pen003","Green Pen",2,1);
    Product addProduct4 = new Product ("Apple","apple001","Red Apple",100,40);
    Product addProduct5 = new Product ("Apple2","apple002","Green Apple",59,2);
    listOfProducts.add(addProduct1);
    listOfProducts.add(addProduct2);
    listOfProducts.add(addProduct3);
    listOfProducts.add(addProduct4);
    listOfProducts.add(addProduct5);
    
    
    Scanner input = new Scanner(System.in); // Object "input" is an instance of the Scanner Class   
    boolean mainLoop = true;
      while (mainLoop){ 
        try{
          System.out.println("Welcome to the Inventory Tracking Program");
          System.out.println("");
          System.out.println ("Please choose one of the options below:");
          System.out.println("1) List current inventory - lists all the products in inventory with qty in stock.");
          System.out.println("2) List product detail - list all details of products.");
          System.out.println("3) Add new product - adds a new product to the inventory list.");
          System.out.println("4) Remove product from inventory - removes a product from inventory.");
          System.out.println("5) Edit product - edit the details of a product.");
          System.out.println("6) List of all products that have a quantity of 10 or less in inventory.");
          System.out.println("7) Search - List of all products containing a key word.");
          System.out.println("8) Save changes - save the current inventory list to txt file.");
          System.out.println("9) Quit - quit program (automatically saves changes)");
          System.out.println("Enter menu option");  
          String selection = StringInput();  
  
          // Current Inventory
          if (selection.equals ("1")){
            int size = listOfProducts.size();
            for (int length = 0; length<size ; length ++){
            System.out.println("Name: " + listOfProducts.get(length).getName() + " Stock Level: " + listOfProducts.get(length).getQuantityInStock());
            }
          }// End of Current Inventory 
          
          // Displays all all details about products
          else if (selection.equals ("2")){
            int sizeDisplay = listOfProducts.size();
            for (int loop = 0; loop<sizeDisplay ; loop++){
              String qStockString = String.valueOf( listOfProducts.get(loop).getQuantityInStock() );
              String soldString = String.valueOf ( listOfProducts.get(loop).getTotalSales());
              System.out.println ("Name: " + listOfProducts.get(loop).getName() + " Code: " + listOfProducts.get(loop).getproductCode() 
                                 + " Discription: " + listOfProducts.get(loop).getProductDiscription() + " Stock Level: " +
                                  listOfProducts.get(loop).getQuantityInStock() + " Sold: " + soldString);
            }
          }// End of Display details
         
          // Add Product 
          else if (selection.equals ("3")){
           int addStock = 0;
           int addSales = 0;
           System.out.println("Add New Product:"); 
           System.out.println("");
           System.out.println("Please enter the name of the Product:");
           String addName = StringInput();
           
           // Check if product code already exists
           boolean exists = true;
           String addCode = "";
           while(exists){
             System.out.println("Please enter the Product Code:");
             addCode = StringInput();
             int sizeCheck = listOfProducts.size();
             for (int check = 0; check<sizeCheck; check++){
               String checkCode = listOfProducts.get(check).getproductCode();
               if (addCode.equals(checkCode)){
                 System.out.println("New code please, this already exists");
                 exists = true;
               }
               else{
                 exists = false;
               }
               
             }
             
           }
           // Continue with adding product 
           System.out.println("Please enter the Product Discription:");
           String addDis = StringInput();
           System.out.println("Please enter the Quantity In Stock:");
           boolean i = true; // Used to make sure the input is an integer
           while (i){
             try{
               addStock = IntInput();
               i = false;
             }
             catch(Exception e){e.printStackTrace();}
           }
           System.out.println("Please enter # of sales:");
           boolean z = true; // Used to make sure the input is an integer
           while (z){
             try{
               addSales = IntInput();
               z = false;
             }
             catch(Exception e){ System.out.println("Error- Must be integer value, try again.");}
           } 
           Product addProduct = new Product (addName,addCode,addDis,addStock,addSales);
           listOfProducts.add(addProduct);
          } // End of adding product 
          
          // Remove a Product 
          else if (selection.equals ("4")){
            boolean productFound = false; 
            
            int removeSize = listOfProducts.size();
            if (removeSize == 0){
              System.out.println(" ");
              System.out.println("Nothing to remove");
            }
            else{
              System.out.println("What is the name of the product that you would like to remove: ");
              String remove = StringInput();
              for (int removeIndex = 0; removeIndex<removeSize; removeIndex ++){
                String currentName = listOfProducts.get(removeIndex).getName();
                if (currentName.equals(remove)){ //Looking for which index to remove
                  productFound = true;
                  listOfProducts.remove(removeIndex);
                  System.out.println(" ");
                  System.out.println("Product Removed");
                  break;
                } 
              }
              if (productFound == false){System.out.println("Product Not Found!");}
            }
          }// End of Removing
          
          //Edit Product
          else if (selection.equals ("5")){
            System.out.println("What is the code of the product that you would like to edit: ");
            String codeOfEdit = StringInput();
            int editSize = listOfProducts.size();
            int editIndex = 0;
            Product thisProduct = listOfProducts.get(editIndex);
            for (editIndex = 0; editIndex<editSize; editIndex ++){
                String currentName2 = listOfProducts.get(editIndex).getproductCode();
                if (currentName2.equals(codeOfEdit)){
                  System.out.println("What would you like to edit?");
                  System.out.println("1) Name");
                  System.out.println("2) Product Code");
                  System.out.println("3) Product Description");
                  System.out.println("4) Stock Level");
                  System.out.println("5) # of Product's Sold");
                  String editSelection = StringInput();
                  
                  if (editSelection.equals("1")){
                  System.out.println("What would you like to change the name too?");
                  String newName = StringInput();
                  listOfProducts.set(editIndex,thisProduct).setName(newName);
                  System.out.println("Name has been changed.");
                  }
                  
                  else if (editSelection.equals("2")){
                    String newCode = "";
                    boolean usedCode = true;
                    while(usedCode){
                    System.out.println("What would you like to change the code too?");
                    newCode = StringInput();
                    int checkSize = listOfProducts.size();
                    for (int indexCheck = 0; indexCheck<checkSize; indexCheck++){
                     String checkEditCode = listOfProducts.get(indexCheck).getproductCode();
                     if (newCode.equals(checkEditCode)){
                     System.out.println("New code please, this already exists");
                     usedCode = true;
                     }
                     else{
                       usedCode = false;
                     }
                    }
                    listOfProducts.set(editIndex,thisProduct).setCode(newCode);
                    }
                  }
                  
                  else if (editSelection.equals("3")){
                    System.out.println("What would you like to change the Description too?");
                    String newDescription = StringInput();
                    listOfProducts.set(editIndex,thisProduct).setDiscription (newDescription);
                    System.out.println("Name has been changed.");
                  }
                  
                  else if (editSelection.equals("4")){
                    System.out.println("What would you like to change the Stock Level too?");
                    int editStock = 0;
                    boolean p = true; // Used to make sure the input is an integer
                    while (p){
                      try{
                        editStock = IntInput();
                        p = false;
                      }
                      catch(Exception e){ System.out.println("Error- Must be integer value, try again.");}
                    } 
                    listOfProducts.set(editIndex,thisProduct).setQuantityInStock (editStock);
                    System.out.println("Stock has been changed.");
                  }
                  
                  else if (editSelection.equals("5")){
                    System.out.println("How many units are now sold?");
                    int editSold = 0;
                    boolean c = true; // Used to make sure the input is an integer
                    while (c){
                      try{
                        editSold = IntInput();
                        c = false;
                      }
                      catch(Exception e){ System.out.println("Error- Must be integer value, try again.");}
                    } 
                    listOfProducts.set(editIndex,thisProduct).setTotalSales (editSold);
                    System.out.println("Units sold has been changed.");
                  }
                }
            }
          }
          
          
          
          else if (selection.equals ("6")){
            System.out.println("The following products have less than 10 units");
            int less10Size = listOfProducts.size();
            for (int less = 0; less<less10Size; less++){
              int currentNumber = listOfProducts.get(less).getQuantityInStock();
              if (currentNumber<10){
              System.out.println("Name: " + listOfProducts.get(less).getName() + " Stock Level: " + listOfProducts.get(less).getQuantityInStock());
              }
            }
          }
          
          
          else if (selection.equals ("7")){
            System.out.println("What is the keyword?");
            String keyword = StringInput();
            int keyLength = listOfProducts.size();
            for (int indexKey = 0; indexKey < keyLength; indexKey++){
              String keyCheck = listOfProducts.get(indexKey).getName();
              boolean found = keyCheck.contains(keyword);
              if (found==true){
              System.out.println("Name: " + listOfProducts.get(indexKey).getName() + " Stock Level: " + listOfProducts.get(indexKey).getQuantityInStock());
              }
            }
            System.out.println("Name has been changed.");   
          }
         
          
          else if (selection.equals ("8")){
            try {
              FileOutputStream fos = new FileOutputStream("products");
              ObjectOutputStream oos = new ObjectOutputStream(fos);
              oos.writeObject(listOfProducts);
              oos.close();
              fos.close();
            }
            catch (IOException e) {
              e.printStackTrace();
            }            
          }
          else if (selection.equals ("9")){
           
            try {
              FileOutputStream fos = new FileOutputStream("products");
              ObjectOutputStream oos = new ObjectOutputStream(fos);
              oos.writeObject(listOfProducts);
              oos.close();
              fos.close();
            }
            catch (IOException e) {
              e.printStackTrace();
            }
            
            
            mainLoop = false;
            
          }
          else{
            System.out.println("Error Input, Please try again");
          }
        }
        
        catch(Exception e) {} 
      }
  }
  
} 