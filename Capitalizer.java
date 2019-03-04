
public class Capitalizer {
    public static String improveStr(String str) {

        // создаем массив кодовый точек
        int resultCodePoint[] = str.codePoints().toArray();
        //
        for (int i = 0; i < resultCodePoint.length; ++i) {
            if ((i > 0 && Character.isSpaceChar(resultCodePoint[i - 1]) && !Character.isSpaceChar(resultCodePoint[i]))
                    || (i == 0 && !Character.isSpaceChar(resultCodePoint[i]))) {
                resultCodePoint[i] = Character.toTitleCase(resultCodePoint[i]);
            }
            else {
                resultCodePoint[i] = Character.toLowerCase(resultCodePoint[i]);
            }
        }

        String resultStr = new String(resultCodePoint, 0, resultCodePoint.length);
        return resultStr;
    }
}
