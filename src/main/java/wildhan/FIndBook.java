package wildhan;

import java.util.Map;

public class FIndBook {
    public void start(int flag, String sSearch){
        if (Book.iMaxSlots == 0){
            System.out.println("Please create a book first");
            return;
        }
        switch (flag){
            case 1 : //find author
                String sResultAuthor = "";
                for (Map.Entry me : Book.hmBook.entrySet()) {
                    String[] sRow = String.valueOf(me.getValue()).split(" ");
                    if (sRow[2].equalsIgnoreCase(sSearch)){
                        sResultAuthor += me.getKey()+", ";
                    }
                }
                if (sResultAuthor.equals("")){
                    System.out.println("Not Found");
                }
                else {
                    sResultAuthor = sResultAuthor.substring(0, sResultAuthor.length() - 2);
                    System.out.println(sResultAuthor);
                }
                break;
            case 2 : //find title
                String sResultTitle = "";
                for (Map.Entry me : Book.hmBook.entrySet()) {
                    String[] sRow = String.valueOf(me.getValue()).split(" ");
                    if (sRow[1].equalsIgnoreCase(sSearch)){
                        sResultTitle += me.getKey()+", ";
                    }
                }
                if (sResultTitle.equals("")){
                    System.out.println("Not Found");
                }
                else {
                    sResultTitle = sResultTitle.substring(0, sResultTitle.length() - 2);
                    System.out.println(sResultTitle);
                }
                break;
            case 3 : //titlebyauthor
                String sResultTitleByAuthor = "";
                for (Map.Entry me : Book.hmBook.entrySet()) {
                    String[] sRow = String.valueOf(me.getValue()).split(" ");
                    if (sRow[2].equalsIgnoreCase(sSearch)){
                        sResultTitleByAuthor += sRow[1] +", ";
                    }
                }
                if (sResultTitleByAuthor.equals("")){
                    System.out.println("Not Found");
                }
                else {
                    sResultTitleByAuthor = sResultTitleByAuthor.substring(0, sResultTitleByAuthor.length() - 2);
                    System.out.println(sResultTitleByAuthor);
                }
                break;
        }
    }
}
