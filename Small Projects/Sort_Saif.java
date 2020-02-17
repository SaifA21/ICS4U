// Name: Saif A
// Date: 2019-09-23
// Class: ICS 4UR
// File Name: Sort_Saif

public class Sort_Saif{
  public static void main (String[] args){
    // CALLING BUBBLE SORT
    int bs[] = {3,6,2,4,7,2,9,8};
    int[] bubble = bubbleSort(bs);
    int new_length = bubble.length;
    for (int b = 0; b<new_length; b++){
    System.out.print(bubble [b]);
    }
    System.out.println("");
    // CALLING SIMPLE SORT
    int ss[] = {6,9,1,4,1,6};
    int[] simple = simpleSort(ss);
    int simpleLength = simple.length;
    for (int q = 0; q<simpleLength; q++){
    System.out.print(simple [q]);
    }
    System.out.println("");
    // CALLING SELECTION SORT
    int se[] = {1,9,2,1,8};
    int selection[] = selectionSort(se);
    int selectionLength = selection.length;
    for (int p = 0; p<selectionLength; p++){
    System.out.print(selection [p]);
    }
    System.out.println("");
  // CALLING INSERTION SORT
    int is[] = {6,9,1,4,1,6};
    int insertion[] = insertionSort(is);
    int insertionLength = insertion.length;
    for (int w = 0; w<insertionLength; w++) {
    System.out.print(insertion[w]);
    }
  }
  
  
// BUBBLE SORT METHOD
  public static int[] bubbleSort (int[] name){
    int swap = 0;
    int temp1;
    int temp2;
    int length = name.length;
    while (swap == 0){
    swap = 1;
      for (int i=0; i < (length-1); i++){
      temp1 = name[i];
      temp2 = name[i+1];
      if (name[i] > name[i+1]){
        name[i] = temp2;
        name[i+1] = temp1;
        swap = 0;}
    }
  }
    return name;
  }
  
  // SIMPLE SORT METHOD
  public static int[] simpleSort (int[] name2){
  int lengthSimple = name2.length;
  int[] simpleSorted = new int [lengthSimple];
  int lowestValue = name2[0];
  int indexLowest = 0;
  int loopCounter = 0;
  while (loopCounter<lengthSimple){
  for (int x=0 ; x<lengthSimple ; x++){
    if (name2[x] <= lowestValue){
    lowestValue = name2[x];
    indexLowest = x;
    }
  }
  simpleSorted[loopCounter] = lowestValue;
  lowestValue = Integer.MAX_VALUE;
  name2[indexLowest] = Integer.MAX_VALUE;
  loopCounter++;
 }
  return simpleSorted;
  }
  
  // SELECTION SORT METHOD
  public static int[] selectionSort (int[] name3){
  int length = name3.length;
  int whileCounter = 0;
  int startingIndex = 0;
  int lowestIndex = 0;
  int minValue = Integer.MAX_VALUE;
  while (whileCounter < length){
    int temp_1 = 0;
    for (int h = startingIndex; h<length; h++){
      if (name3[h] < minValue){
        temp_1 = name3[startingIndex];
        minValue = name3[h];
        lowestIndex = h;}
    }
    name3[startingIndex] = minValue;
    name3[lowestIndex] = temp_1;
    whileCounter++;
    startingIndex++;
    minValue = Integer.MAX_VALUE;
  }  
   return name3;
  }
// INSERTION SORT METHOD
  public static int[] insertionSort (int[] name4){
  int length = name4.length;
  int temp1 = 0;
  int temp2 = 0;
  int subTemp1 = 0;
  int subTemp2 = 0;
  int endSub = 0;
  
  for (int v = 0; v<(length-1); v++){
    temp1 = name4[v];
    temp2 = name4[v+1];
    if (temp2<temp1){
      name4[v] = temp2;
      name4[v+1] = temp1;
      endSub += 1;  
      for (int r = 0; r < endSub; r++){
        if (name4[r+1]<name4[r]){
          subTemp1 = name4[r];
          subTemp2 = name4[r+1];
          name4[r] = subTemp2;
          name4[r+1] = subTemp1;
          r = 0;
        } 
    }
    
  }
  
  }
  if (name4[0]>name4[1]){
    temp1= name4[0];
    temp2 = name4[1];
    name4[0] = temp2;
    name4[1] = temp1;
 
  }
     return name4;
  }
  

  
}

