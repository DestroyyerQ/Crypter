package xyz.destroyyerq.crypter.basic;

import lombok.Getter;
import xyz.destroyyerq.crypter.api.CrypterAPI;
import xyz.destroyyerq.crypter.input.UserInputManager;

public class Main
{
    @Getter
    private static dCrypter dCrypter;

    public static void main(String... args) {
        System.out.println("       * Crypter created by DestroyyerQ, enjoy! *");
        System.out.println("");

        dCrypter = new dCrypter();
        dCrypter.getFiles().load();

        UserInputManager input = dCrypter.getUserInput().getInputManager();

        dCrypter.getFiles().getFilesList().forEach(file -> {
            try {
                long time = System.currentTimeMillis();
                CrypterAPI.crypter(input.getCryptMode(), input.getSecretKey(), file, input.getAlgorithm());
                System.out.println(file.getName() + " -> end in: " + (System.currentTimeMillis() - time) + "ms!");
            } catch (Exception e) {
                System.out.println("Error -> " + e.getMessage());
            }
        });
    }
}
