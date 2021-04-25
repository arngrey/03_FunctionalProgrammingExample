object Main {
  def main(args: Array[String]): Unit = {
    val expressionAsString: String = scala.io.StdIn.readLine()
    val expression: Expression = new Expression(expressionAsString)
    val expressionInReversedPolishNotation: String = expression.GetReversedPolishNotation()
    val value: Double = expression.GetValue()

    println(expressionInReversedPolishNotation)
    println(value)
  }
}


