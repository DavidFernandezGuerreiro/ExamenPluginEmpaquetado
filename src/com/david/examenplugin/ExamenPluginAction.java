/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.examenplugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.david.examenplugin.ExamenPluginAction"
)
@ActionRegistration(
        iconBase = "com/david/examenplugin/iconoPlugin.png",
        displayName = "#CTL_ExamenPluginAction"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_ExamenPluginAction=ExamenPlugin")
public final class ExamenPluginAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
