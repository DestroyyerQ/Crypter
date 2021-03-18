package xyz.destroyyerq.crypter.basic;

import lombok.Getter;
import xyz.destroyyerq.crypter.files.Files;
import xyz.destroyyerq.crypter.input.UserInput;

@Getter
public class dCrypter
{
    private final Files files;
    private final UserInput userInput;

    public dCrypter() {
        this.files = new Files("dCrypter");
        this.userInput = new UserInput();
    }
}
