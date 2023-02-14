package dev.xascar.virginmoneydeveloperchallenge.ui.people

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import dev.xascar.virginmoneydeveloperchallenge.databinding.FragmentPeopleBinding
import dev.xascar.virginmoneydeveloperchallenge.util.ResponseType

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: PeopleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.result.observe(viewLifecycleOwner) {
            when(it) {
                is ResponseType.Loading -> {
                    Toast.makeText(context, "Loading. . .!", Toast.LENGTH_SHORT).show()
                }
                is ResponseType.Success -> {
                    Toast.makeText(context, it.data.toString(), Toast.LENGTH_SHORT).show()
                }
                is ResponseType.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.getPeopleList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}