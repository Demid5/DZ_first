import java.io.*;

class Unarchiver {

    public static void unArchiverFile(FileInputStream input, FileOutputStream output) throws IOException {
        try (BufferedInputStream fileInputStream = new BufferedInputStream(input);
             BufferedOutputStream fileOutputStream = new BufferedOutputStream(output))
        {
            int count = 0;
            int current = 0;

            while ((current = fileInputStream.read()) != -1) {
                count = fileInputStream.read();

                for (int i = 0; i < count; ++i) {
                    fileOutputStream.write((byte)current);
                }
            }
        }
    }
}
