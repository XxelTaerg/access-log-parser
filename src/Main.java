import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int countLines = 0;
        int someLongLine = 0;
        int someShortLine = 0;

        while (true) {
            String path = new Scanner(System.in).nextLine();
            //String path = "c://courses/access.log";
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isFile = file.isDirectory();
            if (!fileExists || isFile) {
                System.out.println("Файл не существует или указанный путь является путём к папке");
                 continue;
            } else {
                count++;
                System.out.println("Путь указан верно. Это файл номер " + count);
                System.out.println();
                System.out.println("Начинаем");
                System.out.println();

                //Построчно читаем файл
                try {

                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader =
                            new BufferedReader(fileReader);
                    String line;

                    while ((line = reader.readLine()) != null) {
                        countLines++;
                        int length = line.length();
                        if (length > 1024) {
                            throw new outOfMaxValueException("out of 1024 symbols in String");
                        }
                        if (length > someLongLine) {
                            someLongLine = length;
                        }
                        if (someShortLine == 0) {
                            someShortLine = line.length();
                        } else if (length < someShortLine) {
                            someShortLine = length;
                        }

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("общее количество строк в файле" + " " + countLines);
                System.out.println("длина самой длинной строки в файле" + " " + someLongLine);
                System.out.println("длина самой короткой строки в файле" + " " + someShortLine);
            }
        }


    }
}
