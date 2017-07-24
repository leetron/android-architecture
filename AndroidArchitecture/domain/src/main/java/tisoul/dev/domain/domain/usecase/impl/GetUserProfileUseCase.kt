package tisoul.dev.domain.domain.usecase.impl


import tisoul.dev.domain.domain.usecase.GetUserProfile
import tisoul.dev.domain.repository.ProfileRepository
import javax.inject.Inject

class GetUserProfileUseCase
@Inject constructor(
        private val profileRepository: ProfileRepository)
    : GetUserProfile {

    override fun execute(p: Boolean)
            = profileRepository.getProfile()
}
