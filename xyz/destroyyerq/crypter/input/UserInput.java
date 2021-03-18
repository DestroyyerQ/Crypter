package xyz.destroyyerq.crypter.input;

import lombok.Getter;

import javax.crypto.Cipher;
import java.util.Scanner;

@Getter
public class UserInput
{
    private final Scanner scanner;
    private final UserInputManager inputManager;

    public UserInput() {
        this.scanner = new Scanner(System.in);
        this.inputManager = new UserInputManager();

        System.out.print("Encrypt or Decrypt? -> ");
        String inputCrypt = scanner.nextLine();

        if(inputCrypt.equalsIgnoreCase("encrypt")) {
            this.inputManager.setCryptMode(Cipher.ENCRYPT_MODE);
        } else if(inputCrypt.equalsIgnoreCase("decrypt")) {
            this.inputManager.setCryptMode(Cipher.DECRYPT_MODE);
        } else {
            System.out.println("Incorrect options selected, default \"ENCRYPT\"");
            this.inputManager.setCryptMode(Cipher.ENCRYPT_MODE);
        }

        System.out.print("Your secret key -> ");
        String inputSecretKey = scanner.nextLine();
        this.inputManager.setSecretKey(inputSecretKey);

        System.out.print("What algorithm do you want to use? -> ");
        String algorithm = scanner.nextLine();
        this.inputManager.setAlgorithm(algorithm);

        System.out.println("\n");
    }
}
