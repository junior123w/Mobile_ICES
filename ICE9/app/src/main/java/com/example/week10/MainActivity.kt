package com.example.week10

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week10.databinding.ActivityMainBinding
import com.example.week10.databinding.AddNewMovieItemBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    // Declare an instance of the binding class
    private lateinit var binding: ActivityMainBinding
    private lateinit var addNewMovieBinding: AddNewMovieItemBinding
    private lateinit var addMovieFAB: FloatingActionButton
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var firstAdapter: FirstAdapter
    private lateinit var movieList: MutableList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize Firebase
        FirebaseApp.initializeApp(this)
        authenticateUser()

        val firestore = FirestoreDataManager()
        firestore.getMovies { movies ->
            for (movie in movies) {
                println(movie.title)
            }
        }

        /* val newMovie = FirebaseMovie("MyTitle", "MyStudio")
        firestore.addMovie(newMovie) { isSuccess ->
            if(isSuccess)
            {
                println("Success!")
            }
        }

        viewModel.movies.observe(this) { movies ->
            movieList = movies.toMutableList()
            firstAdapter = FirstAdapter(movies)

            binding.FirstRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = firstAdapter
            }

            // click on a row to update
            firstAdapter.onMovieClick = {movie->
                showUpdateMovieDialog(movie)
            }

            // Setup swipe to delete
            val swipeToDeleteCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
            {
                override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean
                {
                    return false // not used
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int)
                {
                    AlertDialog.Builder(this@MainActivity).apply {
                        setTitle(R.string.delete_movie)
                        setMessage(R.string.are_you_sure)
                        setPositiveButton(R.string.ok) { dialog, _ ->
                            dialog.dismiss()
                            val position = viewHolder.adapterPosition
                            val movieId = movieList[position].id
                            viewModel.deleteMovie(movieId) // Trigger deletion in ViewModel
                        }
                        setNegativeButton(R.string.cancel) { dialog, _ ->
                            dialog.dismiss()
                            firstAdapter.notifyItemChanged(viewHolder.adapterPosition) // Reverts the swipe action visually
                        }
                        setCancelable(false)
                    }.create().show()
                }

            }
            val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
            itemTouchHelper.attachToRecyclerView(binding.FirstRecyclerView)
        }

        // Get Movies for the first time
        viewModel.getAllMovies()

        // add the FAB
        addMovieFAB = binding.addMovieFAB
        addMovieFAB.setOnClickListener{ showAddMovieDialog() }

        binding.logoutButton.setOnClickListener { logoutUser() }
    }*/
    }
        private fun authenticateUser() {
            val authentication = FirebaseAuth.getInstance()
            val user = authentication.currentUser
        }

        /* private fun showAddMovieDialog()
    {
        val dialogTitle = getString(R.string.add_dialog_title)
        val positiveButtonTitle = getString(R.string.add_movie)
        val builder = AlertDialog.Builder(this)
        addNewMovieBinding = AddNewMovieItemBinding.inflate(layoutInflater)

        builder.setTitle(dialogTitle)
        builder.setView(addNewMovieBinding.root)

        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()
            val movieTitle = addNewMovieBinding.movieTitleEditText.text.toString()
            val studioTitle = addNewMovieBinding.studioTitleEditText.text.toString()
            val newMovie = Movie(title = movieTitle, studio = studioTitle)

            viewModel.addMovie(newMovie)
        }
        builder.create().show()
    }

    private fun showUpdateMovieDialog(movie: Movie)
    {
        val dialogTitle = getString(R.string.update_dialog_title)
        val positiveButtonTitle = getString(R.string.update_movie)
        val builder = AlertDialog.Builder(this)
        addNewMovieBinding = AddNewMovieItemBinding.inflate(layoutInflater)

        builder.setTitle(dialogTitle)
        builder.setView(addNewMovieBinding.root)

        viewModel.getMovieById(movie.id)

        viewModel.movie.observe(this, Observer { movieById ->
            addNewMovieBinding.movieTitleEditText.setText(movieById!!.title)
            addNewMovieBinding.studioTitleEditText.setText(movieById.studio)
        })

        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()
            val movieTitle = addNewMovieBinding.movieTitleEditText.text.toString()
            val studioTitle = addNewMovieBinding.studioTitleEditText.text.toString()
            val updatedMovie = Movie(title = movieTitle, studio = studioTitle)

            viewModel.updateMovie(movie.id, updatedMovie)
        }
        builder.create().show()
    }

    private fun logoutUser()
    {
        val sharedPreferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            remove("auth_token")
            apply()
        }
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
*/
    }
