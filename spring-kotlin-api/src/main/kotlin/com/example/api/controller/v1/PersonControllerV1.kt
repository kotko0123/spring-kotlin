package com.example.api.controller.v1

import com.example.api.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonControllerV1(
  private val personService: PersonService
) {

  @GetMapping("convert")
  fun convert(): String {
    personService.testConvert()
    return "OK"
  }
}