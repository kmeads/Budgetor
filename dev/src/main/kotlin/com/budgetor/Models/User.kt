package com.budgetor.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.collections.mutableListOf;

import javax.persistence.*;

@Entity
@Table(name="user")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : kotlin.Int,

    @JsonProperty("email")
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
)