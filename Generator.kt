import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object Generator {
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()
    private val bag = Bag()

    init {
        scope.launch {
            delay(1000)
            while (currentCoroutineContext().isActive) {
                delay(100)
                println("Остались номера: ${bag.bagList}")
                _sharedFlow.emit(bag.pop())
            }
        }
    }
}