import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int countLines = 0;
        int countYandexbot = 0;
        int countGooglebot = 0;
        ArrayList<String[]> logs = new ArrayList<>();


        while (true) {
            String path = new Scanner(System.in).nextLine();
            //String path = "c://courses/access2.log";
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
                System.out.println("Подсчет ");
                System.out.println();

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
                        logs.add(line.split(" \"| \\[| -"));
                    }
                    for (int i = 0; i < logs.size(); i++) {
                        //Делим User-Agent на фрагменты, и поиском из 1 определяем необходимые  запросы
                        String[] fragment = logs.get(i)[6].split(";");
                        if (fragment.length > 1) {
                            if (fragment[1].contains("YandexBot")) {
                                countYandexbot++;
                            }
                            if (fragment[1].contains("Googlebot")) {
                                countGooglebot++;
                            }
                        }

                    }

                    System.out.println("Всего строк " + countLines + "\nYandexBot " + countYandexbot + "\nGooglebot " + countGooglebot);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }


    }
}
