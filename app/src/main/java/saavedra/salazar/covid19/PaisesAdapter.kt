package saavedra.salazar.covid19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pais_item.view.*
import ramirez.lopez.covid19.R

class PaisesAdapter(paises:ArrayList<Pais>,contexto:Context): RecyclerView.Adapter<PaisesAdapter.ViewHolder>(){
    var listaPaises:ArrayList<Pais>?=null
    var contexto:Context?=null

    init {
        this.listaPaises = paises
        this.contexto = contexto
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val vistaPais:View = LayoutInflater.from(contexto).inflate(R.layout.pais_item,p0,false)
        val paisViewHolder = ViewHolder(vistaPais)
        vistaPais.tag = paisViewHolder
        return paisViewHolder
    }

    override fun getItemCount(): Int {
        return listaPaises!!.count()
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.nombrePais!!.text = listaPaises!![p1].nombre
        p0.numeroConfirmados!!.text = "${listaPaises!![p1].confirmados}"
        p0.numeroMuertos!!.text = "${listaPaises!![p1].muertos}"
        p0.numeroRecuperados!!.text = "${listaPaises!![p1].recuperados}"
        Picasso.get().load("https://www.countryflags.io/${listaPaises!![p1].codigoPais}/flat/64.png").into(p0.bandera)
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        var nombrePais:TextView?=null
        var numeroConfirmados:TextView?=null
        var numeroMuertos:TextView?=null
        var numeroRecuperados:TextView?=null
        var bandera:ImageView?=null

        init {
            nombrePais = vista.tvNombrePais
            numeroConfirmados = vista.tvConfirmados
            numeroMuertos = vista.tvMuertos
            numeroRecuperados = vista.tvRecuperados
            bandera = vista.ivBandera
        }

    }

}