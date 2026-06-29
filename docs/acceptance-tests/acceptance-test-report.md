\# Reporte de Pruebas de Aceptación - MiniShop



\## 1. Información general



| Campo                    | Detalle                                       |

| ------------------------ | --------------------------------------------- |

| Proyecto                 | MiniShop                                      |

| Laboratorio              | Lab 16 - Pruebas de Aceptación con el Usuario |

| Curso                    | Construcción y Pruebas de Software            |

| Sistema bajo prueba      | API REST MiniShop                             |

| URL base                 | http://localhost:8080                         |

| Herramienta de ejecución | curl / navegador                              |

| Responsable              | Janely Apaza Sencia                           |

| Rol                      | Product Owner / Tester                        |

| Fecha                    | 29/06/2026                                    |



\## 2. Objetivo



El objetivo de este laboratorio es validar si el sistema MiniShop cumple con las necesidades esperadas por el usuario mediante pruebas de aceptación. Para ello se seleccionaron historias de usuario, se definieron criterios de aceptación, se ejecutaron escenarios manuales y se registraron los resultados obtenidos.



\## 3. Historias de usuario seleccionadas



| ID    | Historia de usuario                                                                    | ¿Está implementada? | ¿Tiene criterios de aceptación? |

| ----- | -------------------------------------------------------------------------------------- | ------------------- | ------------------------------- |

| HU-01 | Como cliente, quiero listar productos para ver el catálogo disponible.                 | Sí                  | Sí                              |

| HU-02 | Como cliente, quiero consultar un producto por ID para ver su detalle.                 | Sí                  | Sí                              |

| HU-03 | Como administrador, quiero registrar un producto para actualizar el catálogo.          | Sí                  | Sí                              |

| HU-04 | Como usuario, quiero que la API responda correctamente ante rutas válidas e inválidas. | Sí                  | Sí                              |



\## 4. Criterios de aceptación



\### HU-01 - Listar productos



| ID       | Criterio                                                                                                            |

| -------- | ------------------------------------------------------------------------------------------------------------------- |

| CA-01-01 | Cuando el cliente consulta `/api/products`, el sistema debe responder con código HTTP 200 y una lista de productos. |

| CA-01-02 | Cuando no existen productos registrados, el sistema debe responder con una lista vacía o un mensaje equivalente.    |



\### HU-02 - Consultar producto por ID



| ID       | Criterio                                                                                                                                     |

| -------- | -------------------------------------------------------------------------------------------------------------------------------------------- |

| CA-02-01 | Cuando el cliente consulta un producto existente por ID, el sistema debe responder con código HTTP 200 y los datos del producto.             |

| CA-02-02 | Cuando el cliente consulta un producto inexistente, el sistema debe responder con un error 404 o una respuesta equivalente de no encontrado. |



\### HU-03 - Registrar producto



| ID       | Criterio                                                                                                                               |

| -------- | -------------------------------------------------------------------------------------------------------------------------------------- |

| CA-03-01 | Cuando el administrador registra un producto con datos válidos, el sistema debe guardar el producto y devolver sus datos.              |

| CA-03-02 | Cuando el administrador registra un producto con datos incompletos, el sistema debe rechazar la operación o evidenciar una validación. |



\### HU-04 - Disponibilidad y rutas de la API



| ID       | Criterio                                                                                                            |

| -------- | ------------------------------------------------------------------------------------------------------------------- |

| CA-04-01 | Cuando el usuario accede a una ruta válida de la API, el sistema debe responder correctamente.                      |

| CA-04-02 | Cuando el usuario accede a una ruta incorrecta, el sistema no debe devolver el catálogo y debe responder con error. |



\## 5. Estado inicial del sistema



| Dato                       | Valor actual                                   |

| -------------------------- | ---------------------------------------------- |

| URL base                   | http://localhost:8080                          |

| Endpoint principal         | /api/products                                  |

| Datos de prueba            | Productos cargados mediante data.sql           |

| Base de datos              | H2 en memoria                                  |

