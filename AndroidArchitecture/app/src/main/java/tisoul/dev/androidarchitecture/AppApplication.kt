package tisoul.dev.androidarchitecture


import android.app.Application

import tisoul.dev.androidarchitecture.di.component.ApplicationComponent
import tisoul.dev.androidarchitecture.di.component.DaggerApplicationComponent
import tisoul.dev.androidarchitecture.di.module.ApplicationModule

class AppApplication : Application() {
    var applicationComponent: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        this.initializeInjector()
    }

    private fun initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}
