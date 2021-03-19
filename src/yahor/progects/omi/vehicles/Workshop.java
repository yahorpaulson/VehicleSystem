package yahor.progects.omi.vehicles;

public class Workshop {

    private String name;
    private String country;
    private int postCode;
    private String city;
    private String street;
    private String phone;

    public Workshop(String name, String country, int postCode, String city, String street, String phone){
        this.city = city;
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.street = street;
        this.postCode = postCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
    ///endregion
}
