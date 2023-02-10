package com.budgetor.Models;

import com.budgetor.Models.User;
import com.budgetor.Models.PlanningSheet;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="user_role")
data class UserRole (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : kotlin.Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user : User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "planning_sheet_id", nullable = false)
    val context : PlanningSheet,

    @Column(name="type")
    @JsonProperty("type")
    val type : String,
)