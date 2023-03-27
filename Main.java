import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Inventory> items = new ArrayList<>();

    int userIn = 0;
    while (userIn != 5) {
      System.out.println("Press 1 to add an item.");
      System.out.println("Press 2 to delete an item.");
      System.out.println("Press 3 to update an item.");
      System.out.println("Press 4 to show all the items.");
      System.out.println("Press 5 to quit the program");

      userIn = scan.nextInt();
      scan.nextLine();

      switch (userIn) {
        case 1: {
          System.out.println("Enter the name:");
          String name = scan.nextLine();
          System.out.println("Enter the serial number:");
          String serNum = scan.nextLine();
          System.out.println("Enter the value in dollars (whole number):");
          int value = scan.nextInt();
          Inventory inv = new Inventory(name, serNum, value);
          items.add(inv);
          break;
        }
        case 2: {
          System.out.println("Enter the serial number of the item to delete:");

          String serNum = scan.nextLine();
          for (int i = 0; i < items.size(); i++) {
            Inventory inv = items.get(i);
            if (inv.serialNum.equals(serNum)) {
              items.remove(i);
              break;
            }
          }
          break;
        }
        case 3: {
          System.out.println("Enter the serial number of the item to change:");

          String serNum = scan.nextLine();
          System.out.println("Enter the new name:");
          String name = scan.nextLine();

          System.out.println("Enter the new value:");
          int value = scan.nextInt();

          for (int i = 0; i < items.size(); i++) {
            Inventory inv = items.get(i);
            if (inv.serialNum.equals(serNum)) {
              items.set(i, new Inventory(name, serNum, value));
              break;
            }
          }
          break;
        }
        case 4: {
          for (Inventory inv : items) {
            System.out.println(inv.product + "," + inv.serialNum + "," + inv.price);
          }
          break;
        }
        case 5:
          return;
      }

    }

  }
}