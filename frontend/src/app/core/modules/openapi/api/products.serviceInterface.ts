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
import { HttpHeaders }                                       from '@angular/common/http';

import { Observable }                                        from 'rxjs';

import { ProductDTO } from '../model/models';
import { ProductResultListByUserDTO } from '../model/models';
import { ProductsResultListDTO } from '../model/models';


import { Configuration }                                     from '../configuration';



export interface ProductsServiceInterface {
    defaultHeaders: HttpHeaders;
    configuration: Configuration;

    /**
     * Add a product
     * 
     * @param productDTO 
     */
    createAppProduct(productDTO?: ProductDTO, extraHttpRequestParams?: any): Observable<ProductDTO>;

    /**
     * Get All Actifs Products
     * 
     * @param currentPage 
     * @param sizePage 
     */
    getAllAppProduct(currentPage: number, sizePage: number, extraHttpRequestParams?: any): Observable<ProductsResultListDTO>;

    /**
     * Get All Actifs Products by user
     * 
     * @param currentPage 
     * @param sizePage 
     */
    getAppAllProductByUser(currentPage: number, sizePage: number, extraHttpRequestParams?: any): Observable<ProductResultListByUserDTO>;

    /**
     * Retrieve an product
     * 
     * @param idProduct 
     */
    getAppProduct(idProduct: number, extraHttpRequestParams?: any): Observable<ProductDTO>;

    /**
     * Add a product
     * 
     * @param idProduct 
     * @param productDTO 
     */
    updateAppProduct(idProduct: number, productDTO?: ProductDTO, extraHttpRequestParams?: any): Observable<ProductDTO>;

}
