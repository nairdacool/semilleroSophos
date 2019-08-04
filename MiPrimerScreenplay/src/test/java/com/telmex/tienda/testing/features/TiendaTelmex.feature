#Author: nairdacool@hotmail.com

Feature: Busqueda de Articulo en Tienda Telmex
 Yo como un usuario con internet
 voy a ingresar a la pagina www.tienda.telmex.com
 y por lo tanto buscar un Articulo

  Scenario: Busqueda articulo en Tienda Telmex
    Given Adrian entro a Tienda Telmex
    When Adrian busca "Lavadora" y agrega una al carrito de compras
    Then Adrian valida que el titulo de la ventana contenga la palabra Lavadora