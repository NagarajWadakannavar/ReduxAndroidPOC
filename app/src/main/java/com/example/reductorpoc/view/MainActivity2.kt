package com.example.reductorpoc.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.reductorpoc.R
import com.example.reductorpoc.redux.actions.CounterActions
import com.example.reductorpoc.redux.reducers.CounterReducer
import com.example.reductorpoc.redux.states.Counter
import com.yheriatovych.reductor.Actions
import com.yheriatovych.reductor.Store
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.value
import kotlinx.android.synthetic.main.activity_main2.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var counterStore: Store<Counter>

    //no need to implement CounterActions, we can do it for you
    private val actions = Actions.from(CounterActions::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        add10.setOnClickListener(this)
        goBack.setOnClickListener(this)
        value.text = counterStore.state.count.toString()
        //you can subscribe to state changes
        counterStore.subscribe { state -> value.text = state?.count.toString() }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.add10 -> counterStore.dispatch(actions.add(10))
            R.id.goBack -> onBackPressed()
        }
    }
}