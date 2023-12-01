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

import com.rakangsoftware.kobetree.core.BehaviorNode
import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard

/**
 * Task node that executes a condition and returns success or failure based on the condition's result.
 *
 * The ConditionNode is a task node that executes a provided condition and returns success if the condition
 * evaluates to `true`, or failure if it evaluates to `false`.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param condition The condition to execute, represented as a lambda that returns a boolean value.
 */
class ConditionNode<T>(blackboard: T, val condition: () -> Boolean) :
    BehaviorNode<T>(blackboard) {

    /**
     * Executes the condition node's logic.
     *
     * This method evaluates the provided condition and returns success if the condition is `true`,
     * or failure if the condition is `false`.
     *
     * @return The execution status of the condition node, which is either success or failure.
     */
    override fun execute(): BehaviorStatus {
        return if (condition()) {
            BehaviorStatus.SUCCESS
        } else {
            BehaviorStatus.FAILURE
        }
    }
}
