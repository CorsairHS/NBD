import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Nbd {
    private final static String address = "http://localhost:8098/buckets/s23102/keys/";
    private static final String value1 = "Adrian";
    private static final String value2 = "Maciek";
    private static URL url;

    static {
        try {
            url = new URL(address + value1);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static HttpURLConnection connection;

    public static void main(String[] args) throws Exception {
        addToDatabase();
        downloadAndDeploy();
        modify();
        downloadAndDeploy();
        delete();
        downloadAndDeploy();
    }
    private static void addToDatabase() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-type", "plain/text");
        connection.setRequestProperty("Accept", "plain/text");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(value1);
        osw.flush();
        osw.close();
        System.out.println("Dokument wrzucony do bazy");
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());

    }
    private static void downloadAndDeploy() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        System.out.println("Dokument pobrany z bazy i wypisany");
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());
        try {
            byte[] res = connection.getInputStream().readAllBytes();
            StringBuilder sb = new StringBuilder();
            for (byte e : res) {
                sb.append((char) e);
            }
            System.out.println(sb);
        } catch (Exception e){
            System.out.println(e);
        }
    }
    private static void modify() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-type", "plain/text");
        connection.setRequestProperty("Accept", "plain/text");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(value2);
        osw.flush();
        osw.close();
        System.out.println("Dokument zostal zmodyfikowany");
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());
    }

    private static void delete() throws IOException {
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setDoOutput(true);
        System.out.println("Usun dokument");
        System.out.println(connection.getResponseCode());
        System.out.println(connection.getResponseMessage());
    }
}
