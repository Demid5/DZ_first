
import java.io.*;

class Archiver {

    public static void archiverFile(File input, File output) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(input);
        FileOutputStream fileOutputStream = new FileOutputStream(output);

        // массив байтов, куда будет записан исходный файл
        byte[] mass = new byte[(int)input.length()];
        int bytes = 0;
        int i = 0;
        // запись файла в байтовый массив
        while ((bytes = fileInputStream.read()) != -1) {
            mass[i++] = (byte)bytes;
        }
        //

        // переводим из байтового массива в строку
        String str = new String(mass, 0, mass.length);
        int Codepoints[] = str.codePoints().toArray();
        StringBuilder stringBuilder = new StringBuilder();

        i = 0;
        int count = 0;
        while (i < Codepoints.length) {
            count = 0;
            int currentCode = Codepoints[i];
            while (i < Codepoints.length && Codepoints[i] == currentCode) {
                count++;
                i++;
            }
            stringBuilder.append(Character.toChars(currentCode));
            stringBuilder.append(count);
        }

        String resultStr = stringBuilder.toString();
        fileOutputStream.write(resultStr.getBytes());


        fileInputStream.close();
        fileOutputStream.close();
    }
}
