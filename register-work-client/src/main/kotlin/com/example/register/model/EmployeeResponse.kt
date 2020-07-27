package com.example.register.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate

data class EmployeeResponse(
        @ApiModelProperty(required = true)
        val documentNumber: Long,

        @ApiModelProperty(required = true)
        val name: String,

        @ApiModelProperty(required = true)
        @JsonDeserialize(using = LocalDateDeserializer::class)
        @JsonFormat(pattern = "yyyy-MM-dd")
        val dateOfBirth: LocalDate,

        @ApiModelProperty(required = true)
        val rule: String,

        @ApiModelProperty(required = true)
        val jobDescription: String,

        @ApiModelProperty(required = true)
        @JsonDeserialize(using = LocalDateDeserializer::class)
        @JsonFormat(pattern = "yyyy-MM-dd")
        val admissionDate: LocalDate
)