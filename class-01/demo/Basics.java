public class Basics{
  public static void main(String[] args){

    //STRONG TYPED 
    int int1 = 1; // not an Object
    Integer int2 = 7; //Object
    long long1 = 100000;
    // casting
    byte byte1 = (byte)7;
    short short1 = (short)0xFFFF;
    boolean bool1 = true;

    float float1 = 0.1f;
    float float2 = 0.2f;
    float float3 = float1 + float2;
    boolean floatBool = (float3 == 0.3f); //true
    System.out.println("booleanFloat: " + floatBool);
    System.out.println("float3: " + float3);

    double double1 = 0.1;
    double double2 = 0.2;
    double double3 = double1 + double2;
    boolean booleanDouble = (double3 == 0.3);  // false!
    System.out.println("booleanDouble: " + booleanDouble);
    System.out.println("double3: " + double3);

    char char1 = 'a';
    char char2 = 'b';
    System.out.println("char1: " + char1);

    int int20 = 20;
    String numberString = "30";
    System.out.println("int20 + numberString: " + (int20 + numberString)); //50 2030
    System.out.println("int20 + Integer.fromString(numberString): " + (int20 + Integer.parseInt(numberString))); // 50

    // Conditionals
    // If-else statement
    int number1 = 7;
    int number2 = 10;
    if (number2 > number1) {
      // condition 1
      System.out.println(number2 + " is greater than " + number1);
    } else if (number2 == number1) {
      //condition 2
      System.out.println("The numbers are equal");
    } else {
      // alternative condition
      System.out.println(number2 + " is less than " + number1);
    }

    // Ternary
  
    // Switch
      int month = 8;
    String monthString;
    switch (month) {
      case 1:  monthString = "January";
        break;
      case 2:  monthString = "February";
        break;
      case 3:  monthString = "March";
        break;
      case 4:  monthString = "April";
        break;
      case 5:  monthString = "May";
        break;
      case 6:  monthString = "June";
        break;
      case 7:  monthString = "July";
        break;
      case 8:  monthString = "August";
        break;
      case 9:  monthString = "September";
        break;
      case 10: monthString = "October";
        break;
      case 11: monthString = "November";
        break;
      case 12: monthString = "December";
        break;
      default: monthString = "Invalid month";
        break;
    }
    System.out.println(monthString);


    int counter = 0;
     while(counter < 6){
       System.out.println("counter: " + counter);
      counter++;
      if (counter > 2)
        {
          //FULL STOP
          break;
        }
        if(counter > 4){
          // Skip current iteration
          continue;

        }
     }

      //

      int[] intArray1 = {3, 2, 5};

    for(int i = 0; i < intArray1.length; i++)
    {
        System.out.println("intArray[" + i + "]: " + intArray1[i]);
    }

    // FOR EACH
    for(int currentInt : intArray1)
    {
        System.out.println("currentInt: " + currentInt);
    }

    String newString = stringReturner();
    System.out.println("newString: " + newString);
  }

  public static String stringReturner(String word, int number){
    return "Zork";
  }
}