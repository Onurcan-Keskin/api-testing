package com.t4zb.kotlinapitesting.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import com.google.android.material.transition.MaterialContainerTransform
import com.t4zb.kotlinapitesting.R
import com.t4zb.kotlinapitesting.databinding.FragmentDetailBinding
import com.t4zb.kotlinapitesting.helper.PicassoHelper
import com.t4zb.kotlinapitesting.ui.contract.BaseContract
import com.t4zb.kotlinapitesting.ui.fragment.basefragment.BaseFragment
import com.t4zb.kotlinapitesting.ui.presenter.BasePresenter
import com.t4zb.kotlinapitesting.ui.viewmodel.SharedViewModel
import com.t4zb.kotlinapitesting.util.Constants


class DetailFragment : BaseFragment(R.layout.fragment_detail), BaseContract.ViewMain {

    private lateinit var mContext: FragmentActivity

    private lateinit var mSharedViewModel: SharedViewModel

    private lateinit var mainBinding: FragmentDetailBinding

    private val mPresenter: BasePresenter by lazy {
        BasePresenter(this)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentDetailBinding.bind(view)
        mPresenter.onViewsCreated()

        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment
            duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(Color.CYAN)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = requireActivity()

    }

    companion object {
        private const val TAG = "DetailFragment"
    }

    override fun setupViewModel() {
        mSharedViewModel =
            ViewModelProvider(requireActivity(), defaultViewModelProviderFactory).get(
                SharedViewModel::class.java
            )


    }

    override fun initializeViews() {

        when (mSharedViewModel.movieType.value){
            Constants.MOVIE_TYPE_POPULAR -> {
                mSharedViewModel.selectedMoviePop.observe(viewLifecycleOwner, Observer { movies ->
                    mainBinding.run {

                    }
                })
            }
            Constants.MOVIE_TYPE_TOP_RATED -> {

            }
        }

        mSharedViewModel.selectedMoviePop.observe(viewLifecycleOwner, Observer {


            if (it != null) {
                mainBinding.textViewTitle.text = it.title

                mainBinding.textViewOverview.text = it.overview

                PicassoHelper.picassoOkhttp(mContext, it.poster_path, mainBinding.imageViewPoster)

                PicassoHelper.picassoOkhttp(
                    mContext,
                    it.backdrop_path,
                    mainBinding.imageViewBackdrop
                )
            }
        })
    }
}