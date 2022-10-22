package com.budgetor.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.collections.mutableListOf;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name="user")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : kotlin.Int,

    @JsonProperty("email")
    @Column(unique = true)
    var email : String,

    @JsonProperty("password")
    var password : String,

    @Column(name="first_name")
    @JsonProperty("first_name")
    var firstName : String,

    @Column(name="last_name")
    @JsonProperty("last_name")
    var lastName : String,

    @Column(name="phone_number")
    @JsonProperty("phone_number")
    var phoneNumber : String,
    
    // @OneToMany
    // var userRoles : MutableList<UserRole> = mutableListOf<UserRole>()
) {
    init {
        this.password = BCryptPasswordEncoder().encode(this.password); // encrypts password of user *before* it enters the DB
    }

    fun authenticate(challenge : String) : Boolean = BCryptPasswordEncoder().matches(challenge, this.password);
}