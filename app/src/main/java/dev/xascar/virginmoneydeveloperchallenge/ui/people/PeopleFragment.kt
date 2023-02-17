package dev.xascar.virginmoneydeveloperchallenge.ui.people

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.xascar.virginmoneydeveloperchallenge.R
import dev.xascar.virginmoneydeveloperchallenge.data.model.people.PeopleModel
import dev.xascar.virginmoneydeveloperchallenge.databinding.FragmentPeopleBinding
import dev.xascar.virginmoneydeveloperchallenge.util.ResponseType

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    private var _binding: FragmentPeopleBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val sharedViewModel: PeopleViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)

        sharedViewModel.result.observe(viewLifecycleOwner) {
            when (it) {
                is ResponseType.Loading -> {
                    Toast.makeText(context, "Loading. . .", Toast.LENGTH_SHORT).show()
                }
                is ResponseType.Success -> {
                    initViews(it.data)
                }
                is ResponseType.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        sharedViewModel.getPeopleList()

        return binding.root
    }

    private fun initViews(data: PeopleModel?) {


        parentFragmentManager.commit {
            replace(R.id.fragment_details,DetailsFragment())
        }



        data?.let {
            binding.rvPeople.layoutManager = LinearLayoutManager(context)
            binding.rvPeople.adapter = PeopleAdapter(it) { selectedUser ->
                Log.d("PeopleFragment", "initViews: ")
                sharedViewModel.selectUser(selectedUser)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}