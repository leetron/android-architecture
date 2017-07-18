package tisoul.dev.androidarchitecture.mvp;


public class Profile {
    interface View {

        void setName(CharSequence name);

        void setEmail(CharSequence email);
    }

    public interface Presenter {
        void setView(View view);

        void subscribe();

        void unSubscribe();

        void update(CharSequence name, CharSequence email);
    }
}
