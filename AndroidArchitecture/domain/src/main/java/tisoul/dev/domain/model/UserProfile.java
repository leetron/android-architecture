package tisoul.dev.domain.model;


public class UserProfile {
    public final CharSequence name;
    public final CharSequence email;

    public UserProfile(CharSequence name, CharSequence email) {
        this.name = name;
        this.email = email;
    }
}
