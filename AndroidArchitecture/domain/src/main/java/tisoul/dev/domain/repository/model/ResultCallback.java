package tisoul.dev.domain.repository.model;


public interface ResultCallback<D> {
    void onSuccess(D d);

    void onError(Throwable throwable);
}
