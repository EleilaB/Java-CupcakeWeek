import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Cupcake> cupcakeMenu = new ArrayList<Cupcake>();

        Cupcake cupcake = new Cupcake();
        Cupcake redVelvet = new Cupcake();
        Cupcake chocolate = new Cupcake();

        System.out.println("We are in the middle of creating the cupcake menu.\n" +
                "We currently have three cupcakes on the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);
        System.out.println("We are deciding on the price for our standard cupcake.\nHere is the description:");
        cupcake.type();
        System.out.println("How much would you like to charge for the cupcake?\n" +
                "(Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        System.out.println("We are deciding on the price for our red velvet cupcake.\nHere is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake?\n" +
                "(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);

        System.out.println("We are deciding on the price for our chocolate cupcake.\nHere is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake?\n" +
                "(Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        cupcake.setPrice(price);

        cupcakeMenu.add(cupcake);
        cupcakeMenu.add(redVelvet);
        cupcakeMenu.add(chocolate);

    }

    static class Cupcake {
        public double price;

        public void type() {
            System.out.println("A basic, generic cupcake with vanilla frosting.");
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
    class RedVelvet extends Cupcake {
        @Override
        public void type() {
            System.out.println("A red velvet based cupcake with cream cheese frosting.");
        }
    }
    class Chocolate extends Cupcake {
        @Override
        public void type() {
            System.out.println("A chocolate based cupcake with chocolate frosting.");
        }
    }

}
