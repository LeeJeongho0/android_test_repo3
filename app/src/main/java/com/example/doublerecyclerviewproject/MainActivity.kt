package com.example.doublerecyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doublerecyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var dataMap:MutableMap<String, MutableList<String>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataMap = mutableMapOf<String, MutableList<String>>()
        for(i in 1..10){
            dataMap.set("사람${i}", mutableListOf("외국인1","외국인2","외국인3","외국인4"))
        }
        binding.recyclerView.adapter = ListAdapter(dataMap)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //속도개선을 위함. : 뿌려줘야할 아이템데이터뷰는 모두 같은 사이즈이므로 사이즈 계산을 하지 않도록 지시
        binding.recyclerView.setHasFixedSize(true)
    }
}