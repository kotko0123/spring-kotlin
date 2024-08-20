package com.example.api.service

import com.example.api.dto.PersonMapper
import com.example.core.domain.Person
import com.example.core.log.logger
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PersonService(
  private val personMapper: PersonMapper
) {
  companion object {
    private val log = logger()
  }

  fun testConvert() {
//    val personMapper = Mappers.getMapper(PersonMapper::class.java)

    val person = Person("Samuel", "Jackson", "0123 334466", LocalDate.of(1948, 12, 21))

    val personDto = personMapper.convertToDto(person)
    println(personDto)

    val personModel = personMapper.convertToModel(personDto)
    println(personModel)

    val persons = mutableListOf(person, personModel)
    log.info { "persons(${persons.size}): $persons" }

    val personDtos = personMapper.convertListToDtos(persons)
    log.info { "personDtos(${personDtos.size}): $personDtos" }

    val personList = personMapper.convertListToModels(personDtos)
    log.info { "personList(${personList.size}): $personList" }
  }
}