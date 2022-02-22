package com.vik.scoober.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.vik.scoober.R
import com.vik.scoober.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels<MainActivityViewModel>()
    private lateinit var adapter: RestaurantListAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        handleListeners()
        viewModel.getRestaurants()
    }

    private fun initViews() {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = RestaurantListAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun handleListeners() {

        viewModel.restaurantListData.observe(this, { list ->
            adapter.updateData(list)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val searchView =
            menu.findItem(R.id.action_search).actionView as androidx.appcompat.widget.SearchView
        searchView.imeOptions = EditorInfo.IME_ACTION_DONE
        setSearchView(searchView)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_sort) {
            showSortOptions()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSortOptions() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Sort By")
        builder.setSingleChoiceItems(
            viewModel.getSortingTypeList().toTypedArray(),
            viewModel.getCurrentSelectPosition()
        ) { dialog, position ->
            viewModel.setSortType(position)
            dialog.dismiss()
        }
        builder.show()

    }

    private fun setSearchView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { viewModel.searchList(it) }
                return false
            }

        })
    }
}