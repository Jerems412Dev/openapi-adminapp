import { Component } from '@angular/core';
import { RolesService, RoleDTO} from "../../../core/modules/openapi";
@Component({
  selector: 'app-list-role',
  standalone: true,
  imports: [],
  templateUrl: './list-role.component.html',
  styleUrl: './list-role.component.css'
})
export class ListRoleComponent {
  roleList: any | undefined;
  role: RoleDTO | undefined;
  constructor(private roleService: RolesService) {
    this.roleList = this.roleService.getAllAppRole(1,1).subscribe({
      next: datas => {
        this.roleList = datas.roleList;
        //console.log(datas)
      },
      error : err => {
        console.log(err)
      }
    })
  }

}