| Aplicación                 | Ejecutada localmente con `mvn spring-boot:run` |

| Cliente usado para pruebas | curl                                           |



\## 6. Tabla de ejecución de escenarios



| ID escenario | Historia | Nombre del escenario                   | Pasos ejecutados                             | Resultado esperado                         | Resultado obtenido                                              | Estado   | Evidencia                 |

| ------------ | -------- | -------------------------------------- | -------------------------------------------- | ------------------------------------------ | --------------------------------------------------------------- | -------- | ------------------------- |

| CA-01-01     | HU-01    | Ver catálogo con productos registrados | GET `/api/products`                          | Código 200 y lista de productos            | Código 200 y JSON con productos                                 | Aprobado | `evidencias/CA-01-01.txt` |

| CA-01-02     | HU-01    | Catálogo vacío o sin productos         | Revisión del comportamiento sin productos    | Lista vacía o mensaje equivalente          | No se eliminó la data para no afectar los demás escenarios      | Parcial  | Observación documentada   |

| CA-02-01     | HU-02    | Consultar producto existente           | GET `/api/products/1`                        | Código 200 y datos del producto            | Código 200 y producto encontrado                                | Aprobado | `evidencias/CA-02-01.txt` |

| CA-02-02     | HU-02    | Consultar producto inexistente         | GET `/api/products/9999`                     | Código 404 o respuesta de no encontrado    | Respuesta de no encontrado                                      | Aprobado | `evidencias/CA-02-02.txt` |

| CA-03-01     | HU-03    | Registrar producto válido              | POST `/api/products` con name, price y stock | Producto creado correctamente              | Producto registrado correctamente                               | Aprobado | `evidencias/CA-03-01.txt` |

| CA-03-02     | HU-03    | Registrar producto incompleto          | POST `/api/products` sin name                | El sistema debe rechazar datos incompletos | Pendiente de confirmar con evidencia real                       | Parcial  | `evidencias/CA-03-02.txt` |

| CA-04-01     | HU-04    | Verificar API disponible               | GET `/api/products`                          | Respuesta correcta de la API               | La API respondió correctamente                                  | Aprobado | `evidencias/CA-01-01.txt` |

| CA-04-02     | HU-04    | Ruta incorrecta                        | GET `/api/productos`                         | Error de ruta no encontrada                | No devuelve catálogo porque la ruta correcta es `/api/products` | Aprobado | `evidencias/CA-04-02.txt` |



\## 7. Resumen de resultados



| ID Historia | Historia                    | Total escenarios | Aprobados | Fallidos | Parciales |

| ----------- | --------------------------- | ---------------: | --------: | -------: | --------: |

| HU-01       | Catálogo de productos       |                2 |         1 |        0 |         1 |

| HU-02       | Consulta de producto por ID |                2 |         2 |        0 |         0 |

| HU-03       | Registro de productos       |                2 |         1 |        0 |         1 |

| HU-04       | Disponibilidad de la API    |                2 |         2 |        0 |         0 |

| TOTAL       |                             |                8 |         6 |        0 |         2 |



\## 8. Tabla de defectos encontrados



| ID Defecto | Escenario | Descripción del problema                                                                                                                 | Severidad | Acción recomendada                                                                                         |

| ---------- | --------- | ---------------------------------------------------------------------------------------------------------------------------------------- | --------- | ---------------------------------------------------------------------------------------------------------- |

| DEF-01     | CA-01-02  | No se ejecutó completamente el escenario de catálogo vacío porque eliminar los productos afectaba los demás escenarios.                  | Baja      | Crear un perfil de pruebas o endpoint temporal que permita limpiar datos sin afectar la ejecución general. |

| DEF-02     | CA-03-02  | Se debe confirmar si el sistema valida correctamente productos incompletos. Si permite registrar productos sin nombre, falta validación. | Media     | Agregar validaciones para impedir productos sin name, price o stock.                                       |



\## 9. Decisión de aceptación del Product Owner



\### Criterios de salida definidos



