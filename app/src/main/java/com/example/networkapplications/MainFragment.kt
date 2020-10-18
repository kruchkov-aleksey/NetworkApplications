package com.example.networkapplications

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.networkapplications.entity.BaseResponse
import com.example.networkapplications.entity.Fact
import kotlinx.android.synthetic.main.fragment_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment: Fragment(), DataAdapter.RecyclerViewClickListener {
    private var MY_SETTINGS: String = "my_settings"
    var recyclerView: RecyclerView? = null
    var facts: ArrayList<Fact> = arrayListOf()
    private var listener: DataAdapter.RecyclerViewClickListener = object :
        DataAdapter.RecyclerViewClickListener {
        override fun onClick(facts: List<Fact>?, position: Int) {
            val fragmentReplace = AboutFragment()

            val bundle = Bundle()
            bundle.putParcelable("facts", facts?.get(position))
            Log.e("Text",facts?.get(position)?.text + " text")
            fragmentReplace.arguments = bundle
            requireFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragmentReplace, TAG)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(TAG)
                .commit()
        }
    }
    companion object {
        val TAG: String? = "com.example.networkapplications.MainFragment"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        facts = ArrayList()
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        rvList.layoutManager = layoutManager
        val mPresenter = FactsPresenter(requireContext(),this)
        val adapter = DataAdapter(facts, listener)
        rvList.adapter = adapter
        requireActivity().getSharedPreferences(
            MY_SETTINGS,
            Context.MODE_PRIVATE
        )
    }
    fun FailedFacts(){
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

    fun SuccessFacts(response: Response<BaseResponse>){
        facts.addAll(response.body()?.all ?: listOf())
        rvList.adapter?.notifyDataSetChanged()
    }
    override fun onClick(facts: List<Fact>?, position: Int) {
        Log.e("onClick","onClick")
    }
}