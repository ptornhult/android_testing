package com.example

import android.net.Uri
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ExampleTest {
  private lateinit var example: Example
  private lateinit var exampleMock: Example
  private lateinit var exampleSpy: Example
  private lateinit var exampleRepo: ExampleRepo

  @Before
  fun setUp() {
    exampleRepo = object : ExampleRepo {
      override fun one(): Int = 1
    }
    example = Example()
    exampleMock = mockk()
    exampleSpy = spyk(example)
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

  @Test
  fun `isNotOne calls isOne once`() {
    exampleSpy.isNotOne(2)
    verify { exampleSpy.isOne(any()) }
    verify(exactly = 1) { exampleSpy.isOne(2) }
    verify(exactly = 0) { exampleSpy.isOne(1) }
  }
}