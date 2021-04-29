package com.example.reductorpoc.redux.actions

import com.yheriatovych.reductor.Action
import com.yheriatovych.reductor.annotations.ActionCreator

/**
 * Created by Nagaraj on 26-04-2021.
 */
@ActionCreator
interface CounterActions {

    @ActionCreator.Action(INCREMENT)
    fun increment(): Action

    @ActionCreator.Action(ADD)
    fun add(value: Int): Action

    companion object {
        const val INCREMENT = "INCREMENT"
        const val ADD = "ADD"
    }
}