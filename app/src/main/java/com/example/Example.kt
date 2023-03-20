package com.example

import androidx.annotation.VisibleForTesting

interface ExampleRepo {
  fun one(): Int
}

class Example : ExampleRepo {
  fun isNotOne(input: Int): Boolean =
    !isOne(input)

  fun isOne(input: Int): Boolean = input == 1

  @VisibleForTesting
  internal var state: Any? = null


  override fun one() = 1
}

class MetaExample(
  private val exampleRepo: ExampleRepo,
) {
  fun two() = exampleRepo.one() * 2
}