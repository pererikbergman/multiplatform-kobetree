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

package com.rakangsoftware.kobetree.dsl

import com.rakangsoftware.kobetree.core.BehaviorNode
import com.rakangsoftware.kobetree.core.BehaviorStatus
import com.rakangsoftware.kobetree.core.Blackboard
import com.rakangsoftware.kobetree.core.NodeContainer
import com.rakangsoftware.kobetree.nodes.composites.SelectorNode
import com.rakangsoftware.kobetree.nodes.composites.SequenceNode
import com.rakangsoftware.kobetree.nodes.decorators.InverterNode
import com.rakangsoftware.kobetree.nodes.tasks.ConditionNode
import com.rakangsoftware.kobetree.nodes.tasks.TaskNode

/**
 * DSL function for creating a SelectorNode with child nodes.
 *
 * This function creates a SelectorNode, a composite node that selects and executes one of its child nodes.
 * It allows you to define child nodes within a lambda block using the [init] parameter.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param init A lambda block where you can define child nodes for the SelectorNode.
 * @return The created SelectorNode with its child nodes.
 */
fun <T> selector(blackboard: T, init: NodeContainer<T>.() -> Unit): NodeContainer<T> {
    val selector = SelectorNode(blackboard)
    selector.init()
    return selector
}

/**
 * DSL function for adding child nodes to a SelectorNode.
 *
 * This function adds child nodes to an existing SelectorNode, allowing you to define child nodes within a lambda block using the [init] parameter.
 *
 * @param init A lambda block where you can define child nodes to be added to the SelectorNode.
 */
fun <T> NodeContainer<T>.selector(init: NodeContainer<T>.() -> Unit) {
    val childNode = SelectorNode(this.blackboard)
    childNode.init()
    children.add(childNode)
}

/**
 * DSL function for creating a SequenceNode with child nodes.
 *
 * This function creates a SequenceNode, a composite node that executes its child nodes in sequence until one returns failure.
 * It allows you to define child nodes within a lambda block using the [init] parameter.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param init A lambda block where you can define child nodes for the SequenceNode.
 * @return The created SequenceNode with its child nodes.
 */
fun <T> sequence(blackboard: T, init: NodeContainer<T>.() -> Unit): NodeContainer<T> {
    val selector = SequenceNode<T>(blackboard)
    selector.init()
    return selector
}

/**
 * DSL function for adding child nodes to a SequenceNode.
 *
 * This function adds child nodes to an existing SequenceNode, allowing you to define child nodes within a lambda block using the [init] parameter.
 *
 * @param init A lambda block where you can define child nodes to be added to the SequenceNode.
 */
fun <T> NodeContainer<T>.sequence(init: NodeContainer<T>.() -> Unit) {
    val childNode = SequenceNode(this.blackboard)
    childNode.init()
    children.add(childNode)
}

/**
 * DSL function for creating an InverterNode with child nodes.
 *
 * This function creates an InverterNode, a decorator node that inverts the result of its child node's execution.
 * It allows you to define child nodes within a lambda block using the [init] parameter.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param init A lambda block where you can define child nodes for the InverterNode.
 * @return The created InverterNode with its child nodes.
 */
fun <T> inverter(blackboard: T, init: NodeContainer<T>.() -> Unit): NodeContainer<T> {
    val inverter = InverterNode(blackboard)
    inverter.init()
    return inverter
}

/**
 * DSL function for adding child nodes to an InverterNode.
 *
 * This function adds child nodes to an existing InverterNode, allowing you to define child nodes within a lambda block using the [init] parameter.
 *
 * @param init A lambda block where you can define child nodes to be added to the InverterNode.
 */
fun <T> NodeContainer<T>.inverter(init: NodeContainer<T>.() -> Unit) {
    val inverter = InverterNode(this.blackboard)
    inverter.init()
    children.add(inverter)
}

/**
 * DSL function for creating a TaskNode with a custom task.
 *
 * This function creates a TaskNode, a task node that executes a custom task defined as a lambda.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param task A lambda representing the custom task to be executed.
 * @return The created TaskNode.
 */
fun <T> task(blackboard: T, task: () -> BehaviorStatus): BehaviorNode<T> {
    return TaskNode(blackboard, task)
}

/**
 * DSL function for adding a TaskNode with a custom task to a NodeContainer.
 *
 * This function adds a TaskNode with a custom task to an existing NodeContainer.
 *
 * @param task A lambda representing the custom task to be executed.
 */
fun <T> NodeContainer<T>.task(task: () -> BehaviorStatus) {
    val childNode = TaskNode(this.blackboard, task)
    children.add(childNode)
}

/**
 * DSL function for creating a ConditionNode with a custom condition.
 *
 * This function creates a ConditionNode, a task node that executes a custom condition defined as a lambda.
 *
 * @param blackboard The shared blackboard for the behavior tree.
 * @param condition A lambda representing the custom condition to be evaluated.
 * @return The created ConditionNode.
 */
fun <T> condition(blackboard: T, condition: () -> Boolean): ConditionNode<T> {
    return ConditionNode(blackboard, condition)
}

/**
 * DSL function for adding a ConditionNode with a custom condition to a NodeContainer.
 *
 * This function adds a ConditionNode with a custom condition to an existing NodeContainer.
 *
 * @param condition A lambda representing the custom condition to be evaluated.
 */
fun <T> NodeContainer<T>.condition(condition: () -> Boolean) {
    val childNode = ConditionNode(this.blackboard, condition)
    children.add(childNode)
}
