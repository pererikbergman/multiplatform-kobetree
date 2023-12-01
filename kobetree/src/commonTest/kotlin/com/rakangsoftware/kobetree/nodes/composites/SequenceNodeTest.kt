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

class SequenceNodeTest {

    @Test
    fun `sequence succeeds when all children succeed`() {
        val blackboard = Blackboard()
        val sequenceNode = SequenceNode(blackboard)

        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS))
        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS))

        assertEquals(BehaviorStatus.SUCCESS, sequenceNode.execute())
    }

    @Test
    fun `sequence fails when any child fails`() {
        val blackboard = Blackboard()
        val sequenceNode = SequenceNode(blackboard)

        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS))
        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.FAILURE))

        assertEquals(BehaviorStatus.FAILURE, sequenceNode.execute())
    }

    @Test
    fun `sequence fails when any child fails regardless of order`() {
        val blackboard = Blackboard()
        val sequenceNode = SequenceNode(blackboard)

        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.FAILURE))
        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS))

        assertEquals(BehaviorStatus.FAILURE, sequenceNode.execute())
    }

    @Test
    fun `sequence returns running if a child is running`() {
        val blackboard = Blackboard()
        val sequenceNode = SequenceNode(blackboard)

        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS))
        sequenceNode.addChild(TestBehaviorNode(blackboard, BehaviorStatus.RUNNING))

        assertEquals(BehaviorStatus.RUNNING, sequenceNode.execute())
    }

    // Mock behavior node for testing purposes
    private class TestBehaviorNode<Blackboard>(
        blackboard: Blackboard,
        private val returnStatus: BehaviorStatus
    ) : BehaviorNode<Blackboard>(blackboard) {
        override fun execute(): BehaviorStatus = returnStatus
    }
}
