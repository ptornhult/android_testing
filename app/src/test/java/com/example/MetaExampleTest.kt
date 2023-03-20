package com.example

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class MetaExampleTest {

@Test
fun `two returns 2 and calls one only once`() {
  val example: Example = mockk { every { one() } returns 1 }
  val metaExample = MetaExample(example)

  assertEquals(2, metaExample.two())
  verify(exactly = 1) { example.one() }
}
}