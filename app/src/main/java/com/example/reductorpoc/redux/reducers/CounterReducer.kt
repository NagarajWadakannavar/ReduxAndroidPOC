package com.example.reductorpoc.redux.reducers

import com.example.reductorpoc.redux.actions.CounterActions
import com.example.reductorpoc.redux.states.Counter
import com.yheriatovych.reductor.Reducer
import com.yheriatovych.reductor.annotations.AutoReducer
import com.yheriatovych.reductor.annotations.AutoReducer.InitialState


/**
 * Created by Nagaraj on 26-04-2021.
 */
@AutoReducer
abstract class CounterReducer : Reducer<Counter> {
    @InitialState
    fun initialState(): Counter {
        return Counter(count = 0)
    }

    @AutoReducer.Action(value = CounterActions.INCREMENT, from = CounterActions::class)
    fun increment(state: Counter): Counter {
        return state.copy(count = state.count + 1)
    }

    @AutoReducer.Action(value = CounterActions.ADD, from = CounterActions::class)
    fun add(state: Counter, value: Int): Counter {
        return state.copy(count = state.count + value)
    }

    companion object {
        fun create(): CounterReducer {
            return CounterReducerImpl() //Note: usage of generated class
        }
    }
}