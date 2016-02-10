package forritunarmalVerkefni;

public class Parser {
	
	private Token myToken;
	private Lexer myLexer;
	
	//token = new Token();
	
	public Parser(Lexer newLexer) {
		myToken = new Token();
		myLexer = new Lexer();
		myLexer = newLexer;
	}

	public void parser() {
		
		myLexer.readInput();
		myLexer.nextToken();
		
	}


}
