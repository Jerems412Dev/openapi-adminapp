/**
 * API Admin-app
 * Microservice pour une admin-app de openAPI
 *
 * The version of the OpenAPI document: 1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { ProductDTO } from './product-dto';


export interface ProductResultListByUserDTO { 
    /**
     * Fonctionnel id of the user
     */
    idUser?: number;
    /**
     * The List of the ProductResultDTO by user
     */
    productList?: Array<ProductDTO>;
}
