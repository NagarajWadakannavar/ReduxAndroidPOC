package com.example.reductorpoc.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.reductorpoc.R
import com.example.reductorpoc.redux.actions.CounterActions
import com.example.reductorpoc.redux.reducers.CounterReducer
import com.example.reductorpoc.redux.states.Counter
import com.yheriatovych.reductor.Actions
import com.yheriatovych.reductor.Store
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    @Inject
    lateinit var counterStore: Store<Counter>

    //no need to implement CounterActions, we can do it for you
    private val actions = Actions.from(CounterActions::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        increment.setOnClickListener(this)
        add5.setOnClickListener(this)
        next.setOnClickListener(this)
        value.text = counterStore.state.count.toString()
        //you can subscribe to state changes
        counterStore.subscribe { state -> value.text = state?.count.toString() }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.increment -> counterStore.dispatch(actions.increment())
            R.id.add5 -> counterStore.dispatch(actions.add(5))
            R.id.next -> startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}