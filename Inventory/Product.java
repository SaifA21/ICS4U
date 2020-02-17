import java.io.Serializable;

public class Product implements Serializable{ 
  
  private String productName;
  private String productCode;
  private String productDiscription;
  private int quantityInStock;
  private int totalSales;
  
  
  public Product(String productName, String productCode, String productDiscription, int quantityInStock, int totalSales){
  this.productName = productName;
  this.productCode = productCode;
  this.productDiscription = productDiscription;
  this.quantityInStock = quantityInStock;
  this.totalSales = totalSales;
  
  
  
  }
  
  // Create the differnt getter's for each property
  public String getName(){
  return productName;
  }
  
  public String getproductCode(){
  return productCode;
  }

  public String getProductDiscription(){
  return productDiscription;
  }
  
  public int getQuantityInStock (){
  return quantityInStock;
  }
  
  public int getTotalSales(){
  return totalSales;
  }

    // Create the differnt setter's for each property
  public void setName(String name){
  productName = name;
  }

  public void setCode (String code){
  productCode = code;
  }
  
  public void setDiscription (String discription){
  productDiscription = discription;
  }
  
  public void setQuantityInStock (int qInStock){
  quantityInStock = qInStock;
  }
  
  public void setTotalSales (int sales){
  totalSales = sales;
  }
  
  
  
  
}