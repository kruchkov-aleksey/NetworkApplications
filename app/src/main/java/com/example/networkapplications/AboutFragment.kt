package com.example.networkapplications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.networkapplications.entity.Fact


class AboutFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text: TextView = view.findViewById(R.id.text)
        val textType: TextView = view.findViewById(R.id.textType)
        val textVersion: TextView = view.findViewById(R.id.textVersion)
        val textUpdate: TextView = view.findViewById(R.id.textUpvotes)

        val catImageView: ImageView = view.findViewById(R.id.imageCat)
        val catAnimation: Animation = AnimationUtils.loadAnimation(context, R.anim.cat_anim)
        catImageView.startAnimation(catAnimation)
        val bundle: Bundle? = arguments
        val fact: Fact? = bundle?.getParcelable("facts")
        Log.e("Text",fact?.text + " text")
        if(fact != null){
            text.text = fact.text
            Log.e("Text",fact.text + " text")
            textType.text = fact.type
            Log.e("Text",fact.type + " type")
            textVersion.text = fact.version.toString() + ""
            Log.e("Text", fact.version.toString() + " version")
            textUpdate.text = fact.upvotes.toString() + ""
            Log.e("Text", fact.upvotes.toString() + " upvotes")
        }
    }
}