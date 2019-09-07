package wildhan;

public class CreateBook {

    public void start(String sCreate, String sSlot){
        String sCreateBook = "";
        Book.iMaxSlots = Integer.valueOf(sSlot);
        sCreateBook = sCreate.replace("create", "Created a");
        sCreateBook = sCreateBook.replace(sSlot, "with " + sSlot + " slots");

        System.out.println(sCreateBook);
    }
}
