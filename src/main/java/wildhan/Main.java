package wildhan;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0){
            LoadFormFile(args[0]);
            return;
        }
        while (true){
            Scanner masukan = new Scanner(System.in);
            String s;
            System.out.print("$ ");
            s = masukan.nextLine();
            if (s.startsWith("create_book_shelf")){
                String pattern = "\\d+";
                Pattern r = Pattern.compile(pattern);
                Matcher mNum = r.matcher(s);
                if (mNum.find()){
                    new CreateBook().start(s, mNum.group(0));
                }
                else {
                    System.out.println("Please enter the number of slots");
                }
            }
            else if (s.startsWith("put")){
                String[] sRow = s.split(" ");
                if (sRow.length > 2){
                    new PutBook().start(s);
                }
                else {
                    System.out.println("Please enter title and author");
                }
            }
            else if (s.startsWith("list")){
                new ListBook().start();
            }
            else if (s.startsWith("remove")){
                String pattern = "\\d+";
                Pattern r = Pattern.compile(pattern);
                Matcher mNum = r.matcher(s);
                if (mNum.find()){
                    new RemoveBook().start(mNum.group(0));
                }
                else {
                    System.out.println("Please enter the number of slots");
                }
            }
            else if (s.startsWith("find-by-author")){
                String[] sSearch = s.split(" ", 2);
                if (sSearch.length > 1){
                    new FIndBook().start(1, sSearch[1]);
                }
                else {
                    System.out.println("Please enter keyword");
                }
            }
            else if (s.startsWith("find-by-title")){
                String[] sSearch = s.split(" ", 2);
                if (sSearch.length > 1){
                    new FIndBook().start(2, sSearch[1]);
                }
                else {
                    System.out.println("Please enter keyword");
                }
            }
            else if (s.startsWith("titles-by-author")){
                String[] sSearch = s.split(" ", 2);
                if (sSearch.length > 1){
                    new FIndBook().start(3, sSearch[1]);
                }
                else {
                    System.out.println("Please enter keyword");
                }
            }
            else if (s.startsWith("exit")){
                break;
            }
            else if (s.startsWith("help")){
                System.out.println("create_book_shelf(space)number slot");
                System.out.println("put(space)title(space)author");
                System.out.println("list");
                System.out.println("remove(space)number slot");
                System.out.println("find-by-author(space)keyword");
                System.out.println("find-by-title(space)keyword");
                System.out.println("titles-by-author(space)keyword");
            }
            else {
                System.out.println("Key not found");
                System.out.println("write (help) to see key");
            }
        }
    }

    private static void LoadFormFile(String sPath){
        ArrayList<String> alInput = convertFileToArray("C:\\Users\\User\\Downloads\\BookShelf-v1\\"+sPath);

        String pattern = "\\d+";
        Pattern r = Pattern.compile(pattern);
        String sLine1 = alInput.get(0);

        Matcher mNum = r.matcher(sLine1);

        String sSlot = "";
        if (mNum.find()){
            sSlot = mNum.group(0);
            new CreateBook().start(alInput.get(0), sSlot);
        }
        else {
            return;
        }

        for (int i = 1; i <= Book.iMaxSlots; i++){
            if (alInput.get(i).startsWith("put")) {
                String[] sRow = alInput.get(i).split(" ");
                new PutBook().start("put "+sRow[1]+" "+sRow[2]);
            }
        }

        new RemoveBook().start("4");
        new ListBook().start();
        new PutBook().start("put AGameOfThrones GeorgeRRMartin");
        new PutBook().start("put AClashOfKings GeorgeRRMartin");
        new FIndBook().start(1, "JKRowling");
        new FIndBook().start(2, "AGameOfThrones");
        new FIndBook().start(3, "JKRowling");
        new FIndBook().start(3, "UdiDahan ");
    }

    private static ArrayList<String> convertFileToArray(String sFileFullPath){
        ArrayList<String> alResult=null;
        File srcfile;
        BufferedReader br;
        try {
            srcfile = new File(sFileFullPath);
            br = new BufferedReader(new FileReader(srcfile));
            alResult = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()){
                    alResult.add(line);
                }
            }

            try {
                br.close();
            } catch (IOException iOException) {
            }
        } catch (FileNotFoundException e) {
            alResult=null;
        } catch (IOException e) {
            e.printStackTrace();
            alResult=null;
        }
        return alResult;
    }
}
