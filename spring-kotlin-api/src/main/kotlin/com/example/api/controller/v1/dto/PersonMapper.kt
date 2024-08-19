package com.example.api.dto

import com.example.core.domain.Person
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingConstants.ComponentModel.SPRING

@Mapper(componentModel = SPRING)
interface PersonMapper {

  @Mapping(source = "phoneNumber", target = "phone")
  fun convertToDto(person: Person): PersonDto

  @Mapping(source = "phoneNumber", target = "phone")
  fun convertListToDtos(persons: List<Person>): List<PersonDto>

  @InheritInverseConfiguration
  fun convertToModel(personDto: PersonDto): Person
  fun convertListToModels(personDtos: List<PersonDto>): List<Person>
}