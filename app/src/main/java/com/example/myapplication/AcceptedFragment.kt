package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_accepted.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Accepted.newInstance] factory method to
 * create an instance of this fragment.
 */
class Accepted : Fragment() {

    private  lateinit var  recyclerView: RecyclerView
    val list = mutableListOf<ListItem>()
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )

            : View? {
        val rootView = inflater.inflate(R.layout.fragment_accepted, container, false)

        list.add(0,ListItem(R.drawable.type_car,"أريد مساعده","منذ يوم", "ذكر", "في المنزل", "3"))
        list.add(1,ListItem(R.drawable.type_car,"أريد مساعده","منذ يوم", "ذكر", "في المنزل", "5"))
        list.add(2,ListItem(R.drawable.type_car,"أريد مساعده","منذ يوم", "ذكر", "في المنزل", "6"))
        list.add(3,ListItem(R.drawable.type_car,"أريد التوصيل الى المطار","منذ يوم", "انثى", "في المنزل", "4"))



        recyclerView = rootView.findViewById(R.id.recylcview) as RecyclerView // Add this

        recyclerView.adapter = MyAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)

        return rootView

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Accepted.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Accepted().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}