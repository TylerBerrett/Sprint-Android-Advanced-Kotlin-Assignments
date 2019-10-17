package com.example.conductorassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import kotlinx.android.synthetic.main.root_controller.view.*

class FirstChild: Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view =  inflater.inflate(R.layout.root_controller, container, false)
        view.text_view.text = "First Child"

        view.next_button.setOnClickListener {
            router.pushController(RouterTransaction.with(SecondChild())
                .pushChangeHandler(VerticalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }

        view.previous_button.setOnClickListener {
            router.popCurrentController()
        }

        return view




    }

}