public class Address {
    public Address(String nameOfAddress) {
        this.nameOfAddress = nameOfAddress;
    }

    private String nameOfAddress;

    public String getNameOfAddress() {
        return nameOfAddress;
    }

    public void setNameOfAddress(String nameOfAddress) {
        if (nameOfAddress == null) throw new NullPointerException("nameOfAddress cannot be null");
        this.nameOfAddress = nameOfAddress;
    }
}
