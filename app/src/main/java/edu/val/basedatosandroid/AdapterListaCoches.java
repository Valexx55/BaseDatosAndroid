package edu.val.basedatosandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterListaCoches extends RecyclerView.Adapter<CocheViewHolder> {

    private List<Coche> lista_coches;

    public AdapterListaCoches (List<Coche> lista_coches)
    {
        this.lista_coches = lista_coches;
    }

    @NonNull
    @Override
    public CocheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CocheViewHolder cocheViewHolder = null;

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View fila_coche = layoutInflater.inflate(R.layout.fila_coche, parent, false);
        cocheViewHolder = new CocheViewHolder(fila_coche);

        return cocheViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CocheViewHolder holder, int position) {

            Coche c = lista_coches.get(position);
            holder.cargarCocheEnHolder(c);

    }

    @Override
    public int getItemCount() {
        return lista_coches.size();
    }
}
