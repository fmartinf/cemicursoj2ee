[![](http://subversion.tigris.org/images/subversion_logo_hor-468x64.png)](http://subclipse.tigris.org/)

# Introducción #

Sitio: http://subclipse.tigris.org/

Subversion es un sistema de control de versiones **colaborativo** (cada usuario se descarga la copia, la modifica y, o bien el sistema mezcla automaticamente las modificaciones, o bien requiere resolver posibles conflictos de forma manual)

Documentación oficial: [subclipse install use and compile.pdf](http://subclipse.tigris.org/files/documents/906/8847/file_8847.dat/subclipse%20-%20install%2c%20use%20and%20compile.pdf)

Libro oficial _online_: http://svnbook.red-bean.com/

# Instalación del plugin de SVN para Eclipse _Subclipse_ #

`Eclipse > Help > Install new software`

`Work with:` http://subclipse.tigris.org/update_1.10.x

Seleccionamos los dos componentes (Subclipse y SVNKit) y pulsamos `Next` y continuamos con la instalación hasta el final.

Cuando finalice la instalación, deberemos reiniciar Eclipse.


# Importando un proyecto Eclipse existente en SVN #

`Eclipse > File > Import > SVN > Checkout Projects from SVN`

En este paso deberemos indicarle la ruta del repositorio. En nuestro caso: https://cemicursoj2ee.googlecode.com/svn/trunk/

A continuación deberemos introducir nuestras credenciales de usuario (Usaremos el repositorio SVN de _Google Code_):
  * _Usuario:_ usuario@gmail.com
  * _Contraseña:_ [googleCode.com password](http://code.google.com/hosting/settings)

Si en SVN se encuentra el fichero _.project_, se definirá el nombre del proyecto especificado en dicho fichero, sino deberemos establecerlo nosotros.


# Operaciones básicas con SVN desde Eclipse #

Estados de un fichero:

![http://tortoisesvn.tigris.org/images/Overlays.png](http://tortoisesvn.tigris.org/images/Overlays.png)

![http://subclipse.tigris.org/images/menu-ss.png](http://subclipse.tigris.org/images/menu-ss.png)

**Actualizar _(check out)_: `Click-dcho > Team > Update`**

**Publicar _(check in)_: `Click-dcho > Team > Commit`**

**Deshacer cambios: `Click-dcho > Team > Revert`**

**Añadir fichero/s al control de versiones: `Click-dcho > Team > Add to version control`.**

**Ignorar fichero del control de versiones: `Click-dcho > Team > Add to svn:ignore`**

**Resolviendo conflictos: `Click-dcho > Team > Synchronize with repository`**

![http://subclipse.tigris.org/images/sync-ss.png](http://subclipse.tigris.org/images/sync-ss.png)

Posibilidades:

- azul: versión local es anterior a la del servidor. Precisa _update_

- gris: versión local coincidente con la del servidor y el fichero local se encuentra modificado. Precisa _commit_

- rojo: la versión local es anterior a la remota y dicho fichero se encuentra modificado. Precisa _merge_ o _revert_.

# Compartir proyectos en un repositorio SVN #

`Eclipse > [proyecto] click dcho > Team > Share project... > SVN > Checkout Projects from SVN`

Si tu proyecto ya contiene carpetas [.svn] te avisará que si continuas se borraran. Marca `"Continue and have Subclipse just remove those folders for you"`

`Create a new repository location` > http://svnserver/svnrepo > `Use specified folder name` > Select > `trunk` (la carpeta final debe ser `trunk/nombre_proyecto`

Si se requiere autenticarse, será necesario introducir las credenciales username/password > Save password

Por último: `Finish`