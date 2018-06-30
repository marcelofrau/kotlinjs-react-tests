package app

import kotlinx.html.js.onChangeFunction
import react.*
import react.dom.*
import logo.*
import ticker.*

class App : RComponent<RProps, App.State>() {

    class State(var inputValue: String) : RState

    override fun componentWillMount() {
        setState {
            inputValue = "Input your name"
        }
    }

    override fun RBuilder.render() {

        h1 {
            +"Hello Bootcamp"
        }

        div {
            input {
                attrs {
                    value = state.inputValue
                    onChangeFunction = { event ->
                        val value = event.currentTarget.asDynamic().value
                        setState {
                            inputValue = value
                        }
                    }
                }
            }
        }
        test(state.inputValue)
    }
}
fun RBuilder.bootcampApp() = child(App::class) {}


class Test : RComponent<Test.Props, RState>() {
    class Props(var value: String) : RProps
    override fun RBuilder.render() {
        div {
            span {
                +props.value
            }
        }
    }
}
fun RBuilder.test(value: String) = child(Test::class) {
    attrs.value = value
}


