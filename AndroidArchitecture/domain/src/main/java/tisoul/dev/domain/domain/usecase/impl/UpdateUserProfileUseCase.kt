package tisoul.dev.domain.domain.usecase.impl


import tisoul.dev.domain.domain.usecase.UpdateUserProfile
import tisoul.dev.domain.model.UserProfile
import tisoul.dev.domain.repository.ProfileRepository
import javax.inject.Inject

class UpdateUserProfileUseCase
@Inject constructor(
        private val profileRepository: ProfileRepository)
    : UpdateUserProfile {

    override fun execute(userProfile: UserProfile)
            = profileRepository.saveProfile(userProfile)
}
