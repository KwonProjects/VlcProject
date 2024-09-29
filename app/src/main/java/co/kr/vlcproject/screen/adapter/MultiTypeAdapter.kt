package co.kr.vlcproject.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.kr.vlcproject.databinding.ItemProductBinding
import co.kr.vlcproject.databinding.ItemUserBinding
import co.kr.vlcproject.model.Entity
import co.kr.vlcproject.model.ProductEntity
import co.kr.vlcproject.model.UserEntity

class MultiTypeAdapter(private val items: List<Entity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_PRODUCT = 0
        private const val TYPE_USER = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ProductEntity -> {
                TYPE_PRODUCT
            }
            is UserEntity -> {
                TYPE_USER
            }
            else -> 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_PRODUCT -> ProductViewHolder(ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            TYPE_USER -> UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductViewHolder -> holder.bind(items[position] as ProductEntity)
            is UserViewHolder -> holder.bind(items[position] as UserEntity)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductEntity) {
            binding.pName.text = item.title
            binding.pQuantity.text = item.quantity.toString()
        }
    }

    inner class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserEntity) {
            binding.uName.text = item.name
            binding.uAge.text = item.age.toString()
        }
    }
}
