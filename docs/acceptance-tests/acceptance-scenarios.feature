Feature: Pruebas de aceptación de MiniShop

Background:
Given que la aplicación MiniShop está ejecutándose en "http://localhost:8080"
And existen datos de prueba cargados en la base de datos

Scenario: CA-01-01 - Listar productos disponibles
Given que existen productos registrados en MiniShop
When el cliente realiza una petición GET a "/api/products"
Then el sistema responde con código HTTP 200
And la respuesta contiene una lista de productos

Scenario: CA-01-02 - Verificar campos del catálogo
Given que existen productos registrados en MiniShop
When el cliente realiza una petición GET a "/api/products"
Then cada producto de la respuesta contiene los campos id, name, price y stock

Scenario: CA-02-01 - Consultar producto existente por ID
Given que existe un producto con ID 1
When el cliente realiza una petición GET a "/api/products/1"
Then el sistema responde con código HTTP 200
And la respuesta contiene los campos id, name, price y stock del producto

Scenario: CA-02-02 - Consultar producto inexistente
Given que no existe un producto con ID 9999
When el cliente realiza una petición GET a "/api/products/9999"
Then el sistema responde con un error o mensaje de recurso no encontrado
And no devuelve datos de un producto válido

Scenario: CA-03-01 - Registrar producto válido
Given que el administrador tiene los datos válidos de un producto
When realiza una petición POST a "/api/products" con name, price y stock
Then el sistema registra el producto
And responde con los datos del producto creado

Scenario: CA-03-02 - Registrar producto sin nombre
Given que el administrador intenta registrar un producto sin el campo name
When realiza una petición POST a "/api/products" con price y stock
Then el sistema debe rechazar la operación
And no debería registrar un producto incompleto

Scenario: CA-04-01 - Verificar ruta correcta de la API
Given que MiniShop está en funcionamiento
When el usuario accede a "/api/products"
Then el sistema responde correctamente
And se confirma que la ruta oficial de productos está disponible

Scenario: CA-04-02 - Verificar ruta incorrecta
Given que MiniShop está en funcionamiento
When el usuario accede a "/api/productos"
Then el sistema no devuelve el catálogo
And responde con error de ruta no encontrada o equivalente
