import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {

    public Order(ArrayList<Main.Cupcake> cupcakeMenu, ArrayList<Main.Drink> drinkMenu) {

        System.out.println("Hello customer. Would you like to place an order? (Y/N)\n");

        Scanner scan = new Scanner(System.in);
        String placeOrder = scan.nextLine();
        ArrayList<Object> order = new ArrayList<>();

        if(placeOrder.equalsIgnoreCase("Y")){
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu:\n");
            System.out.println("CUPCAKES:");

            int itemNumber = 0;
            for(int i = 0; i < cupcakeMenu.size(); i++){
                itemNumber++;
                System.out.println("Item " + itemNumber + ":");
                cupcakeMenu.get(i).type();
                System.out.println("Price: $" + cupcakeMenu.get(i).getPrice());
            }
            System.out.println("\nDRINKS:");
            for(int i = 0; i < drinkMenu.size(); i++){
                itemNumber++;
                System.out.println("Item " + itemNumber + ":");
                drinkMenu.get(i).type();
                System.out.println("Price: $" + drinkMenu.get(i).getPrice());
                }
            System.out.println("\n");

            boolean ordering = true;

            while(ordering){
                System.out.println("What would you like to order? Please use the number associated with each item to order.");
                int orderChoice = scan.nextInt();
                scan.nextLine();
                if(orderChoice == 1){
                    order.add(cupcakeMenu.get(0));
                    System.out.println("Item added to order.");
                }else if(orderChoice == 2){
                    order.add(cupcakeMenu.get(1));
                    System.out.println("Item added to order.");
                }else if(orderChoice == 3){
                    order.add(cupcakeMenu.get(2));
                    System.out.println("Item added to order.");
                }else if(orderChoice == 4){
                    order.add(drinkMenu.get(0));
                    System.out.println("Item added to order.");
                }else if(orderChoice == 5){
                    order.add(drinkMenu.get(1));
                    System.out.println("Item added to order.");
                }else if(orderChoice == 6){
                    order.add(drinkMenu.get(2));
                    System.out.println("Item added to order.");
                }else{
                    System.out.println("Sorry, we don't seem to have that on the menu.");
                }
                System.out.println("\nWould you like to continue ordering?");
                placeOrder = scan.nextLine();
                if(!placeOrder.equalsIgnoreCase("Y")){
                    System.out.println("\n");
                    ordering = false;
                }
            }

            System.out.println("Your order:");
            System.out.println(order.get(0));
            System.out.println(order.get(1));

            Double subtotal = 0.00;

            for(int i = 0; i < order.size(); i++){
                for( int j = 0; j < cupcakeMenu.size(); j++){
                    if(order.get(i).equals(cupcakeMenu.get(j))){
                        cupcakeMenu.get(j).type();
                        System.out.println(cupcakeMenu.get(j).getPrice());
                        subtotal += cupcakeMenu.get(j).getPrice();
                    }
                }
            }
            for(int i = 0; i < order.size(); i++){
                for( int j = 0; j < drinkMenu.size(); j++){
                    if(order.get(i).equals(drinkMenu.get(j))){
                        drinkMenu.get(j).type();
                        System.out.println(drinkMenu.get(j).getPrice());
                        subtotal += drinkMenu.get(j).getPrice();
                    }
                }
            }

            System.out.println("$" + subtotal + "\n");

            new CreateFile();
            new WriteToFile(order);

        } else {
            System.out.println("Have a nice day then.");
        }

    }

}

class CreateFile {

    public CreateFile(){

        try{
            File salesData = new File("salesData.txt");
            if(salesData.createNewFile()){
                System.out.println("File created: " + salesData.getName());
            }else{
                System.out.println("File already exists.");
            }
        }catch(IOException e){
            System.out.println("An error occurred");
        }

    }

}

class WriteToFile {

    public WriteToFile(ArrayList<Object> order){

        try{
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for(int i = 0; i < order.size(); i++){
                System.out.println(order.get(i));
            }
            salesWriter.close();
            System.out.println("Successfully wrote to the file.");
        }catch(IOException e){
            System.out.println("An error occurred.");
        }

    }

}
