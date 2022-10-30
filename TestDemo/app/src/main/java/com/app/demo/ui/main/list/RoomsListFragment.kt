package com.app.demo.ui.main.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.demo.R
import com.app.demo.databinding.PeopleFragmentBinding
import com.app.demo.model.PeopleModel
import com.app.demo.network.ResultData
import com.app.demo.ui.main.adapter.PeopleListAdapter
import com.app.demo.ui.main.viewmodel.PeopleViewModel
import com.app.demo.utility.autoCleared

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsListFragment : Fragment() , PeopleListAdapter.CharacterItemListener{//, CharactersAdapter.CharacterItemListener

    private var binding: PeopleFragmentBinding by autoCleared()
  //  private val viewModel: CharactersViewModel by viewModels()
  //  private lateinit var adapter: CharactersAdapter

    private val viewModel: PeopleViewModel by viewModels()
    private lateinit var adapter: PeopleListAdapter

    private val repositoryObserver = Observer<ResultData<PeopleModel?>> { resultData ->
        when(resultData) {
            is ResultData.Loading -> {
                //  progress_bar.show()
                binding.progressBar.visibility = View.VISIBLE
            }
            is ResultData.Success -> {
//                progressIndicator.hide()
                binding.progressBar.visibility = View.GONE
                val repositoriesModel = resultData.data
                adapter.submitList(repositoriesModel)
            }
            is ResultData.Failed -> {
//                progressIndicator.hide()
                binding.progressBar.visibility = View.GONE
            }
            is ResultData.Exception -> {
//                progressIndicator.hide()
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PeopleFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

//        swipe_refresh.setOnRefreshListener(this)

       /* binding.testClick.setOnClickListener(View.OnClickListener {
            findNavController().navigate(
                R.id.action_charactersFragment_to_characterDetailFragment,
                bundleOf("id" to 3)//characterId
            )
        })*/

        getDataAndSubscribeEvents()
    }

    private fun getDataAndSubscribeEvents() {
        val repositoriesListLiveData = viewModel.getPeopleRepositoriesList(since = "20")
        repositoriesListLiveData.observe(viewLifecycleOwner, repositoryObserver)
    }


    override fun onClickedCharacter(characterId: PeopleModel.PeopleModelItem) {
        val bundle = Bundle()
        bundle.putParcelable("obj", characterId)
        findNavController().navigate(
            R.id.action_charactersFragment_to_characterDetailFragment,
            bundle
        )
    }

    private fun setupRecyclerView() {
        adapter = PeopleListAdapter(this)
        binding.charactersRv.layoutManager = LinearLayoutManager(requireContext())
        binding.charactersRv.adapter = adapter
    }
}
