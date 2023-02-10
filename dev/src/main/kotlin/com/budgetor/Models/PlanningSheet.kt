package com.budgetor.Models;

import javax.persistence.*;

@Entity
@Table(name = "planning_sheet")
data class PlanningSheet (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : kotlin.Long,
 
    val title : String,
)