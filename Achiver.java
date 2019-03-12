
import java.io.*;

class Archiver {

    public static void archiverFile(FileInputStream input, FileOutputStream output) throws IOException {
        try (BufferedInputStream fileInputStream = new BufferedInputStream(input);
             BufferedOutputStream fileOutputStream = new BufferedOutputStream(output))
        {
            int current = 0;
            int lastByte = -1;
            int count = 0;
            while ((current = fileInputStream.read()) != -1) {

                if (current != lastByte || count == 255) {
                    if (count > 0) {
                        fileOutputStream.write((byte)count);
                    }
                    fileOutputStream.write((byte)current);
                    count = 1;
                }
                else {
                    count++;
                }
            }
            if (lastByte != -1) {
                fileOutputStream.write((byte)count);
            }
        }

    }
}
