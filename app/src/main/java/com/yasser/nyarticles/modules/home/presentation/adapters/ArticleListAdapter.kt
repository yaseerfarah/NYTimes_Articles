package com.yasser.nyarticles.modules.home.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.yasser.nyarticles.core.extensions.loadImage
import com.yasser.nyarticles.core.extensions.onClick
import com.yasser.nyarticles.databinding.ItemArticleBinding
import com.yasser.nyarticles.modules.home.presentation.uimoddel.ArticleDiffUtils
import com.yasser.nyarticles.modules.home.presentation.uimoddel.ArticleUiModel
import java.util.concurrent.TimeUnit


class ArticleListAdapter constructor(
    private val context: Context,
    private val onClick:(ArticleUiModel)->Unit,
) : RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {
    private val mDiffer: AsyncListDiffer<ArticleUiModel?> =
        AsyncListDiffer(this, ArticleDiffUtils)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mDiffer.currentList[position]!!
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val bind = ItemArticleBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(bind)
    }

    inner class ViewHolder constructor(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArticleUiModel) {
            binding.articleCover.loadImage(item.imageUrl,placeholderDrawable = null, progressBar = binding.progressBar)
            binding.title.text=item.title
            binding.section.text=item.section
            binding.date.text=item.publishedDate
            binding.description.text=item.abstract
            binding.source.text="By ${item.source}"
            initAction(item)

        }
        private fun initAction(item: ArticleUiModel){
            binding.articleContainer.onClick {
                onClick.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    fun submitList(items: List<ArticleUiModel>) {
        mDiffer.submitList(items)
    }
}


