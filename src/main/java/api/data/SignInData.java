package api.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"email","password","rememberMe"})
public class SignInData {
    private String email;
    private String password;
    private int rememberMe;
    @JsonIgnore
    private String badpassword;
    @JsonIgnore
    private String accountId;

    public SignInData(String email, String password, int rememberMe) {
        this.email = email;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public SignInData(String email, String password, String badpassword) {
        this.email = email;
        this.password = password;
        this.badpassword = badpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(int rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getBadpassword() {
        return badpassword;
    }

    public void setBadpassword(String badpassword) {
        this.badpassword = badpassword;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}