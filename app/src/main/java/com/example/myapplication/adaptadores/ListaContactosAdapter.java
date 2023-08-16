package com.example.myapplication.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.VerActivity;
import com.example.myapplication.entidades.Contactos;

import java.util.ArrayList;

public class ListaContactosAdapter extends RecyclerView.Adapter<ListaContactosAdapter.ContactoViewHolder> {
    ArrayList<Contactos> listarContactos;
    public ListaContactosAdapter(ArrayList<Contactos> listarContactos){
        this.listarContactos = listarContactos;
    }
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contacto, null, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.viewNombre.setText(listarContactos.get(position).getNombre());
        holder.viewTelefono.setText(listarContactos.get(position).getTelefono());
        holder.viewCorreo.setText(listarContactos.get(position).getCorreo_electronico());

    }

    @Override
    public int getItemCount() {
        return listarContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre, viewTelefono, viewCorreo;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewTelefono = itemView.findViewById(R.id.viewTelefono);
            viewCorreo = itemView.findViewById(R.id.viewCorre_electronico);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = viewNombre.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID", listarContactos.get(getAdapterPosition()).getId());
                    context.startActivity(intent);

                }
            });
        }
    }
}
