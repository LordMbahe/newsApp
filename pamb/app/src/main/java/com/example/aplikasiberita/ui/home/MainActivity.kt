package com.example.aplikasiberita.ui.home

import android.os.Bundle
import com.crocodic.core.base.adapter.CoreListAdapter
import com.example.aplikasiberita.R
import com.example.aplikasiberita.base.activity.BaseActivity
import com.example.aplikasiberita.data.model.Article
import com.example.aplikasiberita.databinding.ActivityMainBinding
import com.example.aplikasiberita.databinding.ItemBeritaBinding

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {

    private var articles = ArrayList<Article?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayoutRes(R.layout.activity_main)

        getArticle()
        observe()

        setRecyclerView()

    }

    private fun setRecyclerView() {
        binding.rvBerita.adapter = CoreListAdapter<ItemBeritaBinding, Article>(R.layout.item_berita).initItem(articles)
    }

    private fun observe() {
        viewModel.article.observe(this, {
            articles.clear()
            binding.rvBerita.adapter?.notifyDataSetChanged()

            articles.addAll(it)
            binding.rvBerita.adapter?.notifyItemInserted(0)

        })
    }

    private fun getArticle() {
        viewModel.getList(1)
    }
}