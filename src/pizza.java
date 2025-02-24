public class pizza{
    public String storeName;
    public String storeAddress;
    public String storeEmail;
    public long storePhone;
    public String storeMenu;
    public String pizzaIngredients;
    private int pizzaPrice;  
    private String sides;
    private String drinks;
    private int orderID;
    private double orderTotal;

    public void takeorder(int pizzaPrice,String sides,String drinks,String pizzaIngredients,int ID,double Total){
        this.pizzaPrice=pizzaPrice;
        this.sides=sides;
        this.drinks=drinks;
        this.orderID=ID;
        this.orderTotal=Total;

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
        System.out.println("Details:"+sides+drinks+ pizzaPrice+" ponds");
        System.out.println("Order Total:"+ orderTotal+" ponds");
    }

}