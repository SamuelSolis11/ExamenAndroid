package com.example.examenandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class ListaAutosAdapter (val funcion: (Auto)-> Unit ) : RecyclerView.Adapter<ListaAutosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvId : TextView
        val tvNombre: TextView
        val tvPrecio: TextView
        val tvTipo: TextView
        val tvSeguro: TextView
        val constraintLayout: ConstraintLayout
        init {
            // Define click listener for the ViewHolder's View.
            tvId = view.findViewById(R.id.tvId)
            tvNombre = view.findViewById(R.id.tvNombre)
            tvPrecio = view.findViewById(R.id.tvPrecio)
            tvTipo = view.findViewById(R.id.tvTipo)
            tvSeguro= view.findViewById(R.id.tvSeguro)
            constraintLayout = view.findViewById(R.id.constraint)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item_view, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvId.text = Singleton.lista[position].id
        viewHolder.tvNombre.text = Singleton.lista[position].nombre
        viewHolder.tvPrecio.text = Singleton.lista[position].precio.toString()
        viewHolder.tvTipo.text = Singleton.lista[position].tipo
        viewHolder.tvSeguro.text = Singleton.lista[position].seguro

        viewHolder.itemView.setOnClickListener {
            funcion(Singleton.lista[position])
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = Singleton.lista.size
}
