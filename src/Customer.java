public class Customer {
    private String name;
    private int ssn;
    private String address;
    public Customer(String name, int ssn, String address) {
        this.name = name;
        this.ssn = ssn;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getSsn() {
        return ssn;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "Customer: " + getName() + " (SSN: " + getSsn() + ") " + getAddress();
    }
}
