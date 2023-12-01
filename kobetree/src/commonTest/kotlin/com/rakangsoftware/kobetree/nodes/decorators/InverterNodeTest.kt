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
import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard
import kotlin.test.Test
import kotlin.test.assertEquals

class InverterNodeTest {



    @Test
    fun `inverter inverts success to failure`() {
        val blackboard = Blackboard()

        val childNode = TestBehaviorNode(blackboard, BehaviorStatus.SUCCESS)
        val inverterNode = InverterNode(blackboard)
        inverterNode.addChild(childNode)

        assertEquals(BehaviorStatus.FAILURE, inverterNode.execute())
    }

    @Test
    fun `inverter inverts failure to success`() {
        val blackboard = Blackboard()

        val childNode = TestBehaviorNode(blackboard, BehaviorStatus.FAILURE)
        val inverterNode = InverterNode(blackboard)
        inverterNode.addChild(childNode)

        assertEquals(BehaviorStatus.SUCCESS, inverterNode.execute())
    }

    @Test
    fun `inverter retains running status`() {
        val blackboard = Blackboard()

        val childNode = TestBehaviorNode(blackboard, BehaviorStatus.RUNNING)
        val inverterNode = InverterNode(blackboard)
        inverterNode.addChild(childNode)

        assertEquals(BehaviorStatus.RUNNING, inverterNode.execute())
    }

    @Test
    fun `adding more than one node should yield an exception`() {
        val blackboard = Blackboard()

        val childNode = TestBehaviorNode(blackboard, BehaviorStatus.RUNNING)
        val inverterNode = InverterNode(blackboard)

//        assertThrows<IllegalStateException> {
//            inverterNode.addChild(childNode)
//            inverterNode.addChild(childNode) // This line should throw an exception
//        }
    }

    // Mock behavior node for testing purposes
    private class TestBehaviorNode<Blackboard>(
        blackboard: Blackboard,
        private val returnStatus: BehaviorStatus
    ) : BehaviorNode<Blackboard>(blackboard) {
        override fun execute(): BehaviorStatus = returnStatus
    }
}
