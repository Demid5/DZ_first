
import java.io.*;

class Archiver {

    private static byte[] convertNumeToByteMass(int num) {
        int size = 0;
        int newNum = num;
        while (num > 0) {
            size++;
            num /= 127;
        }
        size++;
        byte mass[] = new byte[size];
        mass[0] = (byte)(size - 1);

        while (newNum > 0) {
            mass[--size] = (byte)(newNum % 127);
            newNum /= 127;
        }
        return mass;
    }

    public static void archiverFile(File input, File output) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(input);
             FileOutputStream fileOutputStream = new FileOutputStream(output))
        {
            int current = 0;
            int lastByte = -1;
            int count = 0;
            while ((current = fileInputStream.read()) != -1) {

                if (current == lastByte) {
                    count++;
                }
                else {
                    if (count != 0) {
                        fileOutputStream.write(convertNumeToByteMass(count));
                    }
                    count = 1;
                }

                if (count == 1) {
                    fileOutputStream.write((byte)current);
                }
                lastByte = current;
            }
            if (lastByte != -1) {
                fileOutputStream.write(convertNumeToByteMass(count));
            }

            fileInputStream.close();
            fileOutputStream.close();
        }

    }
}
