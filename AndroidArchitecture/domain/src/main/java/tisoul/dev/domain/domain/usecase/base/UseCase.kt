package tisoul.dev.domain.domain.usecase.base


import io.reactivex.Observable

interface UseCase<P, R> {
    fun execute(p: P): Observable<R>
}
