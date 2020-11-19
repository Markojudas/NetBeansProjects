package app;

//this is the data class

public class Customer extends PhoneNumber {
    
    public String name;
    private String address;
    public String phone;

          
    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }
    
    

}
