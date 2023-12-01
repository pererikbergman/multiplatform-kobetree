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
 * Abstract base class for all nodes within the behavior tree.
 *
 * This class serves as the fundamental base for all nodes in the behavior tree hierarchy. It defines
 * the common interface for executing a behavior node's logic.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 */
abstract class BehaviorNode<T>(val blackboard: T) {
    /**
     * Execute the behavior node's logic and return the execution status.
     *
     * This method is called to perform the specific logic associated with the behavior node. Subclasses
     * of BehaviorNode must implement this method to define their unique behavior.
     *
     * @return The execution status of the behavior node.
     */
    abstract fun execute(): BehaviorStatus
}
