Para este proyecto del diseño de una calculadora con AWT decidí utilizar el GridBagLayout y GridBagConstarin, con los que fijaría los botonoces mediante el posicionamiento
de las filas y columnas. 
Creé tres paneles, llamados numbersPanel, opsPanel y displayPanel, en los cuales situaría los distintos grupos de botones y el Label que utilizaría para la entrada y salida
de los números.
A cada Panel le establecería un número concreto de filas y un número concreto de columnas para así organizar los botones de una manera especifica y situar cada panel en una 
zona específica de la ventana.
Para crear cada grupo de botones decidí crear dos métodos, uno que me creara los numeros, y otro que me creara los signos, ya que cada grupo de botones iba a tener
unas especificaciones como el Background y Foreground distinas, dentro del método para crear los botones de los signos también realizo cambios dependiendo del boton que quiero
crear, como en el caso del botón con el signo "=" al que le establezco un Background diferente al del resto de botones de los signos.
El código está lo mejor comentado posible, considero que hay cosas que pude mejorar, pero se me hizo muy difícil ya que la información respecto AWT es bastante escasa y difícil
de encontrar.
