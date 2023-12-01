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
import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard
import kotlin.test.Test
import kotlin.test.assertEquals

class CompositeNodeTest {

    @Test
    fun `addChild adds a node correctly`() {
        val blackboard = Blackboard()
        val compositeNode = TestCompositeNode(blackboard)

        val childNode = TestBehaviorNode(blackboard)

        compositeNode.addChild(childNode)

        assertEquals(1, compositeNode.getChildrenCount())
    }

    @Test
    fun `addChild adds multiple nodes correctly`() {
        val blackboard = Blackboard()
        val compositeNode = TestCompositeNode(blackboard)

        val childNode1 = TestBehaviorNode(blackboard)
        val childNode2 = TestBehaviorNode(blackboard)

        compositeNode.addChild(childNode1)
        compositeNode.addChild(childNode2)

        assertEquals(2, compositeNode.getChildrenCount())
    }

    // Concrete subclass for testing
    private class TestCompositeNode(blackboard: Blackboard) : CompositeNode<Blackboard>(blackboard) {
        override fun execute(): BehaviorStatus {
            // Implementation for testing
            return BehaviorStatus.SUCCESS
        }

        fun getChildrenCount() = children.size
    }

    // Mock behavior node for testing purposes
    private class TestBehaviorNode(blackboard: Blackboard) : BehaviorNode<Blackboard>(blackboard) {
        override fun execute(): BehaviorStatus {
            // Implementation for testing
            return BehaviorStatus.SUCCESS
        }
    }
}
