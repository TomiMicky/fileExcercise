package util;

        import java.util.Scanner;

        public class Input {
   private Scanner scanner;

             public Input() {
              scanner = new Scanner(System.in);
            }

             public String getString(String prompt) {
                 System.out.println(prompt);
                String userString = scanner.nextLine();
                return userString;
            }

            public boolean yesNo(String prompt) {
                System.out.println(prompt);
                String userInput = this.scanner.nextLine();
                return userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes");
            }


            public int getInt(){
                try {
                   return Integer.valueOf(getString("Enter number here: "));

                } catch (NumberFormatException e) {

                    System.out.println("That's not an integer! Try again.");
                    scanner.nextLine();
                    return getInt();
                }
            }

             public int getInt(int min, int max) {
                int userInput = getInt();
                        if (userInput < min || userInput > max) {
                     System.out.println(userInput + " is not between " + min + " and " + max);
                        return getInt(min, max);
                    }
                       return userInput;
        }
             public double getDouble() {
                try {
                    return Double.valueOf(getString("Enter Decimal number here: "));

                }catch (NumberFormatException ex){
                        System.out.println("That's not an decimal number! try again.");
                        scanner.nextLine();
                        return getDouble();
                    }
         }
             public double getDouble(double min, double max) {
                double userInput = getDouble();

                        if (userInput < min || userInput > max) {
                    System.out.println(userInput + " is not between " + min + " and " + max);
                        return getDouble(min, max);
                    }

                        return userInput;
           }

         }


