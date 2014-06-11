/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.CardLayout;
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

    public ListaSeleccion(VistaPrincipal vis) {
        v = vis;
        String datosLista[] = {"MI MURO", "MI PERFIL", "MIS AMIGOS", "MIS GUSTOS", "BUSCAR USUARIOS"};
        lista = new JList(datosLista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (e.getValueIsAdjusting()) {
                    if (lista.getSelectedValue().equals("MI MURO")) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "muro");
                    } else if (lista.getSelectedValue().equals("MI PERFIL")) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "perfil");
                    } else if (lista.getSelectedValue().equals("MIS AMIGOS")) {
                        ((CardLayout) v.getPanelCards().getLayout()).show(v.getPanelCards(), "amigos");
                    } else if (lista.getSelectedValue().equals("MIS GUSTOS")) {

                    } else if (lista.getSelectedValue().equals("BUSCAR USUARIOS")) {
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
