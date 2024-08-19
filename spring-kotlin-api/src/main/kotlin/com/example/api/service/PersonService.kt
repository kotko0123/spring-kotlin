package com.example.api.service

import com.example.api.dto.PersonMapper
import com.example.core.domain.Person
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PersonService {

  fun testConvert() {

    val converter = Mappers.getMapper(PersonMapper::class.java)

    val person = Person("Samuel", "Jackson", "0123 334466", LocalDate.of(1948, 12, 21))

    val personDto = converter.convertToDto(person)
    println(personDto)

    val personModel = converter.convertToModel(personDto)
    println(personModel)
  }
}