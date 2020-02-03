package api.data.AdInsertData;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"type","category","subject","body","region","phone","accountType","name","phoneHidden","lang"})
public class AdInsertBase {
    @JsonIgnore
    protected final String carWording ="Voitures";
    @JsonIgnore
    protected final String phoneWording ="Téléphones";
    @JsonIgnore
    protected final String immoWording ="Appartements";
    @JsonIgnore
    protected final String emploiWording ="Offres d'emploi";
    @JsonIgnore
    protected final String insertionType ="Offre";

    @JsonIgnore
    protected String price;
    @JsonIgnore
    protected String cityWording;
    @JsonIgnore
    protected String secteur;
    @JsonIgnore
    protected String email;
    @JsonIgnore
    protected String emailNu;
    @JsonIgnore
    protected String password;

    protected String type;
    protected int category;
    protected String subject;
    protected String body;
    protected int region;
    protected String name;
    protected String phone;
    protected int accountType;
    protected int phoneHidden;
    protected String lang;

    public AdInsertBase() {
    }

    public AdInsertBase(String subject, String body, String price, String cityWording, String secteur, String name, String email, String emailNu, String phone, String password) {
        this.subject = subject;
        this.body = body;
        this.price = price;
        this.cityWording = cityWording;
        this.secteur = secteur;
        this.name = name;
        this.email = email;
        this.emailNu = emailNu;
        this.phone = phone;
        this.password = password;
    }

    //API constructor
    public AdInsertBase(String type, int category, String subject, String body, int region, String phone, int accountType, String name, int phoneHidden, String lang) {
        //commentaire
        this.type = type;
        this.category = category;
        this.subject = subject;
        this.body = body;
        this.region = region;
        this.name = name;
        this.phone = phone;
        this.accountType = accountType;
        this.phoneHidden = phoneHidden;
        this.lang = lang;
    }

    public String getCarWording() {
        return carWording;
    }

    public String getPhoneWording() {
        return phoneWording;
    }

    public String getImmoWording() {
        return immoWording;
    }

    public String getEmploiWording() {
        return emploiWording;
    }

    public String getInsertionType() {
        return insertionType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public String getCityWording() {
        return cityWording;
    }

    public void setCityWording(String cityWording) {
        this.cityWording = cityWording;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailNu() {
        return emailNu;
    }

    public void setEmailNu(String emailNu) {
        this.emailNu = emailNu;
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

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getPhoneHidden() {
        return phoneHidden;
    }

    public void setPhoneHidden(int phoneHidden) {
        this.phoneHidden = phoneHidden;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}