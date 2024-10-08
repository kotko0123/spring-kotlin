package com.example.api.dto

import java.time.LocalDate

data class PersonDto(
  var firstName: String?,
  var lastName: String?,
  var phone: String?,
  var birthdate: LocalDate?
)
