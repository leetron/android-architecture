package tisoul.dev.domain.repository


import io.reactivex.Observable
import tisoul.dev.domain.model.UserProfile

interface ProfileRepository {
    fun getProfile(): Observable<UserProfile>

    fun saveProfile(userProfile: UserProfile): Observable<UserProfile>
}
