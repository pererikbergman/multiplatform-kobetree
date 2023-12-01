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

package com.rakangsoftware.kobetree.nodes.tasks

import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard
import kotlin.test.Test
import kotlin.test.assertEquals

class TaskNodeTests {

    // Test case 1: Check if TaskNode returns the correct BehaviorStatus
    @Test
    fun `task node should return BehaviorStatus`() {
        val blackboard = Blackboard()
        // Create a TaskNode with a task that returns a specific status
        val expectedStatus = BehaviorStatus.SUCCESS
        val taskNode = TaskNode(blackboard) {
            expectedStatus
        }

        // Execute the TaskNode and check if it returns the expected status
        val result = taskNode.execute()
        assertEquals(expectedStatus, result)
    }

    // Test case 2: Check if TaskNode returns the correct BehaviorStatus for another status
    @Test
    fun `task node should return a different BehaviorStatus`() {
        val blackboard = Blackboard()
        // Create a TaskNode with a task that returns a different status
        val expectedStatus = BehaviorStatus.FAILURE
        val taskNode = TaskNode(blackboard) {
            expectedStatus
        }

        // Execute the TaskNode and check if it returns the expected status
        val result = taskNode.execute()
        assertEquals(expectedStatus, result)
    }

    @Test
    fun `task node should return the expected task`() {
        val blackboard = Blackboard()
        // Create a TaskNode with a task that returns a different status
        val expectedStatus = BehaviorStatus.FAILURE
        val task = {
            expectedStatus
        }
        val taskNode = TaskNode(blackboard, task)

        // Verify that the task node's task matches the expected task
        assertEquals(taskNode.task, task)
    }
}

