package liste

import android.os.Bundle
import android.renderscript.Sampler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tsirava.mobile.R
import java.time.temporal.ValueRange

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CocktailFirstFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CocktailAdapter(listOf())
    private val layoutManager = LinearLayoutManager (context)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_cocktail_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.cokctail_recyclerview)

        recyclerView.apply {
            layoutManager = this@CocktailFirstFragment.layoutManager
            adapter = this@CocktailFirstFragment.adapter

        }

        val cocktaillist = arrayListOf<cocktail>().apply {
            add(cocktail("vodka"))
            add(cocktail("maythay"))
            add(cocktail("mojito"))
            add(cocktail("martini"))
        }

        adapter.updateList(cocktaillist)

    }

}