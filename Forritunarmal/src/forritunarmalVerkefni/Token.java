package forritunarmalVerkefni;

public class Token {

		String lexeme;
		TokenCode tCode;
		
		enum TokenCode { ID, ASSIGN, SEMICOL, INT, ADD, PLUS, MULT, LPAREN, RPAREN, PRINT, END, ERROR}
		
		public Token() {
			
		}
		
		public TokenCode getTokenCode(){
			return tCode;
		}
		
		public void setTokenCode(TokenCode myToken){
			this.tCode = myToken;
		}
		
		public String getLexeme() {
			return lexeme;
		}

		public void setLexeme(String lexeme) {
			this.lexeme = lexeme;
		} 

}
