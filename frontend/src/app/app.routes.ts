import { Routes } from '@angular/router';
import {AddUserComponent} from "./pages/user/add-user/add-user.component";
import {AddRoleComponent} from "./pages/role/add-role/add-role.component";
import {AddProductComponent} from "./pages/product/add-product/add-product.component";
import {ListUserComponent} from "./pages/user/list-user/list-user.component";
import {ListRoleComponent} from "./pages/role/list-role/list-role.component";
import {ListProductComponent} from "./pages/product/list-product/list-product.component";

export const routes: Routes = [
  { path: 'adduser', component: AddUserComponent },
  { path: 'addrole', component: AddRoleComponent },
  { path: 'addproduct', component: AddProductComponent },
  { path: 'listuser', component: ListUserComponent },
  { path: 'listrole', component: ListRoleComponent },
  { path: 'listproduct', component: ListProductComponent },
];
