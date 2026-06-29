\# Reporte de Pruebas de Aceptación - MiniShop



\## 1. Información general



| Campo               | Detalle                                               |

| ------------------- | ----------------------------------------------------- |

| Curso               | Construcción y Pruebas de Software                    |

| Laboratorio         | Laboratorio 16 - Pruebas de Aceptación con el Usuario |

| Proyecto            | MiniShop                                              |

| Sistema bajo prueba | API REST MiniShop                                     |

| URL base            | http://localhost:8080                                 |

| Herramienta usada   | curl                                                  |

| Responsable         | Janely Apaza Sencia                                   |

| Rol                 | Product Owner / Tester                                |

| Fecha               | 29/06/2026                                            |



\## 2. Historias de usuario del proyecto



| ID    | Historia de usuario                                                                    | ¿Está implementada? | ¿Tiene criterios de aceptación escritos? |

| ----- | -------------------------------------------------------------------------------------- | ------------------- | ---------------------------------------- |

| HU-01 | Como cliente, quiero listar productos para ver el catálogo disponible.                 | Sí                  | Sí                                       |

| HU-02 | Como cliente, quiero consultar un producto por ID para revisar su detalle.             | Sí                  | Sí                                       |

| HU-03 | Como administrador, quiero registrar productos para actualizar el catálogo.            | Sí                  | Sí                                       |

| HU-04 | Como usuario, quiero que la API responda correctamente ante rutas válidas e inválidas. | Sí                  | Sí                                       |

| HU-05 | Como cliente, quiero buscar productos por nombre para encontrar productos específicos. | No                  | No                                       |



> Para este laboratorio se seleccionaron 4 historias implementadas: HU-01, HU-02, HU-03 y HU-04.



\## 3. Criterios de aceptación



\### HU-01 - Listar productos



| ID       | Criterio                                                                                                            |

| -------- | ------------------------------------------------------------------------------------------------------------------- |

| CA-01-01 | Cuando el cliente consulta `/api/products`, el sistema debe responder con código HTTP 200 y una lista de productos. |

| CA-01-02 | Cuando el cliente consulta el catálogo, cada producto debe mostrar id, name, price y stock.                         |



\### HU-02 - Consultar producto por ID



| ID       | Criterio                                                                                                                         |

| -------- | -------------------------------------------------------------------------------------------------------------------------------- |

| CA-02-01 | Cuando el cliente consulta un producto existente por ID, el sistema debe responder con código HTTP 200 y los datos del producto. |

| CA-02-02 | Cuando el cliente consulta un producto inexistente, el sistema debe responder con error o mensaje de recurso no encontrado.      |



\### HU-03 - Registrar producto



| ID       | Criterio                                                                                                           |

| -------- | ------------------------------------------------------------------------------------------------------------------ |

| CA-03-01 | Cuando el administrador registra un producto con name, price y stock válidos, el sistema debe guardar el producto. |

| CA-03-02 | Cuando el administrador registra un producto sin name, el sistema debe rechazar la operación.                      |



\### HU-04 - Disponibilidad y rutas



| ID       | Criterio                                                                                                       |

| -------- | -------------------------------------------------------------------------------------------------------------- |

| CA-04-01 | Cuando el usuario consulta `/api/products`, el sistema debe responder correctamente.                           |

| CA-04-02 | Cuando el usuario consulta una ruta incorrecta como `/api/productos`, el sistema no debe devolver el catálogo. |



\## 4. Estado inicial del sistema



| Dato               | Valor actual                           |

| ------------------ | -------------------------------------- |

| URL base           | http://localhost:8080                  |

| Endpoint principal | /api/products                          |

| Base de datos      | H2 en memoria                          |

| Datos de prueba    | Productos cargados en la base de datos |

| Aplicación         | Ejecutada con `mvn spring-boot:run`    |



\## 5. Registro de ejecución de escenarios



| ID escenario | Historia | Nombre del escenario           | Pasos ejecutados                             | Resultado esperado                    | Resultado obtenido | Estado        | Evidencia                 |

| ------------ | -------- | ------------------------------ | -------------------------------------------- | ------------------------------------- | ------------------ | ------------- | ------------------------- |

| CA-01-01     | HU-01    | Listar productos disponibles   | GET `/api/products`                          | HTTP 200 y lista de productos         | Ver evidencia      | Por completar | `evidencias/CA-01-01.txt` |

| CA-01-02     | HU-01    | Verificar campos del catálogo  | GET `/api/products`                          | Productos con id, name, price y stock | Ver evidencia      | Por completar | `evidencias/CA-01-02.txt` |

| CA-02-01     | HU-02    | Consultar producto existente   | GET `/api/products/1`                        | HTTP 200 y datos del producto         | Ver evidencia      | Por completar | `evidencias/CA-02-01.txt` |

| CA-02-02     | HU-02    | Consultar producto inexistente | GET `/api/products/9999`                     | Error o recurso no encontrado         | Ver evidencia      | Por completar | `evidencias/CA-02-02.txt` |

| CA-03-01     | HU-03    | Registrar producto válido      | POST `/api/products` con name, price y stock | Producto creado                       | Ver evidencia      | Por completar | `evidencias/CA-03-01.txt` |

