package dev.xascar.virginmoneydeveloperchallenge.ui.room


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.xascar.virginmoneydeveloperchallenge.data.model.room.RoomModel
import dev.xascar.virginmoneydeveloperchallenge.databinding.FragmentRoomBinding
import dev.xascar.virginmoneydeveloperchallenge.util.ResponseType


@AndroidEntryPoint
class RoomFragment : Fragment() {

    private var _binding: FragmentRoomBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RoomViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRoomBinding.inflate(inflater, container, false)

        viewModel.result.observe(viewLifecycleOwner) {
            when(it) {
                is ResponseType.Loading -> {
                    Toast.makeText(context, "Loading. . .!", Toast.LENGTH_SHORT).show()
                }
                is ResponseType.Success -> {
                    initView(it.data)
                }
                is ResponseType.Error -> {
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        viewModel.getRoomList()

        return binding.root
    }

    private fun initView(data: RoomModel?) {
        data?.let {
            binding.rvRoom.apply {
                // staggeredGridLayoutManager with 3 rows and horizontal orientation
                layoutManager =  StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
//                layoutManager =  LinearLayoutManager(context)
                adapter = RoomAdapter(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}