/**
 * Алгоритм Сортировочной станции Э. Дейкстры.
 */
sealed class ShuntingYardAlgorithm {
  /**
   * Отсортировать список лексем выражения в соответствии с порядком обратной польской записи.
   * @param lexemesInInfixNotationOrder список лексем в порядке инфиксной записи.
   * @return Список лексем в порядке обратной польской записи.
   */
  def toReversedPolishNotationOrder(lexemesInInfixNotationOrder: List[Lexeme]): List[Lexeme] = {
    val state = new ShuntingYardAlgorithmState[Lexeme]()

    lexemesInInfixNotationOrder
      .foreach {
        case lexeme@(_: NumericLexeme) =>
          state.pushList(lexeme)
        case lexeme@(_: OpenBracketLexeme) =>
          state.pushStack(lexeme)
        case lexeme@(_: OperatorLexeme) =>
          state.pushFromStackToListWhile(stackTopLexeme =>
            stackTopLexeme.isInstanceOf[OperatorLexeme]
            && stackTopLexeme.asInstanceOf[OperatorLexeme].HasGraterOrEqualPriorityThan(lexeme)
          )
          state.pushStack(lexeme)
        case _: CloseBracketLexeme =>
          state.pushFromStackToListWhile(lexeme => !lexeme.isInstanceOf[OpenBracketLexeme])
          state.popStack()
        case _ =>
      }

    state.pushAllFromStackToList()
    state.getResult
  }
}
