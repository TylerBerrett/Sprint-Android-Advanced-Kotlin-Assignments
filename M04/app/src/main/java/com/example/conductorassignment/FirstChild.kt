package com.example.conductorassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.bluelinelabs.conductor.changehandler.VerticalChangeHandler
import kotlinx.android.synthetic.main.root_controller.view.*

class FirstChild: Controller, SecondChild.SecondChild {



    var message: String? = null

    constructor() : super() {
    }

    constructor(args: Bundle?) : super(args) {
        args?.getString("string")
    }


    override fun randomNum(int: Int) {
        message = "$int"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view =  inflater.inflate(R.layout.root_controller, container, false)
        view.text_view.text = if (message.isNullOrEmpty()){
            "First Child"
        } else {
            "First Child$message"
        }

        println(args.getString("string"))



        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        view?.next_button?.setOnClickListener {
            router.pushController(RouterTransaction.with(SecondChild(this))
                .pushChangeHandler(VerticalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }

        view?.previous_button?.setOnClickListener {
            router.popCurrentController()
        }
    }



}