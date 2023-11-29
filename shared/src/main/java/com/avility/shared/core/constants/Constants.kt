package com.avility.shared.core.constants

object Constants {
    // id del sitio en donde se harán las busquedas por defecto será colombia
    const val DEFAULT_SITE_ID = "MCO"

    // base url para conectarme a la API de mercado libre
    const val BASE_URL_API_MELI = "https://api.mercadolibre.com/"

    // para determinar la cantidad de registros por pagina y controlar la paginación
    const val INCREMENT_OFFSET = 50

    // parametro para el detalle del product
    const val PARAM_PRODUCT_ID = "productId"


    /**
     * Constantes para errores genericos
     */
    const val GENERIC_ERROR = "Lo sentimos esta expreimentado fallas, por favor intentalo de nuevo en unos minutos ..."
    const val NETWORK_ERROR = "¿ Tienes conexión a internet ?, es posible que estes navegando con una red inestable"
}