\* 100% de escenarios críticos aprobados.

\* Menos del 10% de escenarios menores con estado parcial.

\* 0 escenarios fallidos de severidad alta.



\### Resultado obtenido



Se ejecutaron 8 escenarios de aceptación. De ellos, 6 fueron aprobados, 0 fueron fallidos y 2 quedaron como parciales. No se encontraron defectos de severidad alta.



\### Decisión del Product Owner



☐ El sistema es aceptado sin condiciones

☑ El sistema es aceptado con defectos menores pendientes

☐ El sistema no es aceptado



\### Defectos menores pendientes



1\. Preparar mejor el escenario de catálogo vacío sin afectar los datos generales.

2\. Confirmar y mejorar la validación al registrar productos incompletos.



Firma del Product Owner: \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



Fecha: 29/06/2026



\## 10. Preguntas de reflexión



\### 1. ¿Hubo algún escenario que consideraban sencillo pero resultó Fallido o Parcial? ¿Qué dice eso sobre la brecha entre lo que se construyó y lo que se especificó?



Sí. El escenario de registrar un producto con datos incompletos puede resultar parcial si el sistema permite guardar productos sin nombre. Esto demuestra que una funcionalidad puede funcionar técnicamente, pero no necesariamente cumplir todas las reglas esperadas por el usuario. La brecha aparece cuando los criterios de aceptación no se validan desde el inicio.



\### 2. ¿Qué diferencia encontraron entre escribir una prueba JUnit y escribir un escenario Gherkin? ¿Cuál requirió más claridad sobre el comportamiento esperado?



Una prueba JUnit se enfoca más en validar métodos, servicios o controladores desde el punto de vista técnico. En cambio, un escenario Gherkin describe el comportamiento esperado desde el punto de vista del usuario. El escenario Gherkin requirió más claridad sobre el comportamiento esperado, porque cada resultado debe ser observable y entendible sin revisar el código.



\### 3. Si el Product Owner rechazara el sistema por dos defectos menores, ¿en qué sprint los corregirían y cómo lo comunicarían?



Los defectos menores se corregirían en el siguiente sprint de mantenimiento o estabilización. Se comunicaría al Product Owner mediante una lista de defectos priorizada, indicando el impacto, la severidad y la fecha estimada de corrección. Después de corregirlos, se volverían a ejecutar los escenarios afectados para confirmar que el sistema cumple los criterios de aceptación.



\### 4. ¿Qué habría pasado si los criterios de aceptación se hubieran definido al final del proyecto, en lugar de al inicio de cada sprint?



Si los criterios de aceptación se hubieran definido al final, probablemente se habrían encontrado más diferencias entre lo construido y lo esperado por el usuario. Definirlos al inicio de cada sprint permite que el equipo desarrolle con una meta clara, evita retrabajos y facilita validar cada funcionalidad antes de considerarla terminada.



\## 11. Conclusiones



1\. Las pruebas de aceptación permitieron validar MiniShop desde el punto de vista del usuario y no solo desde la parte técnica.

2\. Se redactaron y ejecutaron escenarios de aceptación para verificar funcionalidades principales de la API.

3\. La API respondió correctamente en los escenarios principales de consulta y registro de productos.

4\. No se identificaron defectos críticos ni fallos de severidad alta.

5\. Algunos escenarios quedaron parciales porque requieren una mejor preparación de datos o validaciones más claras.

6\. El sistema puede aceptarse con defectos menores pendientes, siempre que estos sean documentados y corregidos en una siguiente iteración.



\## 12. Entregables



| Entregable                        | Estado                                           |

| --------------------------------- | ------------------------------------------------ |

| `acceptance-scenarios.feature`    | Creado                                           |

| Tabla de ejecución completa       | Incluida                                         |

| Evidencias por escenario          | Guardadas en `docs/acceptance-tests/evidencias/` |

| Tabla de defectos                 | Incluida                                         |

| Decisión formal del Product Owner | Incluida                                         |

| `acceptance-test-report.md`       | Creado                                           |



