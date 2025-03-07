import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.text.DateFormatter;

public class pizza{
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public String Ingredient1; 
    public String Ingredient2; 
    public String Ingredient3; 
    public int pizzaPrice;  
    public String sides;

    private String drinks;
    private String size;
    private String extracheese;
    private String sidedish;
    private String orderID;

    private double orderTotal;

    public final String DEF_ORDER_ID="DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS="Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL=15.00;

    public int cvv;
    public long cardNumber;
    public String expiryDate;
    public int cardLength;
    public int firstCardDigit;
    public int lastFourDigit;
    public String blacklistedNumber="12345678987654";
    private String cardNumberToDisplay;

    public StringBuilder pizzaOfTheDay;
    public StringBuilder sideOfTheDay;
    public StringBuilder specialPrice;

    public void processCardPayment(long cardNumber,String expiryDate,int cvv){
        Scanner input = new Scanner(System.in);

        cardLength=Long.toString(cardNumber).length();
        if (cardLength==14) {
            while (Long.toString(cardNumber).equals(blacklistedNumber)){
                System.out.println("Card is blacklisted. Please use another card");
                cardNumber=input.nextLong();
                cardLength=Long.toString(cardNumber).length();
            }
            System.out.println("Card accepted");
        } else{
            System.out.println("Card declined");
        }

        firstCardDigit=Integer.parseInt(Long.toString(cardNumber).substring(0, 1));
        lastFourDigit=Integer.parseInt(Long.toString(cardNumber).substring(10, 14));
        cardNumberToDisplay=firstCardDigit+"*********"+lastFourDigit;
        System.out.println("Card number is:"+ cardNumberToDisplay);

        orderID=cardNumberToDisplay;

        input.close();
    }

    public void specialOfTheDay(StringBuilder pizzaOfTheDay,StringBuilder sideOfTheDay,StringBuilder specialPrice){
        this.pizzaOfTheDay=pizzaOfTheDay;
        this.sideOfTheDay=sideOfTheDay;
        this.specialPrice=specialPrice;

        System.out.println("**********************");
        System.out.println("Pizza of the day is:"+ pizzaOfTheDay);
        System.out.println("Side of the day is:"+ sideOfTheDay);
        System.out.println("Special price is:"+ specialPrice);

    }

    public pizza(String DEF_ORDER_ID, String DEF_PIZZA_INGREDIENTS, double DEF_ORDER_TOTAL, String sides, String drinks){
        orderID = DEF_ORDER_ID;
        pizzaIngredients = DEF_PIZZA_INGREDIENTS;
        orderTotal = DEF_ORDER_TOTAL;
        this.sides = sides;
        this.drinks=drinks;
    }

    public void Pizza(String ID,String Ingredients,double Total){
        this.orderID=ID;
        this.pizzaIngredients=Ingredients;
        this.orderTotal=Total;
    }

    public String getorderID(){
        return orderID;
    }
    public void setorderID(String ID){
        this.orderID=ID;
    }

    public String getpizzaingredients(){
        return pizzaIngredients;
    } 
    public void setpizzaIngredients(String Ingredients){
        this.pizzaIngredients=Ingredients;
    } 

    public double getorderTotal(){
        return orderTotal;
    }
    public void setorderTotal(double Total){
        this.orderTotal=Total;
    }

