/*
 * Copyright 2023 Per-Erik Bergman
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.rakangsoftware.kobetree.core

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

internal class BlackboardTest {

    @Test
    fun `put and get various types`() {
        val blackboard = Blackboard()
        blackboard.put("keyString", "Hello World")
        blackboard.put("keyInt", 123)
        blackboard.put("keyBoolean", true)
        blackboard.put("keyFloat", 123.45f)
        blackboard.put("keyDouble", 123.456)
        blackboard.put("keyLong", 123456789L)
        blackboard.put("keyChar", 'A')
        blackboard.put("keyShort", 123.toShort())

        val retrievedString: String? = blackboard.get("keyString")
        val retrievedInt: Int? = blackboard.get("keyInt")
        val retrievedBoolean: Boolean? = blackboard.get("keyBoolean")
        val retrievedFloat: Float? = blackboard.get("keyFloat")
        val retrievedDouble: Double? = blackboard.get("keyDouble")
        val retrievedLong: Long? = blackboard.get("keyLong")
        val retrievedChar: Char? = blackboard.get("keyChar")
        val retrievedShort: Short? = blackboard.get("keyShort")

        assertEquals("Hello World", retrievedString)
        assertEquals(123, retrievedInt)
        assertEquals(true, retrievedBoolean)
        assertEquals(123.45f, retrievedFloat)
        assertEquals(123.456, retrievedDouble)
        assertEquals(123456789L, retrievedLong)
        assertEquals('A', retrievedChar)
        assertEquals(123.toShort(), retrievedShort)
    }

    @Test
    fun `get nonexistent key returns null`() {
        val blackboard = Blackboard()
        val result: String? = blackboard.get("nonexistentKey")
        assertNull(result)
    }

    @Test
    fun `get with incorrect type returns null`() {
        val blackboard = Blackboard()
        blackboard.put("keyString", "Hello World")

        val retrievedInt: Int? = blackboard.get("keyString")
        assertNull(retrievedInt)
    }

    @Test
    fun `test toString`() {
        val blackboard = Blackboard()
        blackboard.put("key1", "value1")
        blackboard.put("key2", 42)

        val expectedString = "{key1=value1, key2=42}"
        assertEquals(expectedString, blackboard.toString())
    }
}
