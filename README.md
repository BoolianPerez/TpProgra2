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
4. Ejecutar la clase principal correspondiente.








## Repositorio

https://github.com/BoolianPerez/TpProgra2
