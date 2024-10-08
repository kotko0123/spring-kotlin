package com.example.core.domain

import java.time.LocalDate

data class Person(
  var firstName: String?,
  var lastName: String?,
  var phoneNumber: String?,
  var birthdate: LocalDate?
)
