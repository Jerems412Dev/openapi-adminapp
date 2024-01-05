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

import { RoleDTO } from '../model/models';
import { RolesResultListDTO } from '../model/models';


import { Configuration }                                     from '../configuration';



export interface RolesServiceInterface {
    defaultHeaders: HttpHeaders;
    configuration: Configuration;

    /**
     * Add a role
     * 
     * @param roleDTO 
     */
    createAppRole(roleDTO?: RoleDTO, extraHttpRequestParams?: any): Observable<RoleDTO>;

    /**
     * Get All Actifs Roles
     * 
     * @param currentPage 
     * @param sizePage 
     */
    getAllAppRole(currentPage: number, sizePage: number, extraHttpRequestParams?: any): Observable<RolesResultListDTO>;

    /**
     * Retrieve an role
     * 
     * @param idRole 
     */
    getAppRole(idRole: number, extraHttpRequestParams?: any): Observable<RoleDTO>;

    /**
     * Add a role
     * 
     * @param idRole 
     * @param roleDTO 
     */
    updateAppRole(idRole: number, roleDTO?: RoleDTO, extraHttpRequestParams?: any): Observable<RoleDTO>;

}
