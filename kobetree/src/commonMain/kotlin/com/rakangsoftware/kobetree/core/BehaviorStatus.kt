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
 * Enum representing the possible statuses of behavior tree nodes execution.
 *
 * This enum defines the different execution statuses that a behavior tree node can have when its logic is executed.
 * - `SUCCESS`: Indicates that the node's execution was successful.
 * - `FAILURE`: Indicates that the node's execution resulted in failure.
 * - `RUNNING`: Indicates that the node's execution is currently running and has not yet completed.
 */
enum class BehaviorStatus {
    /**
     * Indicates that the node's execution was successful.
     */
    SUCCESS,

    /**
     * Indicates that the node's execution resulted in failure.
     */
    FAILURE,

    /**
     * Indicates that the node's execution is currently running and has not yet completed.
     */
    RUNNING
}
