package forritunarmalVerkefni;

import java.util.Stack;

public class Parser {
	
	private Token myToken;
	private Lexer myLexer;
	private Stack<String> myStack = new Stack<String>();
	//token = new Token();
	
	public Parser(Lexer newLexer) {
		//myToken = new Token();
		//myLexer = new Lexer();
		myLexer = newLexer;
		myLexer.readInput();
		myLexer.nextToken();
		s();
	}

	private void s() {
		if(myLexer.token.getTokenCode().equals(Token.TokenCode.SEMICOL) ){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			s();
		}
		
		else{
			
		}
	}
	


	


}
