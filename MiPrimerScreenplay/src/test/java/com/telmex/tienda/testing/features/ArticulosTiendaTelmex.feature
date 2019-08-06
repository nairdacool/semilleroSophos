#Author: your.email@your.domain.com

Feature: Busqueda de Articulo en Tienda Telmex
 Yo como un usuario con internet
 voy a ingresar a la pagina www.tienda.telmex.com
 y por lo tanto buscar un Articulo

  Scenario Outline: Busqueda articulo en Tienda Telmex
    Given Adrian entro a la pagina de la Tienda Telmex
    When el busca los siguientes articulos y agrega una al carrito de compras
    	| articulo | expected |
    	|<articulo>|<expected>|
    Then el valida que Tienda Telmex solicite iniciar sesion para comprar

    Examples: 
	      | articulo      | expected |
	      | lavadora      |encontrado|
	      | iPhone        |encontrado|
	      | Motocicleta 	|encontrado|
