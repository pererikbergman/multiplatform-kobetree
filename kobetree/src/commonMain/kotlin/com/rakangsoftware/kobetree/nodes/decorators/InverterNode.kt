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

package com.rakangsoftware.kobetree.nodes.decorators

import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard

/**
 * Decorator node that inverts the result of its single child's execution.
 *
 * The InverterNode is a decorator node that has exactly one child node. It executes its child node and
 * inverts the result, turning success into failure and vice versa. If the child returns running, the inverter
 * also returns running.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 */
class InverterNode<T>(blackboard: T) : DecoratorNode<T>(blackboard) {

    /**
     * Executes the inverter node's logic.
     *
     * This method executes its single child and inverts the result. Success becomes failure, failure becomes success,
     * and running remains running.
     *
     * @return The inverted execution status of the inverter node.
     */
    override fun execute(): BehaviorStatus {
        val child = children.firstOrNull()
        return when (val status = child!!.execute()) {
            BehaviorStatus.SUCCESS -> BehaviorStatus.FAILURE
            BehaviorStatus.FAILURE -> BehaviorStatus.SUCCESS
            else -> status
        }
    }
}
