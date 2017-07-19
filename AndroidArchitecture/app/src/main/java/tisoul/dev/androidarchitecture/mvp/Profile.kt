package tisoul.dev.androidarchitecture.mvp


class Profile {
    interface View {

        fun setName(name: CharSequence)

        fun setEmail(email: CharSequence)
    }

    interface Presenter {
        fun setView(view: View)

        fun subscribe()

        fun unSubscribe()

        fun update(name: CharSequence, email: CharSequence)
    }
}
