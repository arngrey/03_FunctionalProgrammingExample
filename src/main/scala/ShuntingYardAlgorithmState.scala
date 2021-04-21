sealed class ShuntingYardAlgorithmState[T]() {
  private val stack = new Stack[T]()
  private var list = List[T]()

  def pushStack(item: T): Unit = stack.push(item)
  def popStack(): T = stack.pop()

  def pushList(item: T): Unit = {
    list = list :+ item
  }
  def getList: List[T] = list

  def pushAllFromStackToList(): Unit = {
    while (!stack.isEmpty) {
      pushList(stack.pop())
    }
  }

  def pushFromStackToListWhile(condition: T => Boolean): Unit = {
    while (!stack.isEmpty && condition(stack.top())) {
      pushList(stack.pop())
    }
  }
}
