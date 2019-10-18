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
import kotlinx.android.synthetic.main.root_controller.view.*

class RootController: Controller {

    constructor() : super()
    constructor(args: Bundle?) : super(args)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val  view = inflater.inflate(R.layout.root_controller, container, false)
        view.text_view.text = "works"
        return view
    }

    override fun onChangeEnded(changeHandler: ControllerChangeHandler, changeType: ControllerChangeType) {
        super.onChangeEnded(changeHandler, changeType)

        view?.next_button?.setOnClickListener {
            args.putString("string", "test")
            router.pushController(RouterTransaction.with(FirstChild(args))
                .popChangeHandler(HorizontalChangeHandler())
                .pushChangeHandler(HorizontalChangeHandler())
            )
        }

        val previousButton = view?.previous_button
        if (router.backstackSize <= 1){
            previousButton?.visibility = View.GONE
        } else {
            previousButton?.setOnClickListener {
                router.popCurrentController()
            }
        }
    }
}