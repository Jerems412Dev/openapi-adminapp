import { Component } from '@angular/core';
import {ProductDTO, ProductsService} from "../../../core/modules/openapi";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-list-product',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './list-product.component.html',
  styleUrl: './list-product.component.css'
})
export class ListProductComponent {
  productList: any | undefined;
  product: ProductDTO | undefined;
  constructor(private productService: ProductsService) {
    this.productList = this.productService.getAllAppProduct(1,1).subscribe({
      next: datas => {
        this.productList = datas.productList;
        //console.log(datas)
      },
      error : err => {
        console.log(err)
      }
    })
  }
}
