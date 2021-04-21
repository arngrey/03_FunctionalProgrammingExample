import scala.util.matching.Regex

class LexemesParser() {
  private val lexemePattern: Regex = "([(])|([)])|([+\\-]?\\d)|(?<=\\s)([+\\-*/])(?=\\s)".r

  def Parse(expressionAsString: String): Lexemes = new Lexemes(
    lexemePattern
      .findAllIn(expressionAsString)
      .flatMap(lexemeAsString => new LexemeParser().Parse(lexemeAsString))
      .toList
  )
}
