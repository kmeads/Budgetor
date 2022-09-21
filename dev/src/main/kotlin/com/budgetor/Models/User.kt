package com.budgetor.Models;

import com.budgetor.Models.UserRole;
import com.fasterxml.jackson.annotation.JsonProperty;

data class User (
    @JsonProperty("email")
    var email : String,

    @JsonProperty("password")
    var password : String,

    @JsonProperty("first_name")
    var firstName : String,

    @JsonProperty("last_name")
    var lastName : String,

    @JsonProperty("phone_number")
    var phoneNumber : String
) {
    var UserRoles : MutableList<UserRole>;

    init {
        UserRoles = mutableListOf<UserRole>();
    }
}