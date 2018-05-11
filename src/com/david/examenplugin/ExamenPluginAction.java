/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.examenplugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
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
        String Bcategory=JOptionPane.showInputDialog("Bcategory: (Education)");
        String outdir=JOptionPane.showInputDialog("outdir: (donde lo quieres guardar)");
        String outfile=JOptionPane.showInputDialog("outfile: (nombre que quieres darle)");
        String srcdir=JOptionPane.showInputDialog("srcdir: (ruta)");
        String srcfiles=JOptionPane.showInputDialog("srcfiles: (nombre.jar)");
        String appclass=JOptionPane.showInputDialog("appclass: (main class)");
        String title=JOptionPane.showInputDialog("title: (titulo)");
        String Bicon=JOptionPane.showInputDialog("Bicon: (icono.png)");
                
        try {
            
            String cmd="cmd /c javapackager -deploy -native deb -Bcategory="+Bcategory+
                    " -outdir "+outdir+" -outfile "+outfile+" -srcdir "+srcdir+" -srcfiles "+srcfiles+
                    " -appclass "+appclass+" -title "+title+" -Bicon="+Bicon;
            
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            Process pr = rt.exec(cmd);
            
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            
            String line=null;
            
            while((line=input.readLine()) != null) {
                System.out.println(line);
            }
            
            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
 
            

    }
}
