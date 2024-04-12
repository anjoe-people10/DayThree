enum Laptop {
    Acer(2000), Dell(1000), HP(3000), Lenovo(800);

    private int price;

    Laptop(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class EnumExamples {
    public static void main(String[] args) {
        for(Laptop company : Laptop.values()) {
            System.out.println(company + " : " + company.getPrice());
        }
    }
}
