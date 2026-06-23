# Sistema de Distribución Logística

## Integrantes

* Fuentes Santiago
* Pérez Julián
* Sánchez Ciro

## Alternativa Elegida

**Alternativa C - Sistema de Distribución Logística**

## Descripción General

El sistema permite gestionar el inventario
y la distribución de productos dentro de un 
almacén mediante la utilización de distintas estructuras de datos. 
Su objetivo es optimizar la localización de productos, la administración de pedidos,
el registro de movimientos de mercadería y la representación de la disposición física del almacén.

## Estructuras de Datos Utilizadas

* **Árbol Binario de Búsqueda (ABB):** búsqueda y gestión de productos mediante su identificador único.
* **Árbol AVL:** organización de productos según su stock, garantizando operaciones eficientes mediante balanceo automático.
* **Grafo:** representación de la distribución física del almacén mediante conexiones y pasillos.
* **Pila:** registro de movimientos de mercadería para permitir la reversión de acciones y mantener trazabilidad.
* **Cola:** administración de pedidos pendientes de despacho siguiendo el criterio FIFO (First In, First Out).

## Funcionalidades Implementadas

### Gestión de Productos

* Alta de productos.
* Baja de productos.
* Modificación de productos.
* Búsqueda de productos por identificador.
* Consulta de productos ordenados por stock.
* Detección de productos con stock crítico.

### Gestión del Almacén

* Registro de conexiones del almacén.
* Registro de pasillos entre conexiones.
* Recorridos BFS y DFS sobre el grafo.
* Consulta de conexiones adyacentes.

### Gestión de Pedidos

* Recepción de pedidos.
* Consulta del próximo pedido a despachar.
* Despacho de pedidos respetando el orden de llegada.

### Gestión de Movimientos

* Registro de movimientos de lotes y mercadería.
* Consulta del último movimiento realizado.
* Reversión del último movimiento registrado.

## Distribución de Tareas

| Integrante       | Responsabilidad                          |
| ---------------- | ---------------------------------------- |
| Fuentes Santiago | Implementación de Árboles (ABB y AVL)    |
| Sánchez Ciro     | Implementación de la Cola de Pedidos     |
| Pérez Julián     | Implementación de la Pila de Movimientos |
| Pérez Julián     | Implementación del Grafo del Almacén     |

## Ejecución del Proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA o un IDE compatible con Java.
3. Compilar el proyecto.
4. Ejecutar la clase principal "Main.SistemaLogistico.java".
5. Para probar los casos de prueba, se ingresan los datos por la consola.

## Casos de Prueba

### Caso de Prueba 1 - Configuración inicial del almacén

**Objetivo:** Construir el grafo que representa el almacén.

#### Conexiones

| ID |
|--|
| 1 |
| 2 |
| 3 |
| 4 |
| 5 |
| 6 |
| 7 |
| 8 |
| 9 |

#### Pasillos
| ID Pasillo | Origen | Destino | Descripción | Tipo | Distancia |
|------------|---------|----------|-------------|------|-----------|
| 101 | 1 | 4 | Pasillo 101 | Vertical | 10 |
| 102 | 1 | 2 | Pasillo 102 | Horizontal | 10 |
| 103 | 4 | 7 | Pasillo 103 | Vertical | 10 |
| 104 | 2 | 3 | Pasillo 104 | Horizontal | 10 |
| 105 | 2 | 5 | Pasillo 105 | Vertical | 10 |
| 106 | 4 | 5 | Pasillo 106 | Horizontal | 10 |
| 107 | 5 | 8 | Pasillo 107 | Vertical | 10 |
| 108 | 5 | 6 | Pasillo 108 | Horizontal | 10 |
| 109 | 3 | 6 | Pasillo 109 | Vertical | 10 |
| 110 | 7 | 8 | Pasillo 110 | Horizontal | 10 |
| 111 | 6 | 9 | Pasillo 111 | Vertical | 10 |
| 112 | 8 | 9 | Pasillo 112 | Horizontal | 10 |

#### Verificaciones

- Existe conexión 3 → Sí.
- Existe conexión 10 → No.
- Existe pasillo entre 1 y 5 → Sí.
- Buscar pasillo ID 105 → Encontrado.
- BFS desde 1 → Recorre todas las conexiones.
- DFS desde 1 → Recorre todas las conexiones.

#### Resultado Obtenido

- Las 9 conexiones fueron registradas correctamente.
- Los 12 pasillos fueron registrados correctamente.
- La búsqueda de la conexión 3 devolvió resultado positivo.
- La búsqueda de una conexión inexistente devolvió resultado negativo.
- El pasillo ID 105 fue encontrado correctamente.
- Los recorridos BFS y DFS visitaron todas las conexiones del grafo sin errores.

**Estado:** Aprobado.

---

### Caso de Prueba 2 - Registro de productos

**Objetivo:** Poblar ABB y AVL simultáneamente.
#### Entrada

| ID | Nombre | Descripción | Stock |
|----|---------|-------------|--------|
| 50 | Arroz | Arroz largo fino | 20 |
| 30 | Fideos | Fideos spaghetti | 5 |
| 70 | Aceite | Aceite girasol | 40 |
| 20 | Harina | Harina 000 | 3 |
| 40 | Yerba | Yerba mate | 12 |

#### Verificaciones

- Buscar producto ID 40 → Encontrado.
- Buscar producto ID 99 → No encontrado.
- Mostrar catálogo ABB → Ordenado por ID.
- Mostrar AVL → Ordenado por stock.
- Mostrar productos con stock menor a 10.¿

#### Resultado Obtenido

