package com.example.examenandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.examenandroid.databinding.FragmentAgregarAutoBinding
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class AgregarAutoFragment :  Fragment() {
    private var _binding: FragmentAgregarAutoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        _binding = FragmentAgregarAutoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGuardar.setOnClickListener {
            val auto = Auto(

                id = binding.editId.text.toString(),
                nombre = binding.editNombre.text.toString(),
                precio = binding.editPrecio.text.toString().toDouble(),
                color = binding.editColor.text.toString(),
                tipo = if (binding.chbElectrico.isChecked) {
                    "Eléctrico"
                } else {
                    "De Gasolina"
                },
                seguro = when (binding.rgseguro.checkedRadioButtonId) {
            R.id.radioButton -> "Si"
            R.id.radioButton2 -> "No"
            else -> "Valor predeterminado"
        }
            )
            Singleton.lista.add(auto)
            Snackbar.make(it, "Auto guardado",Snackbar.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_AgregarAutosFragment_to_ListaAutosFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


