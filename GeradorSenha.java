import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


public class GeradorSenha {
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
    private static final int TAMANHO_SENHA =12;

    public static String gerarSenhaComplexa() {
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < TAMANHO_SENHA; i++){
            int indice = random.nextInt(CARACTERES.length());
            senha.append(CARACTERES.charAt(indice));
        }
        return senha.toString();
    }
    public static String hashSenha(String senha){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] bytes = md.digest(senha.getBytes());

            StringBuilder hash = new StringBuilder();
            for (byte b : bytes) {
                hash.append(String.format("%02x", b));
            }
            return hash.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args){
        String senhaGerada = gerarSenhaComplexa();
        String senhaHash = hashSenha(senhaGerada);

        System.out.println("Senha Gerada: " + senhaGerada);
        System.out.println("Senha Hash: " + senhaHash);
    }

}
