package wildhan;

public class RemoveBook {
    public void start(String sSlot){
        if (Book.iMaxSlots == 0){
            System.out.println("Please create a book first");
            return;
        }
        if (Book.hmBook.get(Integer.valueOf(sSlot)) != null){
            Book.hmBook.remove(Integer.valueOf(sSlot));
            Book.iIndexBook--;
            System.out.println("Slot number "+sSlot+" is free");
        }
        else {
            System.out.println(sSlot +" not found");
        }
    }
}
