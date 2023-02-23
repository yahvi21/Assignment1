
import java.util.ArrayList;
//Creating array list for tags
public class TagList {
    private final ArrayList<Tag> tags;
    
    public TagList() {
        tags = new ArrayList<>();
    }
    //function to increment the count of that tag 
    public void add(String name) {
        Tag tag = search(name);
        if (tag == null) {
            tags.add(new Tag(name));
        } else {
            tag.setCount(tag.getCount() + 1);
        }
    }
    
    public Tag get(int index) {
        return tags.get(index);
    }
    
    public int size() {
        return tags.size();
    }
    
    public Tag search(String tag) {
        for (int i = 0; i < tags.size(); ++i) {
            if (tags.get(i).getName().equalsIgnoreCase(tag)) {
                return tags.get(i);
            }
        }
        return null;
    }
    //Searches for all tags with a count equal to the input parameter count
    public ArrayList<Tag> search(int count) {
        ArrayList<Tag> tags = new ArrayList<>();
        for (int i = 0; i < this.tags.size(); ++i) {
            if (this.tags.get(i).getCount() == count) {
                tags.add(this.tags.get(i));
            }
        }
        return tags;
    }
    
    public void sort() {
        // insertion sort
        for (int j = 1; j < tags.size(); ++j) {
            // Picking up the element
            Tag element = tags.get(j);
            int i = j - 1;
            while (i >= 0 && element.getCount() < tags.get(i).getCount()) {
                tags.set(i + 1, tags.get(i));
                --i;
            }
            // Placing the element at its correct position in the sorted subarray
            tags.set(i + 1, element);
        }
    }    
}
