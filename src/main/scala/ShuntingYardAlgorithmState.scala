import scala.collection.mutable

/**
 * Состояние алгоритма Сортировочной станции Э. Дейкстры.
 * @tparam T тип сортируемых элементов.
 */
sealed class ShuntingYardAlgorithmState[T]() {
  private val stack = new mutable.Stack[T]()
  private var resultList = List[T]()

  /**
   * Добавить элемент в стэк.
   * @param item добавляемый элемент.
   */
  def pushStack(item: T): Unit = stack.push(item)

  /**
   * Вытолкнуть элемент из стэка.
   * @return Выталкиваемый элемент.
   */
  def popStack(): T = stack.pop()

  /**
   * Добавить элемент в выходной список.
   * @param item добавляемый элемент.
   */
  def pushList(item: T): Unit = {
    resultList = resultList :+ item
  }

  /**
   * Получить результат сортировки.
   * @return результат сортировки.
   */
  def getResult: List[T] = resultList

  /**
   * Добавлять элементы из стэка в выходной список, пока они не закончатся.
   */
  def pushAllFromStackToList(): Unit =
    stack
      .popWhile(_ => true)
      .foreach(item => pushList(item))

  /**
   * Добавлять элементы из стэка в выходной список, пока выполняется условие.
   * @param condition выполняемое условие.
   */
  def pushFromStackToListWhile(condition: T => Boolean): Unit =
    stack
      .popWhile(condition)
      .foreach(item => pushList(item))
}
