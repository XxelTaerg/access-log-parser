import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int countLines = 0;
        Statistics statistics = new Statistics();

        //ArrayList<String[]> logs = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();

        while (true) {

            String path = new Scanner(System.in).nextLine();
            //String path = "c://courses/access2.log";
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isFile = file.isDirectory();
            if (!fileExists || isFile) {
                System.out.println("Файл не существует или указанный путь является путём к папке");
                //continue;
            } else {
                count++;
                System.out.println("Путь указан верно. Это файл номер " + count);

                //Построчно читаем файл
                try {
                    FileReader fileReader = new FileReader(path);
                    BufferedReader reader = new BufferedReader(fileReader);
                    String line;

                    while ((line = reader.readLine()) != null) {
                        countLines++;
                        int length = line.length();
                        if (length > 1024) {
                            throw new OutOfMaxValueException("out of 1024 symbols in String");
                        }
                        //Делим строку на фрагменты, 6 элемент массива фрагмент User-Agent
                        //logs.add(line.split(" \"| \\[| -"));
                        lines.add(line);
                    }

                    //Проверка вывода Statistics
                    for (int i = 0; i < lines.size(); i++) {
                        LogEntry logs2 = new LogEntry(lines.get(i));
                        statistics.addEnty(logs2);
//                        System.out.println(new UserAgent(logs2.getUserAgent()));
                    }
                    System.out.println();
                    System.out.println("Обьем часового трафика " + new DecimalFormat("0.#####").format(statistics.getTrafficRate()));
                    System.out.println();
                    System.out.println("Общее количество строк файла логов " + countLines);
//

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }


    }
}
