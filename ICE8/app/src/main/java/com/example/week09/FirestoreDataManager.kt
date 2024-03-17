package com.example.week09

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject


class FirestoreDataManager {
    private val db = FirebaseFirestore.getInstance()
    private val collectionRef = db.collection("movies")

    fun getMovies(onComplete: (List<FirebaseMovie>) -> Unit)
    {
        collectionRef.get()
            .addOnSuccessListener { result ->
                val movies = result.mapNotNull { it.toObject<FirebaseMovie>() }
                onComplete(movies)
            }
            .addOnFailureListener{
                onComplete(emptyList())
            }
    }

    fun addMovie(movie: FirebaseMovie, onComplete: (Boolean)-> Unit)
    {
        collectionRef.add(movie)
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false)}
    }
}