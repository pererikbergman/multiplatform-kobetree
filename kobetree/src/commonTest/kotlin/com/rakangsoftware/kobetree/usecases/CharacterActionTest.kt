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

package com.rakangsoftware.kobetree.usecases

import com.rakangsoftware.kobetree.core.Blackboard

internal class CharacterActionTest {

//    enum class Action {
//        WALK_TO_DOOR, OPEN_DOOR, WALK_THROUGH_DOOR, CLOSE_DOOR, EAT_FOOD
//    }
//
//    class Character(val isHungry: Boolean, val haveFood: Boolean, val enemiesAround: Boolean)
//
//    @ParameterizedTest(name = "Character: hungry={0}, haveFood={1}, enemiesAround={2}")
//    @CsvSource(
//        "false,false,false",
//        "false,false,true",
//        "false,true,false",
//        "false,true,true",
//        "true,false,false",
//        "true,false,true",
//        "true,true,false",
//        "true,true,true"
//    )
//    fun `Character performs actions based on conditions`(
//        isHungry: Boolean,
//        haveFood: Boolean,
//        enemiesAround: Boolean
//    ) {
//        val actions = mutableListOf<Action>()
//
//        val blackboard = Blackboard()
//        val character = Character(isHungry, haveFood, enemiesAround)
//        blackboard.put("character", character)
//        blackboard.put("enemies", enemiesAround)
//
//        // Am I hungry?
//        if (character.isHungry) {
//            actions.add(Action.EAT_FOOD)
//        }
//
//        // Do I have food?
//        if (character.haveFood) {
//            actions.add(Action.EAT_FOOD)
//        }
//
//        // No Enemies Around
//        if (!enemiesAround) {
//            actions.add(Action.EAT_FOOD)
//        }
//
//        assertActionsMatchConditions(character, enemiesAround, actions)
//    }
//
//    private fun assertActionsMatchConditions(
//        character: Character,
//        enemiesAround: Boolean,
//        actions: List<Action>
//    ) {
//        val expectedActions = mutableListOf<Action>()
//
//        if (character.isHungry) {
//            expectedActions.add(Action.EAT_FOOD)
//        }
//
//        if (character.haveFood) {
//            expectedActions.add(Action.EAT_FOOD)
//        }
//
//        if (!enemiesAround) {
//            expectedActions.add(Action.EAT_FOOD)
//        }
//
//        assertArrayEquals(
//            expectedActions.toTypedArray(),
//            actions.toTypedArray(),
//            "The actions did not occur as expected"
//        )
//    }
}
