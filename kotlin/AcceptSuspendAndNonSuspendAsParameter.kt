class SeparateFunctionsForSuspendAndNonSuspendParameters {

    fun doSomethingBeforeAndAfter(nonSuspendAction: () -> Unit) {
        somethingBeforeAction()
        nonSuspendAction()
        somethingAfterAction()
    }

    suspend fun doSomethingBeforeAndAfterForSuspendableActions(suspendAction: suspend () -> Unit) {
        somethingBeforeAction()
        suspendAction()
        somethingAfterAction()
    }

}

class InlineFunctionForSuspendAndNonSuspendParameters {

    inline fun doSomethingBeforeAndAfter(action: () -> Unit) {
        somethingBeforeAction()
        action()
        somethingAfterAction()
    }

}

fun somethingBeforeAction() {
    println("Do something before action")
}

fun somethingAfterAction() {
    println("Do something after action")
}
