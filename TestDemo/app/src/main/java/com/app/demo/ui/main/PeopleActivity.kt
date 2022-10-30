package com.app.demo.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.app.demo.R
import com.app.demo.model.PeopleModel
import com.app.demo.network.ResultData
import com.app.demo.ui.main.adapter.PeopleAdapter
import com.app.demo.ui.main.viewmodel.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "PeopleActivity"
@AndroidEntryPoint
class PeopleActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private val mainViewModel: PeopleViewModel by viewModels()
    private lateinit var repositoriesAdapter: PeopleAdapter
    private val repositoryObserver = Observer<ResultData<PeopleModel?>> { resultData ->
        when(resultData) {
            is ResultData.Loading -> {
                progressIndicator.show()
            }
            is ResultData.Success -> {
                progressIndicator.hide()
                val repositoriesModel = resultData.data
                repositoriesAdapter.submitList(repositoriesModel)
            }
            is ResultData.Failed -> {
                progressIndicator.hide()
            }
            is ResultData.Exception -> {
                progressIndicator.hide()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repositoriesAdapter = PeopleAdapter()
        recycler_view_repositories.adapter = repositoriesAdapter

        swipe_refresh.setOnRefreshListener(this)

        getDataAndSubscribeEvents()
    }

    private fun getDataAndSubscribeEvents() {
        val repositoriesListLiveData = mainViewModel.getPeopleRepositoriesList(since = "20")
        repositoriesListLiveData.observe(this, repositoryObserver)
    }

    override fun onRefresh() {
        swipe_refresh.isRefreshing = false
      //  getDataAndSubscribeEvents()
    }
}