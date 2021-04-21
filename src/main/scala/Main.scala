object Main {
  def main(args: Array[String]): Unit = {
    val expression: String = scala.io.StdIn.readLine()

    val expressionInReversedPolishNotation: String = Expression(expression).GetReversedPolishNotation()

    println(expressionInReversedPolishNotation)
  }
}


