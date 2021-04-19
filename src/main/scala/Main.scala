object Main {
  def main(args: Array[String]): Unit = {
    val expression: String = scala.io.StdIn.readLine()

    new LexemesParser()
      .parse(expression)
      .ToReversedPolishNotationOrder()
  }
}


