package com.dicoding.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.databinding.FragmentMovieBinding
import com.dicoding.moviecatalogue.databinding.FragmentMovieFavoriteBinding
import com.dicoding.moviecatalogue.databinding.FragmentTvShowFavoriteBinding
import com.dicoding.moviecatalogue.ui.favorite.FavoriteViewModel
import com.dicoding.moviecatalogue.ui.favorite.tvshow.FavoriteTvShowAdapter
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory


class MovieFavoriteFragment : Fragment() {

    private var _fragmentMovieFavoriteFragment: FragmentMovieFavoriteBinding? = null
    private val binding get() =  _fragmentMovieFavoriteFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentMovieFavoriteFragment = FragmentMovieFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity!=null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            val adapter = FavoriteMovieAdapter()
            binding?.ltLoading?.visibility = View.VISIBLE
            viewModel.getFavoriteMovie().observe(viewLifecycleOwner , { movie ->
                binding?.ltLoading?.visibility = View.GONE
                adapter.submitList(movie)
            })

            binding?.rvMovie?.layoutManager = LinearLayoutManager(context)
            binding?.rvMovie?.setHasFixedSize(true)
            binding?.rvMovie?.adapter = adapter
        }
    }


}