package tisoul.dev.domain.repository


import tisoul.dev.domain.model.UserProfile
import tisoul.dev.domain.repository.model.ResultCallback

interface ProfileRepository {
    fun getProfile(result: ResultCallback<UserProfile>)

    fun saveProfile(userProfile: UserProfile, resultCallback: ResultCallback<Boolean>)
}
