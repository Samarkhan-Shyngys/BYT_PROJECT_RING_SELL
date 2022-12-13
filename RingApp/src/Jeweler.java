public class Jeweler extends Person{
    private Double priceService;

    public Jeweler(String firstName, String lastName, String phoneNumber, String address) {
        super(firstName, lastName, phoneNumber, address);
    }

    public Double getPriceService() {
        return priceService;
    }

    public void setPriceService(Double priceService) {
        if (priceService == null || priceService==0) throw new NullPointerException("priceService cannot be null and not equals to 0");
        this.priceService = priceService;

    }
}
