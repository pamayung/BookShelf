package wildhan;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadFromFile {
    public void start(String sPath){
        ArrayList<String> alInput = convertFileToArray("C:\\Users\\User\\Downloads\\BookShelf-v1\\"+sPath);

        if (alInput == null){
            System.out.println("File not found");
            return;
        }

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
