import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

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
    private String sides;
    private String drinks;
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

        cardLength=Long.toString(cardNumber).length();
        if (cardLength==14) {
            System.out.println("Card accepted");
        } else{
            System.out.println("Card declined");
        }

        
        if (Long.toString(cardNumber).equals(blacklistedNumber)){
            System.out.println("Card is blacklisted. Please use another card");
        }else{
            System.out.println("Card accepted");
        }
        firstCardDigit=Integer.parseInt(Long.toString(cardNumber).substring(0, 1));
        lastFourDigit=Integer.parseInt(Long.toString(cardNumber).substring(10, 14));
        cardNumberToDisplay=firstCardDigit+"*********"+lastFourDigit;
        System.out.println("Card number is:"+ cardNumberToDisplay);
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

        System.out.println("Enter three ingredients for your pizza (use spaces to separate ingredients):");
        String Ingredient1=input.next();
        String Ingredient2=input.next();
        String Ingredient3=input.next();
        
        
        System.out.println("Enter size of pizza (Small, Medium, Large):");
        String size=input.nextLine();
        input.nextLine();

        System.out.println("Do you want extra cheese (Y/N):");
        String extracheese=input.nextLine();

        System.out.println("Enter one side dish (Calzone, Garlic bread, None):");
        String sidedish=input.nextLine();
        
        System.out.println("Enter drinks(Cold Coffee, Cocoa drink, Coke, None):");
        String drinks=input.nextLine();

        System.out.println("Would you like the chance to pay only half for your order? (Y/N):");
        String  wantDiscount=input.nextLine();

        if(wantDiscount.equals("Y")||wantDiscount.equals("y")){
            isItYourBirthday();
        }else{
            makeCardPayment();
        }

        makePizza();
        printReceipt(size,extracheese,sidedish,drinks);

        input.close();
    }
    private void makePizza(){
        System.out.println("Making pizza with"+ pizzaIngredients);

    }
    private void printReceipt(String size,String extracheese,String sidedish,String drinks){
        orderID=cardNumberToDisplay;
        System.out.println("***********RECEIPT***********");
        System.out.println("OrderID:"+ orderID);
        System.out.println("Details:"+size+","+sidedish+","+drinks);
        System.out.println("Order Total:"+ orderTotal);
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
        if(dob.getDayOfMonth()==now.getDayOfMonth()&&dob.getMonthValue()==now.getMonthValue()&&diff.getYears()<18){
            System.out.println("Congratulations! You pay only half the price for your order");
        }else{
            System.out.println("Too bad! You do not meet the conditions to get our 50% discountr");
        }
    }


        private void makeCardPayment(){
            Scanner input=new Scanner(System.in);

            System.out.println("Card number:");
            Long cardNumber=input.nextLong();
            System.out.println("Expiry Date(year-month):");
            expiryDate=input.nextLine();
            input.nextLine();
            System.out.println("Cvv Number:");
            int cvv=input.nextInt();
            processCardPayment(cardNumber,expiryDate,cvv);
            input.close();
           


    }
}