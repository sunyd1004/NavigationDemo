package com.sunyd.navigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState).apply {
            view.findViewById<Button>(R.id.go_back_fragment_1).setOnClickListener {
                Navigation.findNavController(view).popBackStack()
            }

            view.findViewById<Button>(R.id.to_fragment_3).setOnClickListener {
                val fragment2Bundle = Fragment2Args.fromBundle(
                    bundleOf(
                        "title" to "Fragment3"
                    )
                ).toBundle()
                Navigation.findNavController(view).navigate(R.id.fragment_2_to_fragment_3, fragment2Bundle)
            }
        }
    }
}
