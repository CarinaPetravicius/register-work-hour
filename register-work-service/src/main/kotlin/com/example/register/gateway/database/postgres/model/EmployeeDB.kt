package com.example.register.gateway.database.postgres.model

import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "employee")
class EmployeeDB(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,

        @Column(nullable = false)
        val documentNumber: Long,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false)
        val dateOfBirth: LocalDate,

        @Column(nullable = false)
        val rule: String,

        @Column(nullable = false)
        val jobDescription: String,

        @Column(nullable = false)
        val admissionDate: LocalDate,

        @Column(nullable = true)
        val resignationDate: LocalDate? = null,

        @Column(nullable = false)
        val active: Boolean,

        @Column(nullable = false)
        val createdDate: LocalDateTime? = null,

        @Column(nullable = true)
        val updatedDate: LocalDateTime? = null
)