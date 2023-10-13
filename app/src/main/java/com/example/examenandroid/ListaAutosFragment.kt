package com.example.examenandroid
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.example.examenandroid.databinding.FragmentListaAutosBinding
import androidx.navigation.fragment.findNavController

class ListaAutosFragment : Fragment() {
    private var _binding: FragmentListaAutosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaAutosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //MENU
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_fragment_lista_autos,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId){
                    R.id.menu_fragment_lista_autos_to_fragment_autos ->{
                        findNavController().navigate(R.id.action_ListaAutosFragment_to_AgregarAutosFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner)

        binding.recyclerView.adapter = ListaAutosAdapter {
            EliminarAuto(it)
        }

    }

    fun MostrarAuto(auto: Auto){
        Toast.makeText(context,"Clic a ${auto.nombre}", Toast.LENGTH_SHORT).show()
    }

    fun EliminarAuto(auto: Auto){
        val dialog = EliminarAutoDialogFragment(auto) {
            binding.recyclerView.adapter = ListaAutosAdapter {
                EliminarAuto(it)
            }
        }
        activity?.let { dialog.show(it.supportFragmentManager, "EliminarAutoDialogFragment") }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}