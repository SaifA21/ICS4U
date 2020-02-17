// Name: SAIF
// File Name: EightyNine_Saif
// Date: 2019-09-26
// Course Code: ICS 4U
public class EightyNine_Saif{
  public static void main (String[] args){
    int[] orginal = {4,7,3,8,2,9,1,9,8,2};
    int[] ordered = sortFunction (orginal);
    int lengthOrdered = ordered.length;
    for (int printIndex = 0; printIndex<lengthOrdered; printIndex++){
    System.out.print(ordered[printIndex] + " "); 
    }
  }
  public static int[] sortFunction (int[] unsorted){
    int length = unsorted.length;
    int[] sorted = new int [length];
    
    int count = 0;
    
    for (int sort = 0; sort<length; sort++){ 
      if (unsorted[sort] != 9){
        sorted[count] = unsorted[sort];
        count++;
      }
      if (unsorted[sort] == 8){
        sorted[count] = 9;
        count++;
      }}
   
  return sorted; 
  }
}