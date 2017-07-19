package tisoul.dev.domain.repository.model


interface ResultCallback<D> {
    fun onSuccess(d: D)

    fun onError(throwable: Throwable)
}
