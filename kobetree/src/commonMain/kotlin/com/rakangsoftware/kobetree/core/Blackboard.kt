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

/**
 * Class representing a shared data store for behavior tree nodes, allowing for inter-node communication.
 *
 * The Blackboard class serves as a data store that enables communication and data sharing among
 * behavior tree nodes. It provides methods for storing and retrieving data associated with specific keys.
 */
public class Blackboard {
    // Mutable map to store data with keys
    val data = mutableMapOf<String, Any>()

    /**
     * Store a value with an associated key in the blackboard.
     *
     * @param key The key used to identify the stored value.
     * @param value The value to be stored in the blackboard.
     */
    public fun put(key: String, value: Any) {
        data[key] = value
    }

    /**
     * Retrieve a value by key from the blackboard, cast to the expected type.
     *
     * @param key The key used to identify the stored value.
     * @return The retrieved value, cast to the expected type, or null if the key is not found.
     */
    public inline fun <reified T> get(key: String): T? {
        return data[key] as? T
    }

    /**
     * Returns a string representation of the blackboard's data.
     *
     * @return A string containing the key-value pairs stored in the blackboard.
     */
    public override fun toString(): String {
        return data.toString()
    }
}
