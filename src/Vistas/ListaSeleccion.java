/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.CardLayout;
import java.util.ResourceBundle;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author SandyG
 */
public class ListaSeleccion {

    JList lista;
    ListSelectionModel listaSeleccion;
    VistaPrincipal v;
    ResourceBundle bundle;
//cambia de cards segun selecciones
    public ListaSeleccion(final ResourceBundle bundle,VistaPrincipal vis) {
        this.bundle=bundle;
        v = vis;
        String datosLista[] = {bundle.getString("muro"), bundle.getString("perfil"), bundle.getString("amigos"), bundle.getString("gustos"), bundle.getString("buscar_u")};
        lista = new JList(datosLista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (e.getValueIsAdjusting()) {
                    if (lista.getSelectedValue().equals(bundle.getString("muro"))) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "muro");
                    } else if (lista.getSelectedValue().equals(bundle.getString("perfil"))) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "perfil");
                    } else if (lista.getSelectedValue().equals(bundle.getString("amigos"))) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "amigos");
                    } else if (lista.getSelectedValue().equals(bundle.getString("gustos"))) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "misGustos");
                    } else if (lista.getSelectedValue().equals(bundle.getString("buscar_u"))) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "buscarUsuarios");
                    }

                }
            }
        });
    }

    public JList getLista() {
        return lista;
    }

}