    public void takeorder(){

        Scanner input = new Scanner(System.in);

        System.out.println("Please pick any three of the following ingredients:\r\n" + //
                        " 1. Mushroom\r\n" + //
                        " 2. Paprika\r\n" + //
                        " 3. Sun-dried tomatoes\r\n" + //
                        " 4. Chicken\r\n" + //
                        " 5. Pineapple\r\n" + //
                        " Enter any three choices (1, 2, 3,…) separated by spaces:");
        int ingChoice1=input.nextInt();
        int ingChoice2=input.nextInt();
        int ingChoice3=input.nextInt();

        while(ingChoice1<1||ingChoice1>5||ingChoice2<1||ingChoice2>5||ingChoice3<1||ingChoice3>5){
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            ingChoice1=input.nextInt();
            ingChoice2=input.nextInt();
            ingChoice3=input.nextInt();
        }
        switch (ingChoice1) {
            case 1:
                Ingredient1="Mushroom";
                break;
             case 2:
                Ingredient1="Paprike";
                break; 
            case 3:
                Ingredient1="Sun-dried tomatoes";
                break; 
            case 4:
                Ingredient1="Chicken";
                break; 
            case 5:
                Ingredient1="Pineapple";
                break;
        
            default:
                break;
        }
        switch (ingChoice2) {
            case 1:
                Ingredient2="Mushroom";
                break;
             case 2:
                Ingredient2="Paprike";
                break; 
            case 3:
                Ingredient2="Sun-dried tomatoes";
                break; 
            case 4:
                Ingredient2="Chicken";
                break; 
            case 5:
                Ingredient2="Pineapple";
                break;
        
            default:
                break;
        }
        switch (ingChoice3) {
            case 1:
                Ingredient3="Mushroom";
                break;
             case 2:
                Ingredient3="Paprike";
                break; 
            case 3:
                Ingredient3="Sun-dried tomatoes";
                break; 
            case 4:
                Ingredient3="Chicken";
                break; 
            case 5:
                Ingredient3="Pineapple";
                break;
        
            default:
                break;
        }

        
        
        System.out.println("”What size should your pizza be?\r\n" + //
                        " 1. Large\r\n" + //
                        " 2. Medium\r\n" + //
                        " 3. Small\r\n" + //
                        " Enter only one choice (1, 2, or 3):");
        int sizechoice=input.nextInt();
        input.nextLine();
        while(sizechoice<1||sizechoice>3){
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            sizechoice=input.nextInt();
        }
        switch (sizechoice) {
            case 1:
                size="Large";
                break;
            case 2:
                size="Medium";
                break;
            case 3:
                size="Small";
                break;
        
            default:
                break;
        }

        System.out.println("Do you want extra cheese (Y/N):");
        extracheese=input.nextLine();
        input.nextLine();

        System.out.println("Following are the side dish that go well with your pizza:\r\n" + //
                        " 1. Calzone\r\n" + //
                        " 2. Garlic bread\r\n" + //
                        " 3. Chicken puff\r\n" + //
                        " 4. Muffin\r\n" + //
                        " 5. Nothing for me\r\n" + //
                        " What would you like? Pick one (1, 2, 3,…):");
        int sidedishchoice=input.nextInt();
        while (sidedishchoice<1||sidedishchoice>5) {
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            sidedishchoice=input.nextInt();
            
        }
        switch (sidedishchoice) {
            case 1:
                sidedish="Calzone";
                break; 
            case 2:
                sidedish="Garlic bread";
                break; 
            case 3:
                sidedish="chicken puff";
                break; 
            case 4:
                sidedish="Muffin";
                break;
            case 5:
                sidedish="Nothing for me";
                break;
        
            default:
                break;
        }
        
        System.out.println("Choose from one of the drinks below. We recommend Coca Cola:\r\n" + //
                        " 1. Coca Cola\r\n" + //
                        " 2. Cold coffee\r\n" + //
                        " 3. Cocoa Drink\r\n" + //
                        " 4. No drinks for me\r\n" + //
                        " Enter your choice:");
        int drinkchioce=input.nextInt();
        while(drinkchioce<1||drinkchioce>4){
            System.out.println("Invalid choice(s). Please pick only from the given list:");
            drinkchioce=input.nextInt();
        }
        switch (sizechoice) {
            case 1:
                drinks="Coca Cola";
                break;
            case 2:
                drinks="Cold coffee";
                break;
            case 3:
                drinks="Cocoa Drink";
                break;
            case 4:
                drinks="No drinks for me";
                break;
        
            default:
                break;
        }
        input.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String  wantDiscount=input.nextLine();
        if(wantDiscount.equals("Y")||wantDiscount.equals("y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }

        makePizza();
        System.out.println(toString());

        input.close();
    }
    private void makePizza(){
        System.out.println("Making pizza with"+ pizzaIngredients);

    }
    public String toString(){
        return "***********RECEIPT***********\nOrderID:"+ orderID+"\nSize:"+size+"\nextracheese:"+extracheese+"\nSidedish:"+sidedish+"\nDrinks:"+drinks+"\nOrder Total:"+ orderTotal;
    }

    public void isItYourBirthday(){
        Scanner input=new Scanner(System.in);
        System.out.println("Your birthdate (year-month-day):");
        String date=input.nextLine();
        int year=Integer.parseInt(date.substring(0,4));
        int month=Integer.parseInt(date.substring(5,7));
        int day=Integer.parseInt(date.substring(8,10));

        LocalDate dob=LocalDate.of(year,month,day);
        LocalDate now=LocalDate.now();

        Period diff= Period.between(dob,now);
        while(diff.getYears()<5||diff.getYears()>120){
            System.out.println("Invalid date. You are either too young or too dead to order. \r\n" + //
                                "Please enter a valid date:");
            date=input.nextLine();
            year=Integer.parseInt(date.substring(0,4));
            month=Integer.parseInt(date.substring(5,7));
            day=Integer.parseInt(date.substring(8,10));
    
            dob=LocalDate.of(year,month,day);
            diff= Period.between(dob,now);
        }
        if(dob.getDayOfMonth()==now.getDayOfMonth()&&dob.getMonthValue()==now.getMonthValue()&&diff.getYears()<18){
            System.out.println("Congratulations! You pay only half the price for your order");
        }else{
            System.out.println("Too bad! You do not meet the conditions to get our 50% discountr");
        }
        input.close();
    }


        private void makeCardPayment(){
            Scanner input=new Scanner(System.in);
            System.out.println("Card Number:");
            cardNumber=input.nextLong();
            System.out.println("Expiry Date(year-month):");
            expiryDate=input.nextLine();
            input.nextLine();
            boolean vaildExpirydate=false;
            while (vaildExpirydate) {
                try{
                    int year=Integer.parseInt(expiryDate.substring(0,4));
                    int month=Integer.parseInt(expiryDate.substring(5, 7));
                    LocalDate expiry=LocalDate.of(year, month,01);
                    LocalDate now=LocalDate.now();
                    if(expiry.isBefore(now)){
                        System.out.println("Invalid format, Please enter the expiry date in Y-mM format:");
                        expiryDate=input.nextLine();
                    }else{
                        vaildExpirydate=true;
                    }
                    

                }catch(Exception e){
                    System.out.println("Invalid format, Please enter the expiry date in Y-mM format:");
                    expiryDate=input.nextLine();
                }
            }
            
            System.out.println("Cvv Number:");
            int cvv=input.nextInt();
            processCardPayment(cardNumber,expiryDate,cvv);
            input.close();
        }
}