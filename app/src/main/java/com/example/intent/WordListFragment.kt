package com.example.intent

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.intent.databinding.FragmentWordListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WordListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WordListFragment : Fragment() {
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX ="https://www.google.com/search?q="
    }
    private var _binding: FragmentWordListBinding? = null
    private val binding get() = _binding!!
    private lateinit var letterId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            letterId = it.getString(LETTER).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = WordAdapter(letterId, requireContext())

        recyclerView.addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}