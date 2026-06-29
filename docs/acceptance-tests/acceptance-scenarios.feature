Feature: Pruebas de aceptación de MiniShop

Background:
Given que el sistema MiniShop está en funcionamiento
And la URL base del sistema es "http://localhost:8080"

Scenario: CA-01-01 - Ver catálogo con productos registrados
Given que existen productos registrados en el sistema
When el cliente realiza una petición GET a "/api/products"
Then el sistema responde con código HTTP 200
And la respuesta contiene una lista de productos con id, name, price y stock

Scenario: CA-01-02 - Ver catálogo vacío o sin productos disponibles
Given que no existen productos registrados en el sistema
When el cliente realiza una petición GET a "/api/products"
Then el sistema responde con código HTTP 200
And la respuesta contiene una lista vacía o un mensaje equivalente

Scenario: CA-02-01 - Consultar producto existente por ID
Given que existe un producto con ID 1
When el cliente realiza una petición GET a "/api/products/1"
Then el sistema responde con código HTTP 200
And la respuesta contiene los datos del producto solicitado

Scenario: CA-02-02 - Consultar producto inexistente
Given que no existe un producto con ID 9999
When el cliente realiza una petición GET a "/api/products/9999"
Then el sistema responde con código HTTP 404 o una respuesta equivalente de no encontrado
And no devuelve datos de un producto inexistente

Scenario: CA-03-01 - Registrar producto con datos válidos
Given que el administrador tiene los datos de un nuevo producto
When realiza una petición POST a "/api/products" con name, price y stock válidos
Then el sistema registra el producto
And responde con los datos del producto creado

Scenario: CA-03-02 - Registrar producto con datos incompletos
Given que el administrador intenta registrar un producto sin nombre
When realiza una petición POST a "/api/products" con datos incompletos
Then el sistema debe rechazar la operación o evidenciar una validación
And no debería crear un producto inválido

Scenario: CA-04-01 - Verificar disponibilidad del servicio
Given que MiniShop está desplegado localmente
When el usuario accede a "http://localhost:8080/api/products"
Then el sistema responde correctamente
And la API se encuentra disponible para consultas

Scenario: CA-04-02 - Verificar respuesta ante ruta incorrecta
Given que MiniShop está en funcionamiento
When el usuario realiza una petición GET a "/api/productos"
Then el sistema no debe devolver el catálogo
And debe responder con un error de ruta no encontrada o equivalente
