package forritunarmalVerkefni;

import java.util.ArrayList;
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
		
		print();
	}


	private void s() {
		if(myLexer.token.getTokenCode().equals(Token.TokenCode.SEMICOL) ){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			s();
		}
		
		else{
			if(myLexer.token.getTokenCode().equals(Token.TokenCode.END)){
				myStack.push(myLexer.token.getLexeme());
			}	
			else{
				myLexer.token.setLexeme("ERRROR");
				myStack.push(myLexer.token.getLexeme());
			}
		}
	}
	
	public void s2(){
		
		if(myLexer.token.getLexeme().equals(Token.TokenCode.ID)){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			
			if(myLexer.token.getLexeme().equals(Token.TokenCode.ASSIGN)){
				myStack.push(myLexer.token.getLexeme());
				
				myLexer.nextToken();
				expr();
			}
			else{
				myLexer.token.setLexeme("ERRROR");
				myStack.push(myLexer.token.getLexeme());
			}	
		}
		else if(myLexer.token.getLexeme().equals(Token.TokenCode.PRINT)){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			
			if(myLexer.token.getLexeme().equals(Token.TokenCode.ID)){
				myStack.push(myLexer.token.getLexeme());
				
				myLexer.nextToken();
				expr();
			}
			else{
				myLexer.token.setLexeme("ERRROR");
				myStack.push(myLexer.token.getLexeme());
			}	
			
			
		}
	}

	private void expr() {
		
		Term();
		if(myLexer.token.getLexeme().equals(Token.TokenCode.ADD)){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			expr();
		}
		else if(myLexer.token.getLexeme().equals(Token.TokenCode.SUB)){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			expr();
		}
		
		
	}

	private void Term() {
		Factor();
		
		if(myLexer.token.getLexeme().equals(Token.TokenCode.MULT)){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			Term();
		}
		
	}

	private void Factor() {
		
		if(myLexer.token.getLexeme().equals(Token.TokenCode.INT)){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
		}
		else if(myLexer.token.getLexeme().equals(Token.TokenCode.ID)){
			myStack.push(myLexer.token.getLexeme());
			
			
			myLexer.nextToken();
		}
		else if(myLexer.token.getLexeme().equals(Token.TokenCode.LPAREN)){
			myStack.push(myLexer.token.getLexeme());
			
			myLexer.nextToken();
			expr();
			
			if(myLexer.token.getLexeme().equals(Token.TokenCode.RPAREN)){
				myStack.push(myLexer.token.getLexeme());
				
				myLexer.nextToken();
			}
			else{
				myLexer.token.setLexeme("ERRROR");
				myStack.push(myLexer.token.getLexeme());
				
				myLexer.nextToken();
			}	
			
		}
		
	}
	
	private void print() {
		
		Stack <String> newStack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		ArrayList<String> strArr = new ArrayList<String>();
		
		for(String obj : myStack){
		
			if(obj.matches(";")){
				sb.append(obj);
				strArr.add(sb.toString());
				for(int i=0; i<sb.length();i++){
					sb.delete(i, sb.length());
				}
			}
			if(! obj.matches(";")){
				sb.append(obj);
				sb.append(" ");
			}
		}
		
		for(String obj : strArr){
			String[] line = obj.split(" ");
			
			for(String item : line){
				
				if((item.matches("[A-Za-z]+") || item.matches("[0-9]+")) && (! item.matches("print"))){
					
						if(item.matches("[0-9]+")){
							newStack.push("PUSH " + item);
						}
						else{
							newStack.push("PUSH " + item); 
						}
					}
				}
			
			reverse(line);
			for(String item : line){
				if(item.equals("+")){
					newStack.push("ADD");
				}
				if(item.equals("-")){
					newStack.push("SUB");
				}
				if(item.equals("*")){
					newStack.push("MULT");
				}
				if(item.equals("=")){
					newStack.push("ASSIGN");
				}
				if(item.equals("print")){
					newStack.push("PRINT");
				}
				if(item.equals("ERROR")){
					newStack.push("Syntax error");
				}
			}
		}

		for(String obj : newStack)
			{ 
			    if(obj.equals("Syntax error")){
			    	System.out.println(obj);
			    	System.exit(1);
			    }
			    else{
			    	System.out.println(obj);
			    }
			}
	}
	
	
		public static void reverse(Object [] a){
			for(int i = 0; i < a.length / 2; i++){
	    		Object temp = a[i]; 
	    		a[i] = a[a.length - i - 1];
	    		a[a.length - i - 1] = temp;
			}
		}

		
	}
