<<<<<<< HEAD
*This branch is only for testing 

=======
>>>>>>> 5871df53e48bf51d6deb1bc838d3ff9085fc9aa7
# Solitario

El solitario es un juego de cartas para el que no necesitas a nadie más. Este solitario está pensado para esos momentos
de aburrimiento o de viajes eternos. Solo necesitas una baraja española y a ti mismo.



# Objetivo del juego

Para jugar al solitario son necesarias 40 cartas de la baraja española. La baraja está compuesta de 4 palos (oros,
espadas, bastos y copas) cada uno con siete cartas enumeradas del 1 al 7 y tres figuras (sota, caballo y rey)
correspondientes a los números 10, 11 y 12 respectivamente.
El objetivo del juego es comenzar con todas las cartas desordenadas y terminar con cuatro montones ordenados de
menor a mayor, uno para cada palo de la baraja.


# Cómo jugar al solitario

Se colocan 16 cartas boca abajo, formando 4 columnas y 4 filas. A continuación, se colocan 8 cartas boca abajo encima
de aquellas que están en las diagonales. Por último, se colocan boca arriba las 16 cartas restantes, encima de las que
ya están colocadas (a esta zona se llamará zona-Interior).
El objetivo es ir quitando las cartas de la zona-interior de menor a mayor colocándolas en cuatro montones exteriores,
(uno para cada palo) que han de empezar con la carta numerada con el 1.


# Reglas del juego

- Se puede mover una carta de la zona-interior al montón exterior si la última carta almacenada en el montón
exterior es del mismo palo y una unidad más pequeña que la que se quiere colocar (fíjate que después del 7
viene el 10). Si debajo de ella existiese una carta boca abajo se gira para hacerla visible.
- Si el montón exterior está vacío, sólo se podrá colocar una carta que contenga un as.
- En la zona-interior se puede mover una carta sobre otra, siempre que la carta que se va a ocultar sea del
mismo palo y una unidad mayor que la que se mueve (fíjate que encima del 10 se debe colocar un 7). Este
movimiento tiene como objetivo hacer visible la carta que está debajo de la que se está moviendo.
- No se puede mover una carta a un hueco vacío en la zona-interior. 

# Final de una partida

El juego continúa siempre que exista un movimiento posible, es decir, un movimiento de una carta a algún montón
exterior o un movimiento dentro de la zona-interior. El juego puede finalizar con dos situaciones:

- Los montones exteriores contienen todas las cartas
Los cuatro montones exteriores tienen 10 cartas del mismo palo ordenados de menor a mayor. Objetivo
conseguido

- No hay más movimientos posibles y quedan cartas en la zona-interior
Puede ocurrir que el solitario no finalice, quedan cartas en la zona-interior y no es posible ningún movimiento.
Objetivo no conseguido

# PROYECTO A ENTREGAR: 

1. El trabajo será colaborativo, es decir se realizará en grupo de 4/5 alumnos/as, que deben pertenecer al mismo
  grupo reducido de AEDI. La formación de los equipos corre por cuenta de los alumnos e informarán a la profesora.
  Los alumnos no presenciales también deben realizar el proyecto y formarán grupo con otros alumnos no
  presenciales. Si tienen dificultad para formar grupo deben hablar con la profesora de la asignatura, que estudiará
  cada caso.

2. El trabajo consiste en desarrollar un proyecto que implemente el juego del Solitario siguiendo las reglas
  anteriormente expuestas, utilizando el lenguaje de programación JAVA y el entorno NetBeans.
  
3. La estructura del proyecto, en la que están identificadas las clases implicadas en el diseño de la aplicación está
  disponible en faitic, sección Documentos e Ligazóns / Proyecto colaborativo. El proyecto está organizado en 2
  paquetes: IU y core. Algunas clases están completamente implementadas y otras deben ser desarrolladas por
  el grupo.
  
4. La profesora repartirá el trabajo entre todos los miembros del grupo, de modo que cada uno de los miembros
  debe ocuparse de desarrollar alguna/s de la/s clase/s. También sería preciso nombrar un coordinador de grupo,
  siendo el responsable de la coordinación del proyecto. Si algún miembro del grupo no cumple sus funciones, el
  coordinador del grupo debe comunicárselo a la profesora.
  
5. Cada miembro del grupo debe ser responsable de su trabajo, de comunicarse con otros miembros del grupo y
  de conocer todas las partes del proyecto. Además, debe reflexionar y desarrollar cada clase implementando los
  métodos. Se debe tener especial cuidado en controlar la visibilidad de los atributos, métodos, además de utilizar
  los algoritmos y las estructuras de datos adecuadas en cada caso.
  
6. Respecto al funcionamiento del juego, deben cumplirse las siguientes condiciones:
  a. Hay que validar los datos de entrada al juego.
  b. El juego continuará mientras exista algún movimiento posible (esta comprobación se realizará de forma
  automática).
  c. Para seleccionar el movimiento a realizar se deberá mostrar únicamente la carta superior de cada
  posición de la zona-interior (representando su número y palo). Si una posición está vacía también debe
  representarse. Además, debe mostrarse la última carta de los montones exteriores (representando su
  número y palo). Si el montón está vacío también debe representarse.
  
7. La fecha tope para subir el proyecto a Faitic de forma individual (cada miembro subirá el proyecto completo) será
  el miércoles 29 de abril de 2020 a las 23:00h, en el apartado Exercicios / Entrega Proyecto.
  
8. Solo se admiten proyectos que compilen y que se ejecuten cumpliendo las reglas del juego.

9. El descubrimiento de copias del proyecto supondrá el suspenso del mismo, tanto para el grupo con
  código original, como para el grupo con la copia.
