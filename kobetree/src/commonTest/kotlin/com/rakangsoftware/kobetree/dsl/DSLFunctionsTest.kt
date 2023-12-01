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

package com.rakangsoftware.kobetree.dsl

import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard
import com.rakangsoftware.kobetree.nodes.tasks.TaskNode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DSLFunctionsTest {

    @Test
    fun `test creating a SelectorNode with tasks`() {
        // Create a mock Blackboard
        val blackboard = Blackboard()

        // Create a selector using the DSL
        val selector = selector(blackboard) {
            task { BehaviorStatus.SUCCESS }
            task { BehaviorStatus.FAILURE }
        }

        // Ensure that the selector contains two children
        assertEquals(selector.children.size, 2)

        // Ensure that the children are of type TaskNode
        assertTrue(selector.children.all { it is TaskNode })
    }

    @Test
    fun `test creating a SequenceNode with tasks`() {
        // Create a mock Blackboard
        val blackboard = Blackboard()

        // Create a sequence using the DSL
        val sequence = sequence(blackboard) {
            task { BehaviorStatus.SUCCESS }
            task { BehaviorStatus.RUNNING }
        }

        // Ensure that the sequence contains two children
        assertEquals(sequence.children.size, 2)

        // Ensure that the children are of type TaskNode
        assertTrue(sequence.children.all { it is TaskNode })
    }

    @Test
    fun `test creating an InverterNode with a task`() {
        // Create a mock Blackboard
        val blackboard = Blackboard()

        // Create an inverter using the DSL
        val inverter = inverter(blackboard) {
            task { BehaviorStatus.FAILURE }
        }

        // Ensure that the inverter contains one child
        assertEquals(inverter.children.size, 1)

        // Ensure that the child is of type TaskNode
        assertTrue(inverter.children[0] is TaskNode)
    }

    @Test
    fun `test creating a TaskNode with a task`() {
        // Create a mock Blackboard
        val blackboard = Blackboard()

        // Create a task using the DSL
        val taskNode = task(blackboard) {
            BehaviorStatus.SUCCESS
        }

        // Ensure that the task node returns SUCCESS
        assertEquals(taskNode.execute(), BehaviorStatus.SUCCESS)
    }

    @Test
    fun `test creating a ConditionNode with a true condition`() {
        // Create a mock Blackboard
        val blackboard = Blackboard()

        // Create a condition using the DSL
        val conditionNode = condition(blackboard) {
            true
        }

        // Ensure that the condition node returns SUCCESS when the condition is true
        assertEquals(conditionNode.execute(), BehaviorStatus.SUCCESS)

        // Ensure that the condition node returns FAILURE when the condition is false
        val conditionNodeFalse = condition(blackboard) {
            false
        }
        assertEquals(conditionNodeFalse.execute(), BehaviorStatus.FAILURE)
    }
}
