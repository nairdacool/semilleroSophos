#Author: nairdacool@hotmail.com

Feature: Busqueda de Articulo en Tienda Telmex
 Yo como un usuario con internet
 voy a ingresar a la pagina www.tienda.telmex.com
 y por lo tanto buscar un Articulo

  Scenario: Busqueda articulo en Tienda Telmex
    Given Adrian entro a Tienda Telmex
    When el busca "Lavadora" y agrega una al carrito de compras
    Then el valida que Tienda Telmex solicite iniciar sesion para comprar