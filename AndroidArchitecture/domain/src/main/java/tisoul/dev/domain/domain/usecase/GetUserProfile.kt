package tisoul.dev.domain.domain.usecase


import tisoul.dev.domain.domain.usecase.base.UseCase
import tisoul.dev.domain.model.UserProfile

interface GetUserProfile : UseCase<Boolean, UserProfile>