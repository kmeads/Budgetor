package com.budgetor.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import kotlin.collections.mutableListOf;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.GrantedAuthority

import javax.persistence.*;
import java.sql.Date

@Entity
@Table(name="user")
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : kotlin.Long,

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

    @Column(name="account_creation_date")
    @JsonProperty("account_creation_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var accountCreated : Date,

    @Column(name="password_changed_date")
    @JsonProperty("password_changed_date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    var datePasswordChanged : Date,

    @Column(name="is_account_locked")
    @JsonProperty("is_account_locked")
    var isAccountLocked : Boolean,
    
    // @OneToMany
    // var userRoles : MutableList<UserRole> = mutableListOf<UserRole>()
) {
    init {
        this.password = BCryptPasswordEncoder(10).encode(this.password); // encrypts password of user *before* it enters the DB
    }

    fun authenticate(challenge : String) : Boolean = BCryptPasswordEncoder().matches(challenge, this.password);
}

/* This class represents the 'User' role type that logs into the application */
class SecurityUser(var user : User) : UserDetails {
    override fun getUsername() : String = user.email;
    override fun getPassword() : String = user.password;

    //different roles the User can take
    override fun getAuthorities() : MutableCollection<GrantedAuthority> = mutableListOf<GrantedAuthority> (SimpleGrantedAuthority(if(user.email == "admin") "ROLE_ADMIN" else "ROLE_USER"))

    override fun isAccountNonExpired() : Boolean = true;
    override fun isAccountNonLocked() : Boolean = !user.isAccountLocked;
    override fun isCredentialsNonExpired() : Boolean = true;
    override fun isEnabled() : Boolean = true;
}
