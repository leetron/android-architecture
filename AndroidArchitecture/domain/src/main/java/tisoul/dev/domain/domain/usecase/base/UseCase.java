package tisoul.dev.domain.domain.usecase.base;


import io.reactivex.Observable;

public interface UseCase<P, R> {
    Observable<R> execute(P p);
}
