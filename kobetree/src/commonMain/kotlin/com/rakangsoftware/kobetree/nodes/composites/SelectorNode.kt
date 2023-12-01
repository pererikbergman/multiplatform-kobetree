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

package com.rakangsoftware.kobetree.nodes.composites

import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard

/**
 * Composite node that represents a selector in a behavior tree.
 *
 * The SelectorNode is a composite node that iterates through its child nodes and executes them in sequence until
 * it encounters a child that returns success. If any child succeeds, the selector returns success; otherwise, it returns failure.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 */
open class SelectorNode<T>(blackboard: T) : CompositeNode<T>(blackboard) {

    /**
     * Executes the selector node's logic.
     *
     * This method iterates through the child nodes and executes them in sequence. If any child returns success,
     * the selector returns success. Otherwise, it returns failure.
     *
     * @return The execution status of the selector node, which is either success or failure.
     */
    override fun execute(): BehaviorStatus {
        for (child in children) {
            val status = child.execute()
            if (status != BehaviorStatus.FAILURE) {
                return status
            }
        }
        return BehaviorStatus.FAILURE
    }
}
