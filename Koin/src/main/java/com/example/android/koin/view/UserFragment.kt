package com.example.android.koin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.android.koin.R
import com.example.android.koin.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : Fragment() {

    private lateinit var adapter: UserAdapter
    private val viewModel by viewModel<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_koin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setObserves()
    }

    private fun init() {
        val button = requireView().findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val edittext = requireView().findViewById<EditText>(R.id.edittext)
            viewModel.validate(edittext.text.toString())
        }

        adapter = UserAdapter()
        val recyclerview = requireView().findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.adapter = adapter
    }

    private fun setObserves() {
        viewModel.getModelUpperCase().observe(viewLifecycleOwner, Observer { list ->
            adapter.updateList(list)
            val edittext = requireView().findViewById<EditText>(R.id.edittext)
            edittext.text.clear()
        })
    }
}
