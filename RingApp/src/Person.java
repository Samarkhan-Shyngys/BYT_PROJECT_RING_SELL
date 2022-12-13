public abstract class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;

    public Person(String firstName, String lastName, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = new Address(address);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new NullPointerException("firstName cannot be null");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) throw new NullPointerException("lastName cannot be null");
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) throw new NullPointerException("phoneNumber cannot be null");
        this.phoneNumber = phoneNumber;
    }
}
