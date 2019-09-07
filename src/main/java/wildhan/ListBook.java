package wildhan;

public class ListBook {
    public static void start(){
        String sHeaderColumn1 = "Slot No.   ";
        int iLenghtsHeaderColumn1 = sHeaderColumn1.length();
        int iMaxLength = 0;
        String sHeaderColumn2 = "Book Title";
        int iLenghtsHeaderColumn2 = sHeaderColumn2.length();
        String sHeaderColumn3 = "Author";

        if (Book.iMaxSlots == 0){
            System.out.println("Please create a book first");
            return;
        }
        else if (Book.hmBook.size() == 0){
            System.out.println("Empty");
        }

        for (int i = 1; i <= Book.iMaxSlots; i++){
            if (Book.hmBook.get(i) == null){
                continue;
            }
            String[] sRow = Book.hmBook.get(i).split(" ");
            String sTitle = sRow[1];
            iMaxLength = Math.max(iMaxLength, iLenghtsHeaderColumn2);
            iMaxLength = Math.max(iMaxLength, sTitle.length());
        }

        boolean bHeader = true;
        for (int i = 1; i <= Book.iMaxSlots; i++){
            if (Book.hmBook.get(i) == null){
                continue;
            }
            String[] sRow = Book.hmBook.get(i).split(" ");
            String sTitle = sRow[1];
            int iPrint = bHeader ? 2 : 1;
            for (int j = 0; j < iPrint; j++){
                if (bHeader){
                    System.out.print(sHeaderColumn1);
                    System.out.print(sHeaderColumn2);
                    for (int k = 0; k < (iMaxLength - iLenghtsHeaderColumn2 + 3); k++){
                        System.out.print(" ");
                    }
                    System.out.println(sHeaderColumn3);
                    bHeader = false;
                }
                else {
                    for (int k = 0; k < iLenghtsHeaderColumn1; k++){
                        if (k == 0){
                            System.out.print(i);
                        }
                        else {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(sTitle);
                    for (int k = 0; k < (iMaxLength - sTitle.length() + 3); k++){
                        System.out.print(" ");
                    }
                    System.out.println(sRow[2]);
                }
            }
        }
    }
}
