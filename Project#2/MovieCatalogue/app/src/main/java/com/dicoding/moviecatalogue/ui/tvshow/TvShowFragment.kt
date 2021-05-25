package com.dicoding.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.moviecatalogue.databinding.FragmentTvShowBinding
import com.dicoding.moviecatalogue.utils.util.setVisible
import com.dicoding.moviecatalogue.viewmodel.ViewModelFactory
import com.dicoding.moviecatalogue.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(this.requireActivity())
            val tvShowViewModel: TvShowViewModel by viewModels{ factory }
            fragmentTvShowBinding.ltLoading.setVisible(true)
            val tvShowAdapter = TvShowAdapter()
            tvShowViewModel.getPopularTvShow().observe(viewLifecycleOwner, { tvShow ->
                if (tvShow!=null){
                    when(tvShow.status){
                        Status.LOADING -> fragmentTvShowBinding?.ltLoading.setVisible(true)
                        Status.SUCCESS -> {
                            fragmentTvShowBinding?.ltLoading.setVisible(false)
                            tvShowAdapter.submitList(tvShow.data)
                        }
                        Status.ERROR -> {
                            fragmentTvShowBinding?.ltLoading.setVisible(true)
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }


}