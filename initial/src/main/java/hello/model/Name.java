package hello.model;

public class Name {

    private final long id;
    private final String content;

    public Name(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
