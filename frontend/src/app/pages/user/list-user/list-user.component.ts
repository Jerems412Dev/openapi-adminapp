import { Component } from '@angular/core';
import {ApiModule, UserDTO, UsersService} from "../../../core/modules/openapi";
import {CommonModule} from "@angular/common";
@Component({
  selector: 'app-list-user',
  standalone: true,
  imports: [CommonModule,ApiModule],
  templateUrl: './list-user.component.html',
  styleUrl: './list-user.component.css',
  providers: [UsersService]
})
export class ListUserComponent {
  userList: any | undefined;
  user: UserDTO | undefined;
  constructor(private userService: UsersService) {
    this.userService.getAllAppUser(0,2).subscribe({
      next: datas => {
        this.userList = datas.userList;
        //console.log(datas)
      },
      error : err => {
        console.log(err)
      }
    })
  }
  ngOnInit(): void {

  }
}
