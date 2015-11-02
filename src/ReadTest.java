/**
 * Created by michaelklein on 10/26/15.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadTest {
        public static void main(String[] args)
                throws Exception {
            URL url = new URL("http://forecast.weather.gov/product.php?issuedby=MSN&product=CLI&site=mkx");
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter
                    (new FileWriter("data.html"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("YESTERDAY")) {
                    System.out.println(line);
                }
                System.out.println(line);
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
        }
}
