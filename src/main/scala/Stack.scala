class Stack[T]() {
  private var list: List[T] = List[T]()

  def push(item: T): Unit = {
    list = item :: list
  }
  def top(): T = list.head
  def pop(): T = {
    val result: T = top()
    list = list.tail
    result
  }

  def isEmpty: Boolean = list.isEmpty
}
