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
 * Task node that repeats the execution of its child node a specified number of times.
 *
 * The RepeaterNode is a task node that repeats the execution of its child node a specified number of times.
 * It allows for precise control over how many times the child node should be executed before returning success.
 * If the child node returns failure at any point, the repeater node will also return failure.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param times The number of times to repeat the execution of the child node. Use -1 for indefinite repetition.
 * @param child The child behavior node to be repeated.
 */
class RepeaterNode<T>(blackboard: T, val times: Int, val child: BehaviorNode<T>) :
    BehaviorNode<T>(blackboard) {

    // Counter to keep track of the number of repetitions
    private var counter = 0

    /**
     * Executes the repeater node's logic.
     *
     * This method repeats the execution of its child node according to the specified number of times.
     * If the child node returns failure at any point, the repeater node returns failure. If the child node
     * returns running at any point, the repeater node returns running. Otherwise, it returns success.
     *
     * @return The execution status of the repeater node, which can be success, failure, or running.
     */
    override fun execute(): BehaviorStatus {
        while (times == -1 || counter < times) {
            val status = child.execute()
            if (status != BehaviorStatus.RUNNING) {
                counter++
                if (times != -1 && counter >= times) {
                    return status
                }
            } else {
                return BehaviorStatus.RUNNING
            }
        }
        return BehaviorStatus.SUCCESS
    }
}
