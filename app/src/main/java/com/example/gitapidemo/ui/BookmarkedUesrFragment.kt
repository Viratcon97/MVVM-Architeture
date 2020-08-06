package com.example.gitapidemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gitapidemo.R
import com.example.gitapidemo.viewModel.PageViewModel

/**
 * A placeholder fragment containing a simple view.
 */
class BookmarkedUesrFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     /*   pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    */}

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bookmarkeduser, container, false)
        val textView: TextView = root.findViewById(R.id.label)

        textView.text = "Bookmarked User"
       return root
    }

}