package tisoul.dev.androidarchitecture.mvp;


public class Profile {
    interface View {

        void setPresenter(Presenter presenter);

        void setName(CharSequence name);

        void setEmail(CharSequence email);
    }

    interface Presenter {
        void subscribe();

        void unSubscribe();

        void update(CharSequence name, CharSequence email);
    }
}
