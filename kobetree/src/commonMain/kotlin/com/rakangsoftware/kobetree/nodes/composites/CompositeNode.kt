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

import com.rakangsoftware.kobetree.core.BehaviorNode
import com.rakangsoftware.kobetree.core.Blackboard
import com.rakangsoftware.kobetree.core.NodeContainer

/**
 * Abstract base class for composite nodes, which can contain child nodes.
 *
 * Composite nodes are a fundamental part of behavior trees and serve as containers for organizing and managing
 * child behavior nodes. This class provides a common base for all composite nodes within the behavior tree.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 */
abstract class CompositeNode<T>(blackboard: T) : NodeContainer<T>(blackboard) {

    // Private list to store child BehaviorNodes
    private val _children = mutableListOf<BehaviorNode<T>>()

    /**
     * The list of child BehaviorNodes contained within this composite node.
     */
    override val children: MutableList<BehaviorNode<T>> get() = _children

    /**
     * Adds a child BehaviorNode to this composite node.
     *
     * @param node The child BehaviorNode to add to this composite node.
     */
    override fun addChild(node: BehaviorNode<T>) {
        _children.add(node)
    }
}
