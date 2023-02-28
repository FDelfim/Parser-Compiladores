import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int currentTokenIndex;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        this.currentTokenIndex = 0;
    }

    public void parse() {
        comando();
        if (currentToken().getType() != TokenType.EOF) {
            throw new RuntimeException("Unexpected token after end of expression");
        }else{
            System.out.println("Sucesso");
        }
    }

    private void comando() {
        if (match(TokenType.IF)) {
            expr();
            match(TokenType.THEN);
            if (match(TokenType.IF)) {
                expr();
                match(TokenType.THEN);
                atribuicao();
                match(TokenType.ELSE);
                atribuicao();
            } else {
                withElse();
            }
        } else {
            atribuicao();
        }
    }

    private void withElse() {
        if (match(TokenType.IF)) {
            expr();
            match(TokenType.THEN);
            withElse();
            match(TokenType.ELSE);
            withElse();
        } else {
            atribuicao();
        }
    }

    private void atribuicao() {
        match(TokenType.IDENTIFIER);
    }

    private void expr() {
        match(TokenType.IDENTIFIER);
    }

    private boolean match(TokenType expectedTokenType) {
        Token currentToken = currentToken();
        if (currentToken.getType() == expectedTokenType) {
            currentTokenIndex++;
            return true;
        }
        return false;
    }

    private Token currentToken() {
        if (currentTokenIndex >= tokens.size()) {
            return new Token(TokenType.EOF, "");
        }
        return tokens.get(currentTokenIndex);
    }
}