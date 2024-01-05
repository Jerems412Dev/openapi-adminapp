export * from './products.service';
import { ProductsService } from './products.service';
export * from './products.serviceInterface';
export * from './roles.service';
import { RolesService } from './roles.service';
export * from './roles.serviceInterface';
export * from './users.service';
import { UsersService } from './users.service';
export * from './users.serviceInterface';
export const APIS = [ProductsService, RolesService, UsersService];