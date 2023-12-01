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

class ConditionNodeTests {



    // Test case 1: Check if ConditionNode returns SUCCESS when the condition is true
    @Test
    fun `condition node should return SUCCESS when condition is true`() {
        val blackboard = Blackboard()
        // Create a ConditionNode with a condition that is true
        val conditionNode = ConditionNode(blackboard) {
            true
        }

        // Execute the ConditionNode and check if it returns SUCCESS
        val result = conditionNode.execute()
        assertEquals(BehaviorStatus.SUCCESS, result)
    }

    // Test case 2: Check if ConditionNode returns FAILURE when the condition is false
    @Test
    fun `condition node should return FAILURE when condition is false`() {
        val blackboard = Blackboard()
        // Create a ConditionNode with a condition that is false
        val conditionNode = ConditionNode(blackboard) {
            false
        }

        // Execute the ConditionNode and check if it returns FAILURE
        val result = conditionNode.execute()
        assertEquals(BehaviorStatus.FAILURE, result)
    }

    @Test
    fun `condition node should return the expected condition`() {
        val blackboard = Blackboard()
        // Create a ConditionNode with a condition that returns true
        val condition = {
            true
        }
        val conditionNode = ConditionNode(blackboard, condition)

        // Verify that the condition node's condition matches the expected condition
        assertEquals(conditionNode.condition, condition)
    }
}
