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
 * Task node that executes a provided task and returns the task's execution status.
 *
 * The TaskNode is a task node that executes a provided task, represented as a lambda, and returns the execution status
 * returned by the task. This allows for flexibility in defining custom tasks to be used within a behavior tree.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param task The task to execute, represented as a lambda that returns a BehaviorStatus.
 */
class TaskNode<T>(blackboard: T, val task: () -> BehaviorStatus) : BehaviorNode<T>(blackboard) {

    /**
     * Executes the task node's logic.
     *
     * This method executes the provided task and returns the execution status returned by the task.
     *
     * @return The execution status of the task node, which is determined by the executed task.
     */
    override fun execute(): BehaviorStatus {
        return task()
    }
}
