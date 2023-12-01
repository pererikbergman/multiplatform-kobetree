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

package com.rakangsoftware.kobetree.core

/**
 * Abstract base class for containers of BehaviorNodes.
 *
 * This class is designed to be extended by specific container classes that organize and manage
 * child BehaviorNodes within a behavior tree.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 */
abstract class NodeContainer<T>(blackboard: T) : BehaviorNode<T>(blackboard) {

    /**
     * The list to store child BehaviorNodes.
     *
     * This list contains the child BehaviorNodes managed by the container.
     */
    abstract val children: MutableList<BehaviorNode<T>>

    /**
     * Adds a child BehaviorNode to the container.
     *
     * Subclasses must implement this method to specify how child nodes are added to the container.
     *
     * @param node The child BehaviorNode to add.
     */
    abstract fun addChild(node: BehaviorNode<T>)
}
