package com.example

import android.net.Uri
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ExampleTest {

  private lateinit var example: Example

  @Before
  fun setUp() {
    // Given
    example = Example()
  }

  @Test
  fun `basic tests should work`() {
    assertEquals(2, 1 + 1)
    assertNotEquals(1, 2)
    assertTrue(true)
    assertFalse(false)
    assertNull(null)
    assertNotNull(1)
    assertSame(1, 1)
    assertNotSame(128, 128)
    assertArrayEquals(emptyArray<Int>(), arrayOf())
  }

  @Test(expected = ArrayIndexOutOfBoundsException::class)
  fun `test exception old style`() {
    emptyArray<Int>()[0]
  }

  @Test
  fun `test exceptions new style`() {
    assertThrows(ArrayIndexOutOfBoundsException::class.java) {
      emptyArray<Int>()[0]
    }
  }

  @Test
  fun `one should return 1`() {
    assertEquals(1, example.one())
  }

  @Test
  fun `isOne should return true for input 1`() {
    assertTrue(example.isOne(1))
    assertFalse(example.isOne(-1))
    assertFalse(example.isOne(0))
    assertFalse(example.isOne(2))
  }

  @Test
  fun `state can be changed`() {
    assertNull(example.state)
    example.state = 1_000L
    assertEquals(1_000L, example.state)
  }

  @Test(expected = RuntimeException::class)
  fun `uri parse should throw`() {
    val url = "http://www.google.com"
    val result = Uri.parse(url)
    assertEquals(url, result.toString())
  }
}