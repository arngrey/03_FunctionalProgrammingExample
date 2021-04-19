case class Lexemes(private val list: List[Lexeme]) {
  def ToReversedPolishNotationOrder(): Lexemes = {
    val state = new ReversedPolishNotationAlgorithmState[Lexeme]()

    list
      .foreach {
        case lexeme@(_: NumericLexeme) =>
          state.pushList(lexeme)
        case lexeme@(_: OpenBracketLexeme) =>
          state.pushStack(lexeme)
        case _: OperatorLexeme =>
          state.pushFromStackToListWhile(lexeme => lexeme.isInstanceOf[OperatorLexeme]/*TODO priority*/)
        case _: CloseBracketLexeme =>
          state.pushFromStackToListWhile(lexeme => lexeme.isInstanceOf[OpenBracketLexeme])
          state.popStack()
        case _ =>
      }

    state.pushAllFromStackToList()

    Lexemes(state.getList)
  }



}
