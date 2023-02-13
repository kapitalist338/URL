import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static void main(String[] args) {
            String url = "https://www.akc.org/wp-content/uploads/2018/08/nervous_lab_puppy-studio-portrait-lg-800x600.jpg";
            String FN = "src/doggy.jpg";
            FileOutputStream fout = null;
            BufferedInputStream in = null;
           try {
                in = new BufferedInputStream(new URL(url).openStream());
                fout = new FileOutputStream(FN);
                byte[] data = new byte[1024];
                int i;
                while ((i = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, i);
                    fout.flush();
                }

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    in.close();
                    //fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fout.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
