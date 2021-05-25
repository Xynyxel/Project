package com.dicoding.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.moviecatalogue.databinding.FragmentMovieBinding
import com.dicoding.moviecatalogue.databinding.FragmentTvShowBinding
import com.dicoding.moviecatalogue.databinding.FragmentTvShowFavoriteBinding
import com.dicoding.moviecatalogue.ui.favorite.FavoriteViewModel
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory


class TvShowFavoriteFragment : Fragment() {

    private var _fragmentTvShowFavoriteFragment: FragmentTvShowFavoriteBinding? = null
    private val binding get() =  _fragmentTvShowFavoriteFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentTvShowFavoriteFragment = FragmentTvShowFavoriteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity!=null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            val adapter = FavoriteTvShowAdapter()
            binding?.ltLoading?.visibility = View.VISIBLE
            viewModel.getFavoriteTvShow().observe(viewLifecycleOwner , { tvshow ->
                binding?.ltLoading?.visibility = View.GONE
                adapter.submitList(tvshow)
            })

            binding?.rvTvShow?.layoutManager = LinearLayoutManager(context)
            binding?.rvTvShow?.setHasFixedSize(true)
            binding?.rvTvShow?.adapter = adapter
        }
    }

}