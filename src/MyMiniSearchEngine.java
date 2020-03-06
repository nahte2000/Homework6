import java.lang.reflect.Array;
import java.util.*;

public class MyMiniSearchEngine {
    private Map<String, List<List<Integer>>> indexes;

    private MyMiniSearchEngine() {
        indexes = new HashMap<>();
        List<Integer> innerList = new ArrayList<>();
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(innerList);
        indexes.put("key", outerList);
}

    public MyMiniSearchEngine(List<String> documents) {
        index(documents);
    }

    // each item in the List is considered a document.
    // assume documents only contain alphabetical words separated by white spaces.
        private void index(List<String> texts) {
        List[] data = new List[texts.size()];
        for (int i = 0; i < texts.size(); i++) {
                String temp = texts.get(i);
                String[] s = temp.split(" ");
                for(int j = 0; j<s.length;j++) {
                    indexes.put(s[j], data[j]);
                }
        }
    }

    // search(key) return all the document ids where the given key phrase appears.
    // key phrase can have one or two words in English alphabetic characters.
    // return an empty list if search() finds no match in all documents.
    public List<Integer> search(String keyPhrase) {
        if (indexes.containsKey(keyPhrase)) {
            while(indexes.containsKey(keyPhrase)) {
                return new ArrayList<>(indexes.get(keyPhrase).get(indexes.size()));
            }
        }
        return new ArrayList<>();
    }
}
