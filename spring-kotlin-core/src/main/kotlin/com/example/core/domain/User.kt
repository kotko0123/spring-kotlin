package com.example.core.domain

import jakarta.persistence.*

@Entity
class User (

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  var id: Long,

  var name: String,

  var age: Int
) {
  override fun toString(): String {
    return "User(id=$id, name='$name', age=$age)"
  }
}