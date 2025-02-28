public class pizza{
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    public int pizzaPrice;  
    private String sides;
    private String drinks;
    private String orderID;
    private double orderTotal;

    public final String DEF_ORDER_ID="DEF-SOH-099";
    public final String DEF_PIZZA_INGREDIENTS="Mozzarella Cheese";
    public final double DEF_ORDER_TOTAL=15.00;

    public int cvv;
    public String cardNumber;
    public String expiryDate;
    public int cardLength;
    public int firstCardDigit;
    public int lastFourDigit;
    public String blacklistedNumber="12345678987654";
    private String cardNumberToDisplay;

    public StringBuilder pizzaOfTheDay;
    public StringBuilder sideOfTheDay;
    public StringBuilder specialPrice;

    public void processCardPayment(String cardNumber){
        this.cardNumber=cardNumber;

        cardLength=cardNumber.length();
        if (cardLength==14) {
            System.out.println("Card accepted");
        } else{
            System.out.println("Card declined");
        }

        
        if (cardNumber.equals(blacklistedNumber)){
            System.out.println("Card is blacklisted. Please use another card");
        }else{
            System.out.println("Card accepted");
        }
        firstCardDigit=Integer.parseInt(cardNumber.substring(0, 1));
        lastFourDigit=Integer.parseInt(cardNumber.substring(10, 14));
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

    public void takeorder(String ID,int price, String Ingredients, String sides, String drinks, double Total){
        orderID=ID;
        pizzaPrice=price;
        pizzaIngredients=Ingredients;
        this.sides=sides;
        this.drinks=drinks;
        orderTotal=Total;

        System.out.println("Order accepted!");

        System.out.println("Order is being prepared");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            makePizza();
            System.out.println("Order is ready for pickup!");
        }

        System.out.println("Your order is ready!");

        printReceipt();
    }
    private void makePizza(){
        System.out.println("Making pizza with"+ pizzaIngredients);

    }
    private void printReceipt(){
        System.out.println("********RECEIPT********");
        System.out.println("OrderID:"+ orderID);
        System.out.println("Details:"+sides+drinks);
        System.out.println("Order Total:"+ orderTotal);
    }

}