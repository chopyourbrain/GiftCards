package com.example.giftcards.presentation.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.example.core_utils.util.extensions.setImageFromUrl
import com.example.giftcards.presentation.fragments.detail.FragmentDetailArgs
import com.example.giftcards.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class FragmentDetail : DaggerFragment() {

    @Inject
    lateinit var viewModel: FragmentDetailViewModel

    private val navArgs: FragmentDetailArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementReturnTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        description.text = navArgs.cardDTO.description
        redeem.text = navArgs.cardDTO.redeem_url
        val codesText = "${"$"}${navArgs.cardDTO.codes_count.toString()}.00"
        codes_count.text = codesText
        credits.text = navArgs.cardDTO.credits.toString()
        card_image.setImageFromUrl(navArgs.cardDTO.image_url ?: "")
        card.transitionName = navArgs.cardDTO.id.toString()
    }
}
