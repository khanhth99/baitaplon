package Translate;

import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {

    // hien thi ket qua tu danh sach tu dien
    public void showAllWords() {
        System.out.printf("%-5s|%-20s|%-20s", "NO", "English", "Vietnamese");
        System.out.println();
        for (int i = 0; i < listWord.size(); i++) {
            System.out.printf("%-5s|%-20s|%-20s\n", i + 1, listWord.get(i).getWord_taget(), listWord.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        insertFromFile();
        showAllWords();
        dictionaryLookup();
    }

    public void dictionarySearcher() {
       Scanner sc = new Scanner(System.in);
        System.out.println("----Tìm kiếm từ tiếng anh----");
        System.out.print("Nhập từ cần tìm: ");
        String wordSearch = sc.nextLine();

        ArrayList<Word> listWordSearch = new ArrayList<>();

        for (Word ele
                : Dictionary.listWord) {
            if (ele.getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(ele);
            }
        }

        if (listWordSearch.isEmpty()) {
            System.out.println("Không có trong từ điển !!!");
        } else {
            System.out.println("(Các) từ bắt đầu bằng \"" + wordSearch + "\": ");
            int i = 1;
            for (Word ele
                    : listWordSearch) {
                System.out.printf("%-4d", i);
                ele.printWord();
                i++;
            }
        }
    }

}