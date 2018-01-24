public class Paper {

    private String content = "";

    public String getText() {
        return content;
    }

    public void write(String text) {
        content += text;
    }

    public void erase(String text) {
        String erasedWord = text.replaceAll(".", " ");

        replaceSubstring(text, erasedWord);
    }

    public void edit(String erasedWord, String replacementWord) {
        StringBuilder replacementWordWithSpaces = new StringBuilder(replacementWord);
        int lengthDifference = erasedWord.length() - replacementWord.length();
        for(int i = 0; i < lengthDifference; i++){
            replacementWordWithSpaces.append(" ");
        }

        replaceSubstring(erasedWord, replacementWordWithSpaces.toString());
    }


    private void replaceSubstring(String erasedWord, String replacementWord){
        if (erasedWord.length() > replacementWord.length()) {
            replaceWithEqualOrShorterLengthSubstring(erasedWord, replacementWord);
        }

        if (erasedWord.length() == replacementWord.length()) {
            replaceWithEqualOrShorterLengthSubstring(erasedWord, replacementWord);
        }
    }

    private void replaceWithEqualOrShorterLengthSubstring(String erasedWord, String replacementWord){
        int firstLetterIndex = content.lastIndexOf(erasedWord);
        int terminatingIndex = firstLetterIndex + replacementWord.length();
        StringBuilder tempBuilder = new StringBuilder(content);

        tempBuilder.replace(firstLetterIndex, terminatingIndex, replacementWord);

        content = tempBuilder.toString();
    }
}
