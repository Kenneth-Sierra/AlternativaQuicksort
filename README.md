# AlternativaQuicksort
# Comparación QuickSort con pivote final vs pivote medio
Se realizaron pruebas utilizando dos variantes del algoritmo QuickSort:
1. Selección del pivote como último elemento.
2. Selección del pivote como elemento central del arreglo.
************************************************************************
Los resultados muestran que cuando el arreglo se encuentra previamente ordenado o en orden inverso, el QuickSort con pivote final presenta tiempos de ejecución mayores debido a divisiones desbalanceadas del arreglo.
El QuickSort con pivote medio en vez genera particiones más equilibradas, reduciendo la profundidad de la recursión y mejorando el rendimiento.
Para arreglos aleatorios ambos algoritmos presentan comportamientos similares, manteniendo una complejidad cercana a O(n log n).
La selección del pivote influye significativamente en el rendimiento práctico del QuickSort.
***********************************************************************
Comparacion:
| Caso        | Pivote Final | Pivote Medio |
| ----------- | ------------ | ------------ |
| Aleatorio   | Similar      | Similar      |
| Ordenado    | Muy lento    | Mucho mejor  |
| Decreciente | Muy lento    | Mejor        |
| Balance     | Malo         | Bueno        |
