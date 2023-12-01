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

class SelectorNodeTest {

    @Test
    fun `selector succeeds when first child succeeds`() {
        val blackboard = Blackboard()
        val selectorNode = SelectorNode(blackboard)

        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS))
        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.FAILURE))

        assertEquals(BehaviorStatus.SUCCESS, selectorNode.execute())
    }

    @Test
    fun `selector succeeds when second child succeeds`() {
        val blackboard = Blackboard()
        val selectorNode = SelectorNode(blackboard)

        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.FAILURE))
        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS))

        assertEquals(BehaviorStatus.SUCCESS, selectorNode.execute())
    }

    @Test
    fun `selector fails when all children fail`() {
        val blackboard = Blackboard()
        val selectorNode = SelectorNode(blackboard)

        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.FAILURE))
        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.FAILURE))

        assertEquals(BehaviorStatus.FAILURE, selectorNode.execute())
    }

    @Test
    fun `selector returns running if a child is running`() {
        val blackboard = Blackboard()
        val selectorNode = SelectorNode(blackboard)

        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.FAILURE))
        selectorNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.RUNNING))

        assertEquals(BehaviorStatus.RUNNING, selectorNode.execute())
    }

    // Mock behavior node for testing purposes
    private class TestBehaviorNode<Blackboard>(
        blackboard: Blackboard,
        private val returnStatus: BehaviorStatus
    ) : BehaviorNode<Blackboard>(blackboard) {
        override fun execute(): BehaviorStatus = returnStatus
    }
}
