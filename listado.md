# Listado de Code Smells, Antipatrones y Técnicas de Refactorización

## Code Smells (22)

1. **Duplicated Code** - Código duplicado en múltiples lugares
2. **Long Method** - Métodos excesivamente largos
3. **Large Classes** - Clases con demasiadas responsabilidades
4. **Long Parameter List** - Lista de parámetros muy extensa
5. **Divergent Change** - Una clase cambia por diferentes razones
6. **Shotgun Surgery** - Un cambio requiere modificar muchas clases
7. **Feature Envy** - Un método usa más de otra clase que de la propia
8. **Data Clumps** - Grupos de datos que siempre aparecen juntos
9. **Primitive Obsession** - Uso excesivo de tipos primitivos
10. **Switch Statements** - Uso excesivo de switch/case
11. **Parallel Inheritance Hierarchies** - Jerarquías de herencia paralelas
12. **Lazy Class** - Clase que no justifica su existencia
13. **Speculative Generality** - Código para funcionalidad futura innecesaria
14. **Temporary Field** - Campos que solo se usan a veces
15. **Message Chain** - Cadenas largas de llamadas a métodos
16. **Middle Man** - Clase que solo delega trabajo
17. **Inappropriate Intimacy** - Clases demasiado acopladas
18. **Alternative Classes with Different Interfaces** - Clases similares con interfaces diferentes
19. **Incomplete Library Class** - Biblioteca que no proporciona toda la funcionalidad necesaria
20. **Data Class** - Clases solo con datos sin comportamiento
21. **Refused Bequest** - Subclase que no usa métodos heredados
22. **Comments** - Comentarios excesivos que indican código poco claro

---

## Antipatrones de Desarrollo (7)

1. **The Blob (God Object)** - Clase monolítica con demasiadas responsabilidades
2. **Lava Flow** - Código obsoleto que permanece en el sistema
3. **Functional Decomposition** - Diseño procedural en lugar de orientado a objetos
4. **Poltergeists** - Clases de vida corta que solo actúan como intermediarios
5. **Golden Hammer** - Usar la misma herramienta/tecnología para todos los problemas
6. **Spaghetti Code** - Código desorganizado y difícil de entender
7. **Copy-And-Paste Programming** - Duplicación de código por copiar y pegar

---

## Técnicas de Refactorización (25)

### Composing Methods (5)
1. **Extract Method** - Extraer fragmento de código a un nuevo método
2. **Inline Method** - Eliminar método trasladando su cuerpo a los invocadores
3. **Replace Temp with Query** - Reemplazar variable temporal con método
4. **Introduce Explaining Variable** - Usar variables con nombres significativos
5. **Replace Method with Method Object** - Convertir método en objeto

### Moving Features (4)
6. **Move Method** - Trasladar método a otra clase
7. **Move Field** - Trasladar campo a otra clase
8. **Extract Class** - Dividir clase en dos
9. **Inline Class** - Fusionar clase en otra

### Organizing Data (1)
10. **Replace Data Value with Object** - Convertir dato simple en objeto

### Generalización (5)
11. **Pull Up Method** - Subir método a la superclase
12. **Pull Down Method** - Bajar método a las subclases
13. **Extract Subclass** - Crear subclase para aspectos específicos
14. **Collapse Hierarchy** - Fusionar clase con su superclase/subclase
15. **Push Down Field** - Bajar campo a las subclases

### Otras Técnicas (10)
16. **Substitute Algorithm** - Reemplazar algoritmo por uno mejor
17. **Introduce Parameter Object** - Agrupar parámetros en un objeto
18. **Preserve Whole Object** - Pasar objeto completo en lugar de valores
19. **Replace Parameter with Method** - Reemplazar parámetro con llamada a método
20. **Decompose Conditional** - Descomponer expresiones condicionales complejas
21. **Replace Type Code with Class** - Reemplazar código de tipo con clase
22. **Replace Type Code with State/Strategy** - Reemplazar código de tipo con patrón State/Strategy
23. **Change Bidirectional Association to Unidirectional** - Simplificar asociaciones
24. **Hide Delegate** - Ocultar delegación
25. **Push Down Method** - Bajar método a las subclases

---

## Resumen

| Categoría | Cantidad |
|-----------|----------|
| Code Smells | 22 |
| Antipatrones | 7 |
| Técnicas de Refactorización | 25 |
| **TOTAL** | **54** |

---

## Referencias

- Fowler, M. (2018). Refactoring: improving the design of existing code. Addison-Wesley Professional.
- Campo, G. D. (2009). Patrones de Diseño, Refactorización y Antipatrones.
- Summary of Refactoring: https://github.com/HugoMatilla/Refactoring-Summary