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

package com.rakangsoftware.kobetree.nodes.tasks

import com.rakangsoftware.kobetree.core.BehaviorNode
import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard
import kotlin.test.Test
import kotlin.test.assertEquals

class RepeaterNodeTests {

//    // Test case 1: Check if RepeaterNode returns SUCCESS when times is 0
//    @Test
//    fun `repeater node should return SUCCESS when times is 0`() {
//        val blackboard = Blackboard()
//
//        val child = mock(BehaviorNode::class.java) as BehaviorNode<Blackboard>
//
//        // Create a RepeaterNode with times set to 0
//        val repeaterNode = RepeaterNode(blackboard, 0, child)
//
//        // Execute the RepeaterNode and check if it returns SUCCESS
//        val result = repeaterNode.execute()
//        assertEquals(BehaviorStatus.SUCCESS, result)
//
//        // Verify that the child node was never executed
//        verify(child, never()).execute()
//    }
//
//    // Test case 2: Check if RepeaterNode returns SUCCESS after repeating a certain number of times
//    @Test
//    fun `repeater node should return SUCCESS after repeating a certain number of times`() {
//        val blackboard = Blackboard()
//
//        val child = mock(BehaviorNode::class.java) as BehaviorNode<Blackboard>
//
//        // Create a RepeaterNode with times set to 3
//        val repeaterNode = RepeaterNode(blackboard, 3, child)
//
//        // Mock the child node to return SUCCESS
//        `when`(child.execute()).thenReturn(BehaviorStatus.SUCCESS)
//
//        // Execute the RepeaterNode and check if it returns SUCCESS
//        val result = repeaterNode.execute()
//        assertEquals(BehaviorStatus.SUCCESS, result)
//
//        // Verify that the child node was executed 3 times
//        verify(child, times(3)).execute()
//    }
//
//    // Test case 3: Check if RepeaterNode returns FAILURE if child node returns FAILURE
//    @Test
//    fun `repeater node should return RUNNING if child node returns RUNNING`() {
//        val blackboard = Blackboard()
//        val child = mock(BehaviorNode::class.java) as BehaviorNode<Blackboard>
//
//        // Create a RepeaterNode with times set to 5
//        val repeaterNode = RepeaterNode(blackboard, 5, child)
//
//        // Mock the first execution to return SUCCESS
//        `when`(child.execute()).thenReturn(BehaviorStatus.RUNNING)
//
//        // Execute the RepeaterNode and check if it returns FAILURE
//        val result = repeaterNode.execute()
//        assertEquals(BehaviorStatus.RUNNING, result)
//
//        // Verify that the child node was executed 3 times (until it returned FAILURE)
//        verify(child, times(1)).execute()
//    }
//
//    @Test
//    fun testGetTimes() {
//        // Create a mock Blackboard
//        val blackboard = Blackboard()
//
//        // Create a RepeaterNode with times = 3
//        val child: BehaviorNode<Blackboard> =
//            mock(BehaviorNode::class.java) as BehaviorNode<Blackboard>
//        val repeaterNode = RepeaterNode(blackboard, 3, child)
//
//        // Verify that getTimes() returns the expected value
//        assertEquals(repeaterNode.times, 3)
//    }
//
//    @Test
//    fun testGetChild() {
//        // Create a mock Blackboard
//        val blackboard = Blackboard()
//
//        // Create a mock child BehaviorNode
//        val childNode = mock(BehaviorNode::class.java) as BehaviorNode<Blackboard>
//
//        // Create a RepeaterNode with the mock child
//        val repeaterNode = RepeaterNode(blackboard, 2, childNode)
//
//        // Verify that getChild() returns the expected child node
//        assertEquals(repeaterNode.child, childNode)
//    }
}
