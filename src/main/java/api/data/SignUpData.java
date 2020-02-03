package api.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Random;

@JsonPropertyOrder({"name","email","password","accountType","lang","phoneHidden","phone","region"})
public class SignUpData {

    @JsonIgnore
    private String city;
    private String password;
    private String name;
    private int phoneHidden;
    private int region;
    private int accountType;
    private String email;
    private String phone;
    private String lang;

    public SignUpData() {

    }

    public SignUpData(String name, String password, int accountType, String lang, int phoneHidden, String city) {
        this.password = password;
        this.name = name;
        this.phoneHidden = phoneHidden;
        this.city = city;
        this.accountType = accountType;
        this.lang=lang;
    }

    public SignUpData(String name,String email, String password, int accountType, String lang, int phoneHidden,String phone, int region) {
        this.password = password;
        this.name = name;
        this.phoneHidden = phoneHidden;
        this.region = region;
        this.accountType = accountType;
        this.lang=lang;
        this.phone=phone;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneHidden() {
        return phoneHidden;
    }

    public void setPhoneHidden(int phoneHidden) {
        this.phoneHidden = phoneHidden;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String randomemail() {
        Random rand = new Random();
        int randomnumber = rand.nextInt(99999) + 1;

        return "qatest" + randomnumber + "@gmail.com";
    }

    public String randomphone() {
        Random rand = new Random();
        int randomphone = rand.nextInt(666666) + 111111;
        return "0656" + randomphone;
    }
}