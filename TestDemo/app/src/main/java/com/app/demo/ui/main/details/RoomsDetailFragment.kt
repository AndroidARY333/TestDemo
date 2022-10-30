package com.app.demo.ui.main.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.demo.databinding.CharacterDetailFragmentBinding
import com.app.demo.model.PeopleModel
import com.app.demo.utility.autoCleared
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsDetailFragment : Fragment() {

    private var binding: CharacterDetailFragmentBinding by autoCleared()
   /* private val viewModel: CharacterDetailViewModel by viewModels()*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<PeopleModel.PeopleModelItem>("obj")?.let { bindCharacter(it) }

    }

   /* private fun setupObservers() {
        viewModel.character.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.characterCl.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.characterCl.visibility = View.GONE
                }
            }
        })
    }
*/
    private fun bindCharacter(character: PeopleModel.PeopleModelItem) {

        binding.name.text = character.firstName
        binding.species.text = character.lastName
        binding.status.text = character.email
        binding.gender.text = character.jobtitle
        Glide.with(binding.root)
            .load(character.avatar)
            .transform(CircleCrop())
            .into(binding.image)
    }
}
