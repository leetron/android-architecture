package tisoul.dev.mvp;


public class Profile {
    interface View {

        void setPresenter(Presenter presenter);

        void setName(CharSequence name);

        void setEmail(CharSequence email);
    }

    interface Presenter {
        void start();

        void update(CharSequence name, CharSequence email);
    }
}
