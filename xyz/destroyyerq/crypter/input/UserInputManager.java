package xyz.destroyyerq.crypter.input;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserInputManager
{
    private int cryptMode;
    private String secretKey;
    private String algorithm;
}
