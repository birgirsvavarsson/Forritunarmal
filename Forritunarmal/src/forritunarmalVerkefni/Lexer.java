package forritunarmalVerkefni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Lexer {
	
	Token token;
	private ArrayList<String> myArray;
	private String input;
	String INTPATTERN = "[0-9]+";
	String IDPATTERN = "[A-Za-z]+";
	String END = "end";
	String PRINT = "print";
	private int c;

	
	public Lexer()
	{
		token = new Token();
		myArray = new ArrayList<String>();
		c = 0;
	}

	public void readInput() 
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			while((input = reader.readLine()) != null)
			{
				@SuppressWarnings("resource")
				Scanner scanner = new Scanner(input).useDelimiter("");
				
				String s0 = "";
				String s1 = "";
				
				while(scanner.hasNext())
				{
					if(scanner.hasNext(INTPATTERN) || scanner.hasNext(IDPATTERN))
					{
						while(scanner.hasNext(INTPATTERN) || scanner.hasNext(IDPATTERN))
						{
							s0 = s0 + scanner.next();
						}
						myArray.add(s0);
					}
					else
					{
						s1 = scanner.next();
						myArray.add(s1);
					}
				}
				scanner.close();
				
				for(int i = 0; i < myArray.size(); i++)
				{
					if(myArray.get(i).equals(" ") || myArray.get(i).equals(null))
					{
						myArray.remove(i);
					}
					
				}
			}
			reader.close();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		
	}

	public void nextToken() 
	{
		// TODO Auto-generated method stub
		//Tjekka error?
		//enum TokenCode { ID, ASSIGN, SEMICOL, INT, ADD, SUB, MULT, LPAREN, RPAREN, PRINT, END, ERROR}
		
		if(myArray.get(c).matches(IDPATTERN))
		{
			token.setTokenCode(Token.TokenCode.ID);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches("="))
		{
			token.setTokenCode(Token.TokenCode.ASSIGN);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches(";"))
		{
			token.setTokenCode(Token.TokenCode.SEMICOL);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches(INTPATTERN))
		{
			token.setTokenCode(Token.TokenCode.INT);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches("+"))
		{
			token.setTokenCode(Token.TokenCode.ADD);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches("-"))
		{
			token.setTokenCode(Token.TokenCode.SUB);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches("*"))
		{
			token.setTokenCode(Token.TokenCode.MULT);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches("("))
		{
			token.setTokenCode(Token.TokenCode.LPAREN);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches(")"))
		{
			token.setTokenCode(Token.TokenCode.RPAREN);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches("print"))
		{
			token.setTokenCode(Token.TokenCode.PRINT);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else if(myArray.get(c).matches("end"))
		{
			token.setTokenCode(Token.TokenCode.END);
			token.setLexeme(myArray.get(c));
			c++;
		}
		else
		{
			token.setTokenCode(Token.TokenCode.ERROR);
			c++;
		}
		
	}

}
