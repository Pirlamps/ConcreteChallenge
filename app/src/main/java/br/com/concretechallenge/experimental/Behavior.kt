package br.com.concretechallenge.experimental


sealed class Behavior {
    class ShowLoading : Behavior()
    class HideLoading : Behavior()
    class RequestData(val controllerBlock: () -> Unit) : Behavior()


}

fun execute(command: Behavior) {
    when(command){
        is Behavior.ShowLoading -> println("Loading")
        is Behavior.HideLoading -> println("Finished Loading")
        is Behavior.RequestData -> command.controllerBlock()
    }
}
