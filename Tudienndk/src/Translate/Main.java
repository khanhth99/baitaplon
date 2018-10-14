package Translate;

import java.util.*;

public class Main extends  DictionaryCommandline {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DictionaryManagement a = new DictionaryManagement();
        DictionaryCommandline b = new DictionaryCommandline();
        a.insertFromFile();

        int option;
        do {
            System.out.println("---------------------------------");
            System.out.println("|        Dictionary E-V         |");
            System.out.println("---------------------------------");
            System.out.println("|      /*---MENU---*/           |");
            System.out.println("|1. Search word                 |");
            System.out.println("|2. Add word                    |");
            System.out.println("|3. Edit word                   |");
            System.out.println("|4. Remove word                 |");
            System.out.println("|5. Full dictionary             |");
            System.out.println("|6. End./                       |");
            System.out.println("---------------------------------");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    b.dictionarySearcher();
                    break;
                case 2:
                    a.insertFromCommandline();
                    break;
                case 3:
                    a.editWordInDic();
                    break;
                case 4:
                    a.deleteWordInDic();
                    break;
                case 5:
                    b.showAllWords();
                    break;
            }
            b.dictionaryExportToFile();

        } while (option >= 1 && option <= 5);
    }

//    Dictionary a = new Dictionary();
//    System.out.println(a.listWord);

}
