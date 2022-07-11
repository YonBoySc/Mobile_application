package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.main_content.*


class SecondActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter:MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        nav_view.setNavigationItemSelectedListener(this)

        var list = ArrayList<ListItem>()
        var list_of_pdd_content = resources.getStringArray(R.array.PDD_content)
        for (n in 0..list_of_pdd_content.size - 1)
        {
            var listItem = ListItem(list_of_pdd_content[n])
            list.add(listItem)
        }

        rcView.hasFixedSize()
        rcView.layoutManager= LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //тут мы пишем, что происходит при нажатии на кнопки меню
        when(item.itemId){
            R.id.id_PDD -> {
                var PDD_list = ArrayList<ListItem>()
                var list_of_pdd_content = resources.getStringArray(R.array.PDD_content)
                for (n in 0..list_of_pdd_content.size - 1)
                {
                    var listItem = ListItem(list_of_pdd_content[n])
                    PDD_list.add(listItem)
                }
                adapter?.updateAdapter(PDD_list)
            }
            R.id.id_DTP -> {
                var DTP_list = ArrayList<ListItem>()
                var list_of_dtp_content = resources.getStringArray(R.array.DTP_content)
                for (n in 0..list_of_dtp_content.size - 1)
                {
                    var listItem = ListItem(list_of_dtp_content[n])
                    DTP_list.add(listItem)
                }
                adapter?.updateAdapter(DTP_list)
            }
            R.id.id_important_questions -> {
                var important_list = ArrayList<ListItem>()
                var list_of_important_content = resources.getStringArray(R.array.important_content)
                for (n in 0..list_of_important_content.size - 1)
                {
                    var listItem = ListItem(list_of_important_content[n])
                    important_list.add(listItem)
                }
                adapter?.updateAdapter(important_list)
            }
        }
        return true
    }

}
