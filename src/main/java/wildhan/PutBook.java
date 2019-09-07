package wildhan;

public class PutBook {
    public void start(String sBook){
        if (Book.iMaxSlots == 0){
            System.out.println("Please create a book first");
        }
        else {
            Book.iIndexBook++;
            if (Book.iIndexBook > Book.iMaxSlots){
                System.out.println("Book shelf is full");
                Book.iIndexBook--;
            }
            else{
                for (int i = 1; i <= Book.iMaxSlots; i++){
                    if (Book.hmBook.get(i) == null){
                        String[] sRow = sBook.split(" ");
                        Book.hmBook.put(i, i +" "+ sRow[1]+" "+sRow[2]);
                        System.out.println("Allocated slot number: "+i);
                        break;
                    }
                }
            }
        }
    }
}