- Los 5 productos fueron insertados correctamente en el ABB.
- Los 5 productos fueron insertados correctamente en el AVL.
- La búsqueda del producto ID 40 devolvió resultado positivo.
- La búsqueda del producto ID 99 devolvió resultado negativo.
- El ABB mostró los productos ordenados por ID.
- El AVL mostró los productos ordenados por stock.
- Los productos con stock crítico fueron identificados correctamente.

**Estado:** Aprobado.

---

### Caso de Prueba 3 - Actualización de stock

**Objetivo:** Verificar sincronización ABB-AVL.

#### Entrada

Producto ID: 30

Nuevo stock: 25

#### Verificación

Buscar nuevamente el producto.

Resultado esperado:

Stock actualizado a 25.

Arbol Balanceado

#### Resultado Obtenido

- El producto ID 30 fue actualizado correctamente.
- El nuevo stock registrado fue 25 unidades.
- El AVL mantuvo su balance luego de la actualización.
- La búsqueda posterior reflejó los cambios realizados.

**Estado:** Aprobado.

---

### Caso de Prueba 4 - Registro de pedidos

**Objetivo:** Verificar funcionamiento FIFO.

#### Pedido 1

ID: 1001

Cliente: Supermercado Norte

Productos:
- 50 (Arroz)
- 30 (Fideos)

#### Pedido 2

ID: 1002

Cliente: Autoservicio Centro

Productos:
- 70 (Aceite)

#### Pedido 3

ID: 1003

Cliente: Mercado Sur

Productos:
- 20 (Harina)
- 40 (Yerba)

#### Verificaciones

- Mostrar pedidos.
- Ver primer pedido.

Resultado esperado:

Primer pedido → 1001

Cantidad → 3

#### Resultado Obtenido

- Los pedidos 1001, 1002 y 1003 fueron registrados correctamente.
- La cola mantuvo el orden de llegada.
- El primer pedido en espera resultó ser el pedido 1001.
- La cantidad total de pedidos almacenados fue 3.

**Estado:** Aprobado.

---

### Caso de Prueba 5 - Registro de movimientos

**Objetivo:** Verificar funcionamiento LIFO y uso de ubicaciones.

#### Movimiento 1

ID Movimiento: 5001

Tipo: Entrada

Producto: 50

Cantidad: 20

Pasillo: 101

Estantería: 1

Nivel: 1

---

#### Movimiento 2

ID Movimiento: 5002

Tipo: Salida

Producto: 30

Cantidad: 5

Pasillo: 102

Estantería: 2

Nivel: 1

---

#### Movimiento 3

ID Movimiento: 5003

Tipo: Entrada

Producto: 70

Cantidad: 15

Pasillo: 105

Estantería: 3

Nivel: 2

#### Verificaciones

- Ver tope.

Resultado esperado:

Movimiento 5003.

- Tamaño de pila.

Resultado esperado:

3 movimientos.

#### Resultado Obtenido

- Los movimientos 5001, 5002 y 5003 fueron registrados correctamente.
- El movimiento ubicado en el tope de la pila fue el 5003.
- El tamaño de la pila resultó ser 3 movimientos.
- Las ubicaciones asociadas a los movimientos fueron registradas correctamente.

**Estado:** Aprobado.

---

### Caso de Prueba 6 - Deshacer movimiento

**Objetivo:** Verificar comportamiento LIFO.

#### Acción

Deshacer último movimiento.

#### Resultado esperado

Movimiento removido:

5003

Nuevo tope:

5002

Tamaño:

2

#### Resultado Obtenido

- El movimiento 5003 fue eliminado correctamente.
- El nuevo tope de la pila pasó a ser el movimiento 5002.
- El tamaño de la pila se redujo a 2 movimientos.
- El comportamiento observado fue consistente con una estructura LIFO.

**Estado:** Aprobado.

---

### Caso de Prueba 7 - Despacho de pedidos

**Objetivo:** Verificar comportamiento FIFO.

#### Acción

Despachar pedido.

#### Resultado esperado

Pedido despachado:

1001

Primer pedido restante:

1002

Cantidad restante:

2

#### Resultado Obtenido

- El pedido 1001 fue despachado correctamente.
- El pedido 1002 pasó a ocupar la primera posición de la cola.
- La cantidad de pedidos pendientes se redujo a 2.
- El comportamiento observado fue consistente con una estructura FIFO.

**Estado:** Aprobado.

---

### Caso de Prueba 8 - Eliminación de registros

**Objetivo:** Verificar eliminación de elementos existentes.

#### Productos

Eliminar ID 30.

Resultado esperado:

Producto no encontrado en búsquedas posteriores.

#### Pasillos

Eliminar pasillo entre conexiones 2 y 3.

Resultado esperado:

No existe pasillo entre 2 y 3.

#### Conexiones

Eliminar conexión 5.

Resultado esperado:

La conexión deja de formar parte del grafo.


#### Resultado Obtenido

- El producto ID 30 fue eliminado correctamente de las estructuras de productos.
- Las búsquedas posteriores confirmaron que el producto ya no existía.
- El pasillo entre las conexiones 2 y 3 fue eliminado correctamente.
- La conexión 5 fue eliminada correctamente del grafo.
- Las relaciones asociadas a la conexión eliminada fueron actualizadas correctamente.

**Estado:** Aprobado.

---

## Resultado General

Se ejecutaron satisfactoriamente los 8 casos de prueba definidos para el sistema.

Todos los módulos implementados (ABB, AVL, Grafo, Cola y Pila) funcionaron según lo esperado, cumpliendo los requerimientos funcionales establecidos para la gestión de productos, pedidos, movimientos de mercadería y representación del almacén.


## Repositorio

https://github.com/BoolianPerez/TpProgra2
