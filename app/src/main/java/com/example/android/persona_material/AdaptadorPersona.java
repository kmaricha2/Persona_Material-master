package com.example.android.persona_material;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 30/04/2018.
 */


public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder> {
    private ArrayList<Persona> personas;
    private Resources res;
    private OnPersonaClickListener clickListener;

    public AdaptadorPersona(Context contexto, ArrayList<Persona> personas,OnPersonaClickListener clickListener) {
        this.personas = personas;
        this.res = contexto.getResources();
        this.clickListener=clickListener;
    }

    @Override
    public AdaptadorPersona.PersonaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_persona,parent,false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorPersona.PersonaViewHolder holder, int position) {
     final Persona p = personas.get(position);
        holder.foto.setImageDrawable(ResourcesCompat.getDrawable(res,p.getFoto(),null));
        holder.nombre.setText(p.getNombre());
        holder.apellido.setText(p.getApellido());
        holder.cedula.setText(p.getCedula());
        holder.v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                clickListener.onPersonaClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static  class  PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;
        private TextView apellido,cedula;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.idFoto);
            cedula = v.findViewById(R.id.lblcedula);
            nombre = v.findViewById(R.id.lblnombre);
            apellido = v.findViewById(R.id.lblapellido);

        }
    }

    public interface  OnPersonaClickListener{
        void onPersonaClick(Persona p);
    }
}
