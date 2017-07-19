package tisoul.dev.domain.domain.usecase.base


import io.reactivex.Observable

interface UseCase<in P, R> {
    fun execute(p: P): Observable<R>
}
