object Main {
  def main(args: Array[String]): Unit = {
    val expressionAsString: String = scala.io.StdIn.readLine()

    println(
      new LexemesParser()
        .Parse(expressionAsString)
        .ToReversedPolishNotationOrder()
        .GetAsString()
    )

    println(
      new LexemesParser()
        .Parse(expressionAsString)
        .Evaluate()
    )
  }
}


