public class Pencil {

    private int durability = 100;

    public int getDurability(){
        return durability;
    }

    public void write(String textToWrite) {
        char[] textArray = textToWrite.toCharArray();

        for (int index = 0; index < textToWrite.length(); index++){
            if (Character.isLowerCase(textArray[index])) {
                durability -= 1;
            }
            if (Character.isUpperCase(textArray[index])) {
                durability -= 2;
            }
        }
    }
}
