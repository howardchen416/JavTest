import javafx.concurrent.Worker;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MultiThreadServer {

    public static void main(String[] args) throws NoSuchAlgorithmException {


        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bs = password.getBytes();
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
    }
}
