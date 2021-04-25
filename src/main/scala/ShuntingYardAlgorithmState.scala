import scala.collection.mutable

sealed class ShuntingYardAlgorithmState[T]() {
  private val stack = new mutable.Stack[T]()
  private var list = List[T]()

  def pushStack(item: T): Unit = stack.push(item)
  def popStack(): T = stack.pop()

  def pushList(item: T): Unit = {
    list = list :+ item
  }
  def getList: List[T] = list

  def pushAllFromStackToList(): Unit =
    stack
      .popWhile(_ => true)
      .foreach(item => pushList(item))

  def pushFromStackToListWhile(condition: T => Boolean): Unit =
    stack
      .popWhile(condition)
      .foreach(item => pushList(item))
}
