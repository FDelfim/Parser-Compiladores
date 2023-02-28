import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.IF, "if"));
        tokens.add(new Token(TokenType.IDENTIFIER, "Expr_1"));
        tokens.add(new Token(TokenType.THEN, "then"));
        tokens.add(new Token(TokenType.IF, "if"));
        tokens.add(new Token(TokenType.IDENTIFIER, "Expr_2"));
        tokens.add(new Token(TokenType.THEN, "then"));
        tokens.add(new Token(TokenType.IDENTIFIER, "Atribuição_1"));
        tokens.add(new Token(TokenType.ELSE, "else"));
        tokens.add(new Token(TokenType.IDENTIFIER, "Atribuição_2"));
        tokens.add(new Token(TokenType.EOF, ""));

        Parser parser = new Parser(tokens);
        parser.parse();
    }
}