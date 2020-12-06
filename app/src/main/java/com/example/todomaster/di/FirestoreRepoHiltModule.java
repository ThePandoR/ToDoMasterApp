package com.example.todomaster.di;

import com.example.todomaster.data.persistence.FirestoreTaskRepository;
import com.example.todomaster.data.persistence.TaskRepository;
import com.google.firebase.firestore.FirebaseFirestore;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public abstract class FirestoreRepoHiltModule {

    @Binds
    public abstract TaskRepository bindTaskRepo(FirestoreTaskRepository impl);

    @Provides
    public static FirebaseFirestore firestoreInstance() {
        return FirebaseFirestore.getInstance();
    }
}
