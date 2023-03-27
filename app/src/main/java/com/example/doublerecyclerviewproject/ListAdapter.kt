package com.example.doublerecyclerviewproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doublerecyclerviewproject.databinding.ItemListBinding

class ListAdapter(val data:MutableMap<String, MutableList<String>>): RecyclerView.Adapter<ListAdapter.CustomViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding: ItemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding
        binding.tvName.text = data.keys.elementAt(position).toString()
        // recyclerView2 : adapter, LinearLayoutManager 제공해야됨. Adapter(데이터)
        val dataSubList = mutableListOf<DataSub>()
        for(i in 1..10){
            if(i % 2 == 0){
                dataSubList.add(DataSub("${data.values.elementAt(position)[(i-1)%4]}",R.drawable.face_man))
            }else{
                dataSubList.add(DataSub("${data.values.elementAt(position)[(i-1)%4]}",R.drawable.face_woman))
            }
        }
        binding.recyclerview2.apply {
            adapter = ListAdapter2(dataSubList)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            //속도개선을 위함. : 뿌려줘야할 아이템데이터뷰는 모두 같은 사이즈이므로 사이즈 계산을 하지 않도록 지시
            setHasFixedSize(true)
        }
    }

    class CustomViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
}