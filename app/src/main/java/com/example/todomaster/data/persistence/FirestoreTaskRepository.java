package com.example.todomaster.data.persistence;

import com.example.todomaster.data.model.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FirestoreTaskRepository implements TaskRepository {

    private FirebaseFirestore firestore;

    private static final String COLLECTION_PATH = "tasks-collection";

    @Inject
    public FirestoreTaskRepository(FirebaseFirestore firestore) {
        this.firestore = firestore;
    }

    @Override
    public TaskLiveData getTaskById(String id) {
        DocumentReference temp = firestore.collection(COLLECTION_PATH).
                document(id);
        return new TaskLiveData(temp);
    }

    @Override
    public TaskListLiveData getAllTasks() {
        return new TaskListLiveData(firestore.collection(COLLECTION_PATH).orderBy("date", Query.Direction.DESCENDING));
    }

    @Override
    public TaskLiveData updateTask(Task entry) {
        DocumentReference documentReference = firestore.collection(COLLECTION_PATH).document(entry.getId()) ;
        documentReference.set(entry);
        return new TaskLiveData(documentReference);
    }

    @Override
    public TaskLiveData addTask(Task entry) {
        DocumentReference documentReference = firestore.collection(COLLECTION_PATH).document();
        entry.setId(documentReference.getId());
        documentReference.set(entry);
        return new TaskLiveData(documentReference);
    }

    @Override
    public void deleteTask(String id) {
        firestore.collection(COLLECTION_PATH).document(id).delete();
    }
}
