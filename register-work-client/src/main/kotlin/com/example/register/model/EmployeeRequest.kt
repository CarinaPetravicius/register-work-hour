package com.example.register.model

import io.swagger.annotations.ApiModelProperty
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class EmployeeRequest(
        @ApiModelProperty(required = true)
        @field:NotNull(message = "The document number must be informed")
        @field:Size(min = 11, max = 14, message = "The min document size is 11 and the max is 14")
        val documentNumber: Long,

        @ApiModelProperty(required = true)
        @field:NotBlank(message = "The name must be informed")
        @field:Size(max = 255, message = "The max name size is 255 characters")
        val name: String,

        @ApiModelProperty(required = true)
        @field:NotNull(message = "The date of birth must be informed")
        val dateOfBirth: LocalDate,

        @ApiModelProperty(required = true)
        @field:NotNull(message = "The rule must be informed")
        val rule: RuleRequest,

        @ApiModelProperty(required = true)
        @field:NotBlank(message = "The job description must be informed")
        @field:Size(max = 100, message = "The max job description size is 100 characters")
        val jobDescription: String,

        @ApiModelProperty(required = true)
        @field:NotNull(message = "The admission date must be informed")
        val admissionDate: LocalDate
)