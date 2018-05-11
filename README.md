# ExamenPluginEmpaquetado
Examen Contornos de desarrollo.

## Están creados los archivos creados del empaquetado en la carpeta del plugin, para mostrar que se me generó correctamente el archivo .deb dentro de la carpeta bundles.


## 1.-Crear un Modulo en NetBeans.

Le damos un nombre al módulo, en Code Name Base: com.david.examenplugin

Modulo, click derecho, New... Action.

Category: FIle. Seleccionamos: Global ToolBar Button.

Le damos un nombre a la clase.  Class Name: ExamenPluginAction.
                                Display Name: ExamenPlugin.
                                Icon: (Ruta del icono).
                                
Para instalar el Plugin:

-Creamos el .jar.
-ExamenPlugin, click derecho, Properties, Buld, Packaging:  Licencse: licencia
                                                            Home Page: Pagina web del desarrollador
                                                            Author: Nombre del desarrollador
                                                            
Creamos el archivo .NBM

ExamenPlugin, click derecho, create NBM.


## 2.-En el ActionPerformed que se crea automaticamente. Le añadí el siguiente código:

En el código siguiente, te pide las rutas, el .jar, el nombre de la aplicación, el titulo de la aplicación, el icono.

Y te crea los archivos y dentro de la carpeta bundles se encuentra el paquete con la extensión .deb.

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

  String cmd="javapackager -deploy -native deb -Bcategory="+Bcategory+
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




