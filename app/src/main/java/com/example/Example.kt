package com.example

import androidx.annotation.VisibleForTesting

class Example {
  @VisibleForTesting
  internal var state: Any? = null

  fun one() = 1

  fun isOne(input: Int): Boolean = input == 1
}