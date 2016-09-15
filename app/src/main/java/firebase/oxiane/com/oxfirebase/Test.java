package firebase.oxiane.com.oxfirebase;

/**
 * Created by aboudard on 14/09/2016.
 */

public class Test {

    private String text;
    private String user;

    public Test() {
    }

    public Test(String text, String user) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
