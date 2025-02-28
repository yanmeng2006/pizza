public class App{
    public static void main(String[] args) throws Exception{
        pizza card1=new pizza("123","Cheese",15.00,"6 inches","cola");
        pizza card2=new pizza("456","Cheese",15.00,"6 inches","cola");
        pizza card3=new pizza("789","Cheese",15.00,"6 inches","cola");
        card1.processCardPayment("12345678987654");
        card2.processCardPayment("11112222333378");
        card3.processCardPayment("12345678912345");
        card1.specialOfTheDay(null, null, null);
    }
}
    
    
    