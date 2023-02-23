public class Tag {
    private final String name;
    private int count;
    
    public Tag(String tag) {
        this.name = tag;
        count = 1;
    }
   
    public String getName() {
        return name;
    }
    
    public int getCount() {
        return count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public String toString() {
        return String.format("%d: %s", count, name);
    }
}
