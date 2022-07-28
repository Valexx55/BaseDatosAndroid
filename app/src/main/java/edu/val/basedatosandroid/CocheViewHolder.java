package edu.val.basedatosandroid;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CocheViewHolder extends RecyclerView.ViewHolder {

    private TextView modelo_coche;

    public CocheViewHolder(@NonNull View itemView) {
        super(itemView);
        this.modelo_coche = itemView.findViewById(R.id.modelo_coche);
    }

    public void cargarCocheEnHolder (Coche coche)
    {
        this.modelo_coche.setText(coche.getModelo());
    }
}
