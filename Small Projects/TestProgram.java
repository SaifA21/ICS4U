public class TestProgram{
  public static void main(String[] args){
  My2DPoint firstPoint = new My2DPoint();
  firstPoint.x = 4;
  firstPoint.y = 6;
  My2DPoint secondpoint = new My2DPoint();
  int sum = secondpoint.Add2DPoint(3,3) ;
  secondpoint.z = ("hello");
  System.out.println(secondpoint.sayHello("saif","Abuosba"));
  System.out.println(sum);
  System.out.println(firstPoint.x);
  System.out.println(firstPoint.y);
  
  
  }
}