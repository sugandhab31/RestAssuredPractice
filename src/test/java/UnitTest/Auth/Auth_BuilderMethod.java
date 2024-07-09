package UnitTest.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class Auth_BuilderMethod {

    @JsonProperty
    @SerializedName("username")
    private String username;

    @JsonProperty
    @SerializedName("password")
    private String password;

    private Auth_BuilderMethod() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Auth_BuilderMethod(AuthBuilder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public static class AuthBuilder{
        String username;
        String password;


        public AuthBuilder withUsername(String username){
            this.username = username;
            return this;
        }

        public AuthBuilder withPassword(String password){
            this.password = password;
            return this;
        }

        public Auth_BuilderMethod build(){
            return new Auth_BuilderMethod(this);
        }
    }





}
