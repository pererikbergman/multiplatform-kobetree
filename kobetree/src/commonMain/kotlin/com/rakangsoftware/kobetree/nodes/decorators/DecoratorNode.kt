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

import com.rakangsoftware.kobetree.core.BehaviorNode
import com.rakangsoftware.kobetree.core.Blackboard
import com.rakangsoftware.kobetree.core.NodeContainer

/**
 * Abstract base class for decorator nodes in a behavior tree.
 *
 * Decorator nodes are a category of behavior tree nodes that modify the behavior of a single child node.
 * This class provides a common base for all decorator nodes and enforces that they can only have one child.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 */
abstract class DecoratorNode<T>(blackboard: T) : NodeContainer<T>(blackboard) {

    // Private list to store the single child BehaviorNode
    private val _children = mutableListOf<BehaviorNode<T>>()

    /**
     * The single child BehaviorNode contained within this decorator node.
     */
    override val children: MutableList<BehaviorNode<T>> get() = _children

    /**
     * Adds a child BehaviorNode to this decorator node.
     *
     * This method enforces that a decorator node can only have one child. If an attempt is made to add
     * multiple children, it will throw an IllegalStateException.
     *
     * @param node The child BehaviorNode to add to this decorator node.
     * @throws IllegalStateException if an attempt is made to add more than one child.
     */
    override fun addChild(node: BehaviorNode<T>) {
        if (_children.isEmpty()) {
            _children.add(node)
        } else {
            throw IllegalStateException("DecoratorNode can only have one child.")
        }
    }
}
