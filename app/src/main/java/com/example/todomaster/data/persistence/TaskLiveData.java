package com.example.todomaster.data.persistence;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.example.todomaster.data.model.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class TaskLiveData extends LiveData<Task> implements EventListener<DocumentSnapshot> {
    private ListenerRegistration listenerRegistration;
    private DocumentReference reference;

    public TaskLiveData(DocumentReference reference) {
        this.reference = reference;
    }

    @Override
    protected void onActive() {
        super.onActive();
        listenerRegistration = reference.addSnapshotListener(this);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        listenerRegistration.remove();
    }

    @Override
    public void onEvent(@Nullable DocumentSnapshot snap, @Nullable FirebaseFirestoreException error) {
        if (snap != null && snap.exists()) {
            Task wubbalubbadubdub = snap.toObject(Task.class);
            wubbalubbadubdub.setId(snap.getId());
            setValue(wubbalubbadubdub);
        } else if (error != null) {
            throw new RuntimeException(error);
        }
    }
}
