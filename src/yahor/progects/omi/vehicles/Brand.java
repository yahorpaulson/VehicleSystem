package yahor.progects.omi.vehicles;

public class Brand {

    private String name;
    private String country;
    private String phone;
    private String email;

    public Brand(String name, String country, String phone, String email){
        this.name = name;
        this.country = country;
        this.phone = phone;
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
