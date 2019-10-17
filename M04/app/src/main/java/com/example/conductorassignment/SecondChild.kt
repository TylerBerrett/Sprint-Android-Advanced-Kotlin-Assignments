package com.example.conductorassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.root_controller.view.*
import kotlin.random.Random


class SecondChild<T>(): Controller()
    where T: Controller, T: SecondChild.SecondChild {

    constructor(targetController: T): this() {
        setTargetController(targetController)
    }

    /*constructor(args: Bundle?) : super(args){
        randomNumber = args?.getInt("key")
    }*/

    interface SecondChild{
        fun randomNum(int: Int)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view =  inflater.inflate(R.layout.root_controller, container, false)
        view.text_view.text = "Second Child"
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        val addButton = view?.next_button
        addButton?.text = "Get Random Number"
        addButton?.setOnClickListener {
            args.putInt("key", Random.nextInt())
            (targetController as SecondChild).randomNum(10)
        }

        view?.previous_button?.setOnClickListener {
            router.popCurrentController()
        }



    }
}
