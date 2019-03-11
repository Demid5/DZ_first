import java.io.*;

class Unarchiver {

    public static int convertByteMassToInt(byte[] mass) {
        int result = 0;
        for (int i = 0; i < mass.length; ++i) {
            result = result * 127 + mass[i];
        }
        return result;
    }

    public static void unArchiverFile(File input, File output) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);

        int currentFirst = 0;
        int sizeCountByteMass = 0;
        int count = 0;

        while ((currentFirst = fileInputStream.read()) != -1) {
            sizeCountByteMass = fileInputStream.read();
            byte mass[] = new byte[sizeCountByteMass];
            for (int i = 0; i < sizeCountByteMass; ++i) {
                mass[i] = (byte)fileInputStream.read();
            }
            count = convertByteMassToInt(mass);

            for (int i = 0; i < count; ++i) {
                fileOutputStream.write((byte)currentFirst);
            }
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