| CA-03-02     | HU-03    | Registrar producto sin nombre  | POST `/api/products` sin name                | Operación rechazada                   | Ver evidencia      | Por completar | `evidencias/CA-03-02.txt` |

| CA-04-01     | HU-04    | Verificar ruta correcta        | GET `/api/products`                          | API disponible                        | Ver evidencia      | Por completar | `evidencias/CA-04-01.txt` |

| CA-04-02     | HU-04    | Verificar ruta incorrecta      | GET `/api/productos`                         | Error de ruta no encontrada           | Ver evidencia      | Por completar | `evidencias/CA-04-02.txt` |



\## 6. Resumen de resultados



| ID Historia | Historia                    | Total escenarios |     Aprobados |      Fallidos |     Parciales |

| ----------- | --------------------------- | ---------------: | ------------: | ------------: | ------------: |

| HU-01       | Catálogo de productos       |                2 | Por completar | Por completar | Por completar |

| HU-02       | Consulta de producto por ID |                2 | Por completar | Por completar | Por completar |

| HU-03       | Registro de productos       |                2 | Por completar | Por completar | Por completar |

| HU-04       | Disponibilidad de la API    |                2 | Por completar | Por completar | Por completar |

| TOTAL       |                             |                8 | Por completar | Por completar | Por completar |



\## 7. Tabla de defectos encontrados



| ID Defecto | Escenario fallido | Descripción del problema           | Severidad     | Acción recomendada |

| ---------- | ----------------- | ---------------------------------- | ------------- | ------------------ |

| DEF-01     | Por completar     | Por completar según evidencia real | Por completar | Por completar      |

| DEF-02     | Por completar     | Por completar según evidencia real | Por completar | Por completar      |



\## 8. Decisión de aceptación del Product Owner



\### Criterios de salida



\* 100% de escenarios críticos aprobados.

\* Menos del 10% de escenarios menores con estado parcial.

\* 0 escenarios fallidos de severidad alta.



\### Resultado obtenido



Resultado por completar después de revisar las evidencias generadas en `docs/acceptance-tests/evidencias/`.



\### Decisión del Product Owner



☐ El sistema es aceptado sin condiciones

☐ El sistema es aceptado con defectos menores pendientes

☐ El sistema no es aceptado



Firma del Product Owner: \_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_



Fecha: 29/06/2026



\## 9. Preguntas de reflexión



\### 1. ¿Hubo algún escenario que consideraban sencillo pero resultó Fallido o Parcial? ¿Qué dice eso sobre la brecha entre lo que se construyó y lo que se especificó?



Sí. Un escenario que puede resultar parcial o fallido es el registro de un producto sin nombre. Aunque el sistema permite registrar productos con datos válidos, también debe validar correctamente los datos incompletos. Esto demuestra que una funcionalidad puede estar construida, pero no necesariamente cubrir todos los casos esperados por el usuario.



\### 2. ¿Qué diferencia encontraron entre escribir una prueba JUnit y escribir un escenario Gherkin? ¿Cuál requirió más claridad sobre el comportamiento esperado?



Una prueba JUnit valida el comportamiento desde una perspectiva técnica, normalmente revisando métodos, servicios o controladores. En cambio, un escenario Gherkin se redacta desde la perspectiva del usuario y describe un comportamiento observable. El escenario Gherkin requiere más claridad sobre lo que el usuario espera ver como resultado.



\### 3. Si el Product Owner rechazara el sistema por dos defectos menores, ¿en qué sprint los corregirían y cómo lo comunicarían?



Los defectos menores se corregirían en el siguiente sprint de estabilización. Se comunicarían mediante una tabla de defectos con su severidad, impacto y acción recomendada. Luego se volverían a ejecutar los escenarios afectados para confirmar que fueron corregidos.



\### 4. ¿Qué habría pasado si los criterios de aceptación se hubieran definido al final del proyecto, en lugar de al inicio de cada sprint?



Si los criterios se hubieran definido al final, se habrían encontrado diferencias más tarde entre lo construido y lo esperado. Esto generaría retrabajo y retrasos. Definir criterios al inicio ayuda a que el equipo desarrolle con una meta clara y permite validar cada funcionalidad antes de considerarla terminada.



\## 10. Conclusiones



1\. Se identificaron historias de usuario implementadas en MiniShop.

2\. Se redactaron criterios de aceptación verificables y orientados al usuario.

3\. Se convirtieron los criterios a escenarios Given-When-Then usando Gherkin.

4\. Se prepararon comandos curl para ejecutar los escenarios manualmente.

5\. Se creó una estructura de evidencias para registrar las respuestas reales del sistema.

6\. La decisión final de aceptación debe completarse después de revisar las evidencias reales.



\## 11. Entregables



| Entregable                        | Estado                                           |

| --------------------------------- | ------------------------------------------------ |

| `acceptance-scenarios.feature`    | Creado                                           |

| Tabla de ejecución completa       | Incluida                                         |

| Evidencias por escenario          | Guardadas en `docs/acceptance-tests/evidencias/` |

| Tabla de defectos                 | Incluida                                         |

| Decisión formal del Product Owner | Pendiente de marcar según evidencias             |

| `acceptance-test-report.md`       | Creado                                           |



