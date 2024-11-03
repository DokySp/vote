package space.doky.voting.firebase.repository.di

import space.doky.voting.firebase.repository.FirebaseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.doky.voting.domain.output.FirebaseInterface
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindFirebaseRepository(firebaseRepository: FirebaseRepository): FirebaseInterface
}