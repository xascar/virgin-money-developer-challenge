package dev.xascar.virginmoneydeveloperchallenge.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import dev.xascar.virginmoneydeveloperchallenge.R
import dev.xascar.virginmoneydeveloperchallenge.databinding.FragmentDetailsBinding
import dev.xascar.virginmoneydeveloperchallenge.databinding.FragmentPeopleBinding
import dev.xascar.virginmoneydeveloperchallenge.util.DateTimeUtil.toDate

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

//    private val viewModel: PeopleViewModel by viewModels()

    //Shared view model:
    private val sharedViewModel: PeopleViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        sharedViewModel.selectedUser.observe(viewLifecycleOwner){
            binding.apply {
                tvName.text = "${it.firstName} ${it.lastName}"
                with(this.root) {
                    com.bumptech.glide.Glide.with(context)
                        .load(it.avatar)
                        .placeholder(dev.xascar.virginmoneydeveloperchallenge.R.drawable.animate_loading)
                        .centerCrop()
                        .override(256,256)
                        .into(ivUser)
                }
                tvEmail.text = "e-mail:\n ${it.email}"
                tvColor.text = "Favourite color:\n ${it.favouriteColor}"
                tvJob.text = it.jobtitle
                tvCreated.text = "Created at: ${it.createdAt?.toDate()}"
            }

        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}