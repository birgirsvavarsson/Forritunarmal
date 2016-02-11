package forritunarmalVerkefni;

public class Token {

		private String lexeme;
		
		public enum TokenCode { ID, ASSIGN, SEMICOL, INT, ADD, PLUS, MULT, LPAREN, RPAREN, PRINT, END, ERROR}
		TokenCode myToken;
		
		public Token() {
			
		}
		
		public TokenCode getTokenCode(){
			return myToken;
		}
		
		public void setTokenCode(TokenCode myToken){
			this.myToken = myToken;
		}
		
		public String getLexeme() {
			return lexeme;
		}

		public void setLexeme(String lexeme) {
			this.lexeme = lexeme;
		} 

}